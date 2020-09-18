using System;
using System.Collections.Generic;

namespace POD.Models.DBModels
{
    public partial class Cliente
    {
        public Cliente()
        {
            Articolo = new HashSet<Articolo>();
        }

        public int Id { get; set; }
        public string Nome { get; set; }
        public string Cognome { get; set; }
        public string Indirizzo { get; set; }
        public int? Iduser { get; set; }

        public virtual Utente IdNavigation { get; set; }
        public virtual ICollection<Articolo> Articolo { get; set; }
    }
}
