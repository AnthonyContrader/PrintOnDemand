using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Tipologia : BaseModel
    {
    public string NomeTipologia { get; set; }
    public IList<Esercizio> EserciziPerTipologia { get; set; }
    }
}
