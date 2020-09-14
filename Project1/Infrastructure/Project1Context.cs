using Microsoft.EntityFrameworkCore;
using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Infrastructure
{
    public class Project1Context : DbContext
    {
        private DbContextOptions<Project1Context> _optionsBuilder;

        public DbSet<UserItem> Users { get; set; }

        public Project1Context(DbContextOptions<Project1Context> options)
            : base(options)
        {
            _optionsBuilder = options;
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=sqldata;Database=Project1Demo;User ID=sa;Password=Contrader2020;MultipleActiveResultSets=true",
          sqlServerOptionsAction: sqlOptions =>
          {
                    /*sqlOptions.MigrationsAssembly(
                        typeof(Startup).GetTypeInfo().Assembly.GetName().Name);*/

                    //Configuring Connection Resiliency:
                    sqlOptions.
                  EnableRetryOnFailure(maxRetryCount: 5,
                  maxRetryDelay: TimeSpan.FromSeconds(30),
                  errorNumbersToAdd: null);

          });
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<UserItem>(entity =>
            {
                entity.ToTable("User");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Name).HasMaxLength(50);
                entity.Property(e => e.Surname).HasMaxLength(50);
                entity.Property(e => e.Login).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Password).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Age);
                entity.Property(e => e.Email).HasMaxLength(50);
                entity.Property(e => e.Address).HasMaxLength(200);
                entity.Property(e => e.IsAdmin).HasDefaultValue(false);
                entity.HasMany(c => c.Reviews).WithOne(e => e.User).HasForeignKey(e => e.UserId);
            });

            modelBuilder.Entity<Localita>(entity =>
            {
                entity.ToTable("Localita");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Citta).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Provincia).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Stato).HasMaxLength(50).IsRequired();
                entity.HasMany(l => l.EserciziPerLocalita).WithOne(e => e.Localita).HasForeignKey(e => e.LocalitaId);
            });

            modelBuilder.Entity<Tipologia>(entity =>
            {
                entity.ToTable("Tipologia");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.NomeTipologia).HasMaxLength(50).IsRequired();
                entity.HasMany(d => d.EserciziPerTipologia).WithOne(e => e.Tipologia).HasForeignKey(e => e.TipologiaId);
            });

            modelBuilder.Entity<Esercizio>(entity =>
            {
                entity.ToTable("Esercizio");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Nome).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Indirizzo).HasMaxLength(150).IsRequired();
                entity.Property(e => e.PrezzoMedio).IsRequired();
                entity.HasMany(r => r.Reviews).WithOne(e => e.Esercizio).HasForeignKey(e => e.EsercizioId);


            });

            modelBuilder.Entity<Review>(entity =>
            {
                entity.ToTable("Review");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Titolo).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Testo).HasMaxLength(280).IsRequired();
                entity.Property(e => e.Voto).IsRequired();
            });
        }
    }
}
