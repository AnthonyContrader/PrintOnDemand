using System;
using System.Collections.Generic;

namespace POD.Models.DBModels
{
    public partial class Articolo
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Descrizione { get; set; }
        public string Tipo { get; set; }
        public string Colore { get; set; }
        public string Taglia { get; set; }
        public string Immagine { get; set; }
        public string Link { get; set; }
        public string Data { get; set; }
        public string Prezzo { get; set; }
        public int? Idcliente { get; set; }

        public virtual Cliente IdclienteNavigation { get; set; }
    }
}
