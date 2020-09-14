using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.IdentityModel.Tokens;
using Newtonsoft.Json;
using Project1.Infrastructure;
using Project1.Repository;
using System;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

namespace Project1.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class TokenController : ControllerBase
    {
        public IConfiguration _configuration;
        private readonly Project1Context _context;

        public TokenController(Project1Context context, IConfiguration configuration)
        {
            _context = context;
            _configuration = configuration;
        }

        [Route("/api/v1/[controller]")]
        [HttpPost]
        public IActionResult Post([FromBody] dynamic data)
        {
            dynamic userData = JsonConvert.DeserializeObject<dynamic>(data.ToString());

            if (userData != null && userData.Login != null && userData.Password != null)
            {
                string login = userData.Login;
                string password = userData.Password;

                UserRepository userRepository = new UserRepository(_context);
                var user = userRepository.GetByLogin(login, password);

                if (user != null)
                {
                    //create claims details based on the user information
                    var claims = new[] {
                    new Claim(JwtRegisteredClaimNames.Sub, _configuration["Jwt:Subject"]),
                    new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString()),
                    new Claim(JwtRegisteredClaimNames.Iat, DateTime.UtcNow.ToString()),
                    new Claim("Id", user.Id.ToString()),
                    new Claim("FirstName", user.Name),
                    new Claim("LastName", user.Surname),
                    new Claim("Email", user.Email),
                    new Claim("role", user.IsAdmin ? "Admin" : "User"), //support role
                   };

                    var key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_configuration["Jwt:Key"]));
                    var signIn = new SigningCredentials(key, SecurityAlgorithms.HmacSha256);
                    var token = new JwtSecurityToken(_configuration["Jwt:Issuer"], _configuration["Jwt:Audience"], claims, expires: DateTime.UtcNow.AddDays(1), signingCredentials: signIn);

                    return Ok(new JwtSecurityTokenHandler().WriteToken(token));
                }
                else
                {
                    return BadRequest("Invalid credentials");
                }
            }
            else
            {
                return BadRequest();
            }
        }
    }
}
