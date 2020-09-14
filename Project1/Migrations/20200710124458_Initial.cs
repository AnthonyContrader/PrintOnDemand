using Microsoft.EntityFrameworkCore.Migrations;

namespace Project1.Migrations
{
    public partial class Initial : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Localita",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Citta = table.Column<string>(maxLength: 50, nullable: false),
                    Provincia = table.Column<string>(maxLength: 50, nullable: false),
                    Stato = table.Column<string>(maxLength: 50, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Localita", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Tipologia",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    NomeTipologia = table.Column<string>(maxLength: 50, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tipologia", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "User",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Surname = table.Column<string>(maxLength: 50, nullable: true),
                    Name = table.Column<string>(maxLength: 50, nullable: true),
                    Login = table.Column<string>(maxLength: 50, nullable: false),
                    Password = table.Column<string>(maxLength: 50, nullable: false),
                    Age = table.Column<int>(nullable: true),
                    Address = table.Column<string>(maxLength: 200, nullable: true),
                    Email = table.Column<string>(maxLength: 50, nullable: true),
                    IsAdmin = table.Column<bool>(nullable: false, defaultValue: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_User", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Esercizio",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Nome = table.Column<string>(maxLength: 50, nullable: false),
                    Indirizzo = table.Column<string>(maxLength: 150, nullable: false),
                    PrezzoMedio = table.Column<double>(nullable: false),
                    LocalitaId = table.Column<int>(nullable: false),
                    TipologiaId = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Esercizio", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Esercizio_Localita_LocalitaId",
                        column: x => x.LocalitaId,
                        principalTable: "Localita",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Esercizio_Tipologia_TipologiaId",
                        column: x => x.TipologiaId,
                        principalTable: "Tipologia",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Review",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Titolo = table.Column<string>(maxLength: 50, nullable: false),
                    Testo = table.Column<string>(maxLength: 280, nullable: false),
                    Voto = table.Column<int>(nullable: false),
                    UserId = table.Column<int>(nullable: false),
                    EsercizioId = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Review", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Review_Esercizio_EsercizioId",
                        column: x => x.EsercizioId,
                        principalTable: "Esercizio",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Review_User_UserId",
                        column: x => x.UserId,
                        principalTable: "User",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Esercizio_LocalitaId",
                table: "Esercizio",
                column: "LocalitaId");

            migrationBuilder.CreateIndex(
                name: "IX_Esercizio_TipologiaId",
                table: "Esercizio",
                column: "TipologiaId");

            migrationBuilder.CreateIndex(
                name: "IX_Review_EsercizioId",
                table: "Review",
                column: "EsercizioId");

            migrationBuilder.CreateIndex(
                name: "IX_Review_UserId",
                table: "Review",
                column: "UserId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Review");

            migrationBuilder.DropTable(
                name: "Esercizio");

            migrationBuilder.DropTable(
                name: "User");

            migrationBuilder.DropTable(
                name: "Localita");

            migrationBuilder.DropTable(
                name: "Tipologia");
        }
    }
}
