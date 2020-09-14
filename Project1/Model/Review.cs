using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Review : BaseModel
    {
        public string Titolo { get; set; }
        public string Testo { get; set; }
        public int Voto { get; set; }
        public int UserId { get; set; }
        public UserItem User { get; set; }
        public int EsercizioId { get; set; }
        public Esercizio Esercizio { get; set; }
    }
}
