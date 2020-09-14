using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using Project1.DTO;
using Project1.Infrastructure;
using Project1.Model;
using Project1.Repository;

namespace Project1.Controllers
{
    public class ReviewController
    {
        private readonly Project1Context _context;

        public ReviewController(Project1Context context)
        {
            _context = context;
        }
        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public ReviewsDto Create([FromBody] dynamic review)
        {
            ReviewsDto reviewDto = JsonConvert.DeserializeObject<ReviewsDto>(review.ToString());

            Review reviews = reviewDto.ConvertTo();
            ReviewRepository reviewRepository = new ReviewRepository(_context);
            reviews = reviewRepository.Insert(reviews);
            return ReviewsDto.ConvertFrom(reviews);
        }

        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getreviews")]
        [HttpGet]
        public List<ReviewsDto> GetReview()
        {
            ReviewRepository reviewRepository = new ReviewRepository(_context);
            var reviews = reviewRepository.GetAll().AsNoTracking();
            List<ReviewsDto> reviewDto = new List<ReviewsDto>();
            foreach (var review in reviews)
            {
                reviewDto.Add(ReviewsDto.ConvertFrom(review));
            }

            return reviewDto;
        }

        [Route("/api/v1/[controller]/deleteReview")]
        [HttpDelete]
        public HttpResponseMessage DeleteReview(int id)
        {
            ReviewRepository reviewRepository = new ReviewRepository(_context);
            reviewRepository.Delete(id);

            return new HttpResponseMessage(System.Net.HttpStatusCode.OK);
        }

        //[Route("/api/v1/[controller]/getlocalitabylogin")]
        //[HttpPost]
        /*public LocalitaDto GetLocalitaById([FromBody] dynamic loginData)
        {
            dynamic data = loginData;

            string login = data.Login;
            string password = data.Password;

            UserRepository userRepository = new UserRepository(_context);
            UserItem user = userRepository.GetByLogin(login, password);

            UserDto userDto = null;
            if (user != null)
            {
                userDto = UserDto.ConvertFrom(user);
            }

            return userDto;
        }*/
    }
}

