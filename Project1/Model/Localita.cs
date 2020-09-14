using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Localita : BaseModel
    {
        public string Citta { get; set; }
        public string Provincia { get; set; }
        public string Stato { get; set; }
        public IList<Esercizio> EserciziPerLocalita { get; set; }

    }
}
