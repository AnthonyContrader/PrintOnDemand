using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
	public class LocalitaDto
	{
		public int? Id { get; set; }
		public string Citta { get; set; }
		public string Provincia { get; set; }
		public string Stato { get; set; }

        public Localita ConvertTo()
        {
            return new Localita
            {
                Id = this.Id,
                Citta = this.Citta,
                Provincia = this.Provincia,
                Stato = this.Stato
            };
        }
        public static LocalitaDto ConvertFrom(Localita localita)
        {
            return new LocalitaDto
            {
                Id = localita.Id,
                Citta = localita.Citta,
                Provincia = localita.Provincia,
                Stato = localita.Stato,
            };
        }
    }
}
