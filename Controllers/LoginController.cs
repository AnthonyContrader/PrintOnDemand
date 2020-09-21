using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using POD.Models.DBModels;
using Microsoft.AspNetCore.Cors;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace POD.Controllers
{
    [Route("api")]
    [ApiController]
    [EnableCors("Policy1")]
    public class LoginController : ControllerBase
    {
        private sampledbContext _context;

        public LoginController(sampledbContext context)
        {
            this._context = context;
        }
       

        [HttpPost("login")]
        public ActionResult<Utente> Get(Utente login)
        {
            List<Utente> u = _context.Utente.ToList();
            for (int i = 0; i < u.Count; i++)
            {
                if (u[i].Username == login.Username && u[i].Password == login.Password) return Ok(u[i]);
            }
            return NotFound();
        }

        [HttpPost("insert")]
        public void Insert(Utente u)
        {
            _context.Utente.Add(u);
            _context.SaveChanges();
        }


    }
}
