using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using POD.Models.DBModels;
using Microsoft.AspNetCore.Cors;
using Newtonsoft.Json;
using System.Windows.Markup;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace POD.Controllers
{
    [Route("api/clienti")]
    [ApiController]
    [EnableCors("Policy1")]
    public class ClientiController : ControllerBase
    {

        private sampledbContext _context;

        public ClientiController(sampledbContext context)
        {
            this._context = context;
        }
        // GET: api/<ClientiController>
        [HttpGet]
        public ActionResult<IEnumerable<Cliente>> Get()
        {
            var c = _context.Cliente.ToList();
            return Ok(c);
        }

        // GET api/<ClientiController>/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<ClientiController>
        [HttpPost("add")]
        public void Post([FromBody] Cliente value)
        {

            _context.Cliente.Add(value);
            _context.SaveChanges();
        }   

        // PUT api/<ClientiController>/5
        [HttpPut("edit")]
        public void Put([FromBody] Cliente u)
        {
            _context.Cliente.Update(u);
            _context.SaveChanges();
        }

        // DELETE api/<ClientiController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            Cliente u = _context.Cliente.Find(id);
            _context.Cliente.Remove(u);
            _context.SaveChanges();
        }
    }
}
