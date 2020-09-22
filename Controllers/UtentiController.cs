using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using POD.Models.DBModels;
using POD.Models;
using Microsoft.AspNetCore.Cors;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace POD.Controllers
{

    [ApiController]
    [Route("api/utenti")]
    [EnableCors("Policy1")]
    
    public class UtentiController : ControllerBase
    {
        private sampledbContext _context;

        public UtentiController(sampledbContext context)
        {
            this._context = context;
        }
        // GET: api/<UtentiController>
        [HttpGet]
        public ActionResult<IEnumerable<Utente>> Get()
        {
            var utenti = _context.Utente.ToList();
            
            return Ok(utenti);
        }

        // GET api/<UtentiController>/5
        [HttpGet("{id}")]
        public ActionResult<Utente> Get(int id)
        {
            Utente u =  _context.Utente.Find(id);
            return Ok(u);
        }

        // POST api/<UtentiController>
        [HttpPost]
        public void Post([FromBody] Utente value)
        {

            _context.Utente.Add(value);
            _context.SaveChanges();
        }

        // PUT api/<UtentiController>/5
        [HttpPut("{u}")]
        public void Put(Utente u)
        {
            /*List<Utente> u = _context.Utente.ToList();
            for(int i=0; i<u.Count; i++)
            {
                if (u[i].Username == value) return value;
            }*/

            _context.Utente.Update(u);

        }

        // DELETE api/<UtentiController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            Utente u = _context.Utente.Find(id);
            _context.Utente.Remove(u);
        }


    }
}
