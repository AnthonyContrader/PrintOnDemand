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
    public class EsercizioController
    {

        private readonly Project1Context _context;

        public EsercizioController(Project1Context context)
        {
            _context = context;
        }
        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public EsercizioDto Create([FromBody] dynamic esercizio)
        {
            EsercizioDto esercizioDto = JsonConvert.DeserializeObject<EsercizioDto>(esercizio.ToString());

            Esercizio esercizios = esercizioDto.ConvertTo();
            EsercizioRepository esercizioRepository = new EsercizioRepository(_context);
            esercizios = esercizioRepository.Insert(esercizios);
            return EsercizioDto.ConvertFrom(esercizios);
        }

        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getesercizios")]
        [HttpGet]
        public List<EsercizioDto> GetEsercizio()
        {
            EsercizioRepository esercizioRepository = new EsercizioRepository(_context);
            var esercizios = esercizioRepository.GetAll().AsNoTracking();
            List<EsercizioDto> esercizioDto = new List<EsercizioDto>();
            foreach (var esercizio in esercizios)
            {
                esercizioDto.Add(EsercizioDto.ConvertFrom(esercizio));
            }

            return esercizioDto;
        }

        [Route("/api/v1/[controller]/deleteEsercizio")]
        [HttpDelete]
        public HttpResponseMessage DeleteEsercizio(int id)
        {
            EsercizioRepository esercizioRepository = new EsercizioRepository(_context);
            esercizioRepository.Delete(id);

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

