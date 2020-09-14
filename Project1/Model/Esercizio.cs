using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Esercizio : BaseModel
    {
        public string Nome { get; set; }
        public string Indirizzo { get; set; }
        public double PrezzoMedio { get; set; }
        public int LocalitaId { get; set; }
        public Localita Localita { get; set; }
        public int TipologiaId { get; set; }
        public Tipologia Tipologia { get; set; }
        public IList<Review> Reviews { get; set; }
    }
}
