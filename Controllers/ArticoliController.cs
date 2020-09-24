using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using POD.Models.DBModels;
using Microsoft.AspNetCore.Cors;
using Newtonsoft.Json;
using System.Windows.Markup;
using Microsoft.AspNetCore.Http;
using System.IO;
using System.CodeDom.Compiler;
using System.Configuration;
using Newtonsoft.Json.Linq;
using System.Reflection.Metadata;
using System.Net;
using System.Security.Principal;
using System.Web;



// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace POD.Controllers
{
    [Route("api/articoli")]
    [ApiController]
    public class ArticoliController : ControllerBase
    {

        private sampledbContext _context;

        public ArticoliController(sampledbContext context)
        {
            this._context = context;
        }
        // GET: api/<ArticoliController>
        [HttpGet]
        public ActionResult<IEnumerable<Articolo>> Get()
        {
            var a = _context.Articolo.ToList();
            return Ok(a);
        }

        // GET api/<ArticoliController>/5
        [HttpGet("{id}")]
        public ActionResult<Articolo> Get(int id)
        {
            Articolo u = _context.Articolo.Find(id);
            return Ok(u);
        }


        [HttpPost("add")]
        public void Post([FromBody] Articolo value)
        {

            _context.Articolo.Add(value);
            _context.SaveChanges();
        }

        // PUT api/<ArticoliController>/5
        [HttpPut("edit")]
        public void Put([FromBody] Articolo u)
        {
            _context.Articolo.Update(u);
            _context.SaveChanges();
        }

        // DELETE api/<ArticoliController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            Articolo u = _context.Articolo.Find(id);
            _context.Articolo.Remove(u);
            _context.SaveChanges();
        }

        [HttpPost("upload")]
         public void Upload()
        {
            IFormFile fileT = Request.Form.Files[0];
            string path = "immaginisalvate/" + DateTime.Now.ToString("yyyy-MM-dd-HH-mm-ss") + "/";
            Directory.CreateDirectory(path);
            path +=  fileT.FileName.ToString();
            string img = Path.GetFullPath(path);
            using (var stream = new FileStream(path, FileMode.CreateNew)) {
                fileT.CopyTo(stream);
            }
        }

        /*[HttpGet("immaginisalvate/{data}/{imgfile}")]
        public byte[] GetImg(string data, string imgfile)
        {
            
            using (var webclient = new WebClient())
            {
                byte[] imgbyte = webclient.DownloadData("immaginisalvate/" + data + "/" +imgfile);
                return imgbyte;
                
            }
        }
        */
    }
}
