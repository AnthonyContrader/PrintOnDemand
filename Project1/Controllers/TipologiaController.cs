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
    public class TipologiaController
    {

        private readonly Project1Context _context;

        public TipologiaController(Project1Context context)
        {
            _context = context;
        }
        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public TipologiaDto Create([FromBody] dynamic tipologia)
        {
            TipologiaDto tipologiaDto = JsonConvert.DeserializeObject<TipologiaDto>(tipologia.ToString());

            Tipologia tipologias = tipologiaDto.ConvertTo();
            TipologiaRepository tipologiaRepository = new TipologiaRepository(_context);
            tipologias = tipologiaRepository.Insert(tipologias);
            return TipologiaDto.ConvertFrom(tipologias);
        }

        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/gettipologias")]
        [HttpGet]
        public List<TipologiaDto> GetTipologia()
        {
            TipologiaRepository tipologiaRepository = new TipologiaRepository(_context);
            var tipologias = tipologiaRepository.GetAll().AsNoTracking();
            List<TipologiaDto> tipologiaDto = new List<TipologiaDto>();
            foreach (var tipologia in tipologias)
            {
                tipologiaDto.Add(TipologiaDto.ConvertFrom(tipologia));
            }

            return tipologiaDto;
        }

        [Route("/api/v1/[controller]/deleteTipologia")]
        [HttpDelete]
        public HttpResponseMessage DeleteTipologia(int id)
        {
            TipologiaRepository tipologiaRepository = new TipologiaRepository(_context);
            tipologiaRepository.Delete(id);

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

