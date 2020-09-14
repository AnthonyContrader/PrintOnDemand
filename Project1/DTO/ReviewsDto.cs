using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
	public class ReviewsDto
	{
		public int? Id { get; set; }
        public string Titolo { get; set; }
        public string Testo { get; set; }
        public int Voto { get; set; }
        public int UserId { get; set; }
        public UserItem User { get; set; }
        public int EsercizioId { get; set; }
        public Esercizio Esercizio { get; set; }

        public Review ConvertTo()
        {
            return new Review
            {
                Id = this.Id,
                Titolo = this.Titolo,
                Testo = this.Testo,
                Voto = this.Voto,
                UserId = this.UserId,
                User = this.User,
                EsercizioId = this.EsercizioId,
                Esercizio = this.Esercizio
            };
        }
        public static ReviewsDto ConvertFrom(Review review)
        {
            return new ReviewsDto
            {
                Id = review.Id,
                Titolo = review.Titolo,
                Testo = review.Testo,
                Voto = review.Voto,
                UserId = review.UserId,
                User = review.User,
                EsercizioId = review.EsercizioId,
                Esercizio = review.Esercizio
            };
        }
    }
}
