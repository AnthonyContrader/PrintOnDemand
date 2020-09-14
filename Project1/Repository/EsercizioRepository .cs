using Project1.Infrastructure;
using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Repository
{
    public class EsercizioRepository : BaseRepositoty<Esercizio>
    {
        public EsercizioRepository(Project1Context context) : base(context)
        {
        }
    }
}
