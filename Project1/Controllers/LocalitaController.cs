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

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Project1.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LocalitaController : ControllerBase
    {
        // GET: api/<LocalitaController>
        //[HttpGet]

        private readonly Project1Context _context;

        public LocalitaController(Project1Context context)
        {
            _context = context;
        }
        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public LocalitaDto Create([FromBody] dynamic localita)
        {
            LocalitaDto localitaDto = JsonConvert.DeserializeObject<LocalitaDto>(localita.ToString());

            Localita localitas = localitaDto.ConvertTo();
            LocalitaRepository localitaRepository = new LocalitaRepository(_context);
            localitas = localitaRepository.Insert(localitas);
            return LocalitaDto.ConvertFrom(localitas);
        }

        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getusers")]
        [HttpGet]
        public List<LocalitaDto> GetLocalita()
        {
            LocalitaRepository localitaRepository = new LocalitaRepository(_context);
            var localitas = localitaRepository.GetAll().AsNoTracking();
            List<LocalitaDto> localitaDto = new List<LocalitaDto>();
            foreach (var localita in localitas)
            {
                localitaDto.Add(LocalitaDto.ConvertFrom(localita));
            }

            return localitaDto;
        }

        [Route("/api/v1/[controller]/deleteUser")]
        [HttpDelete]
        public HttpResponseMessage DeleteLocalita(int id)
        {
            LocalitaRepository localitaRepository = new LocalitaRepository(_context);
            localitaRepository.Delete(id);

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
