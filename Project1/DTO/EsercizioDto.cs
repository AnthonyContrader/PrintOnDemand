using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
	public class EsercizioDto
	{
		public int? Id { get; set; }
        public string Nome { get; set; }
        public string Indirizzo { get; set; }
        public double PrezzoMedio { get; set; }
        public int LocalitaId { get; set; }
        public Localita Localita { get; set; }
        public int TipologiaId { get; set; }
        public Tipologia Tipologia { get; set; }

        public Esercizio ConvertTo()
        {
            return new Esercizio
            {
                Id = this.Id,
                Nome = this.Nome,
                Indirizzo = this.Indirizzo,
                PrezzoMedio = this.PrezzoMedio,
                LocalitaId = this.LocalitaId,
                Localita = this.Localita,
                TipologiaId = this.TipologiaId,
                Tipologia = this.Tipologia
            };
        }
        public static EsercizioDto ConvertFrom(Esercizio esercizio)
        {
            return new EsercizioDto
            {
                Id = esercizio.Id,
                Nome = esercizio.Nome,
                Indirizzo = esercizio.Indirizzo,
                PrezzoMedio = esercizio.PrezzoMedio,
                LocalitaId = esercizio.LocalitaId,
                Localita = esercizio.Localita,
                TipologiaId = esercizio.TipologiaId,
                Tipologia = esercizio.Tipologia

            };
        }

    }
}
