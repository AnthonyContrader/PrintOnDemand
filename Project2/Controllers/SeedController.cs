using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using Project2.IServices;
using Shared.Model;
using Shared.Services;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;

namespace Project2.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class SeedController : ControllerBase
    {
        private readonly IHttpClientFactory _clientFactory;

        public SeedController(IHttpClientFactory clientFactory)
        {
            _clientFactory = clientFactory;
        }

        [Route("/api/v1/[controller]/seed")]
        [HttpPost]
        public async Task<List<UserItem>> Seed([FromBody] dynamic data)
        {
            int randomUser = data.randomUser;

            if (randomUser <= 0)
                throw new Exception("randomUser must be grater than 0");

            var client = _clientFactory.CreateClient("Project1Service");
            IProject1Service service = new Project1Service(client);
            return await service.CreateSeedUserAsync(randomUser);
        }
    }
}
