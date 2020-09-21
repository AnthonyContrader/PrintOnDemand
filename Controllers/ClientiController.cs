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
    [Route("api/clientes")]
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
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/<ClientiController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<ClientiController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
