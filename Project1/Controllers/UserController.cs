using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Project1.DTO;
using Project1.Infrastructure;
using Project1.Model;
using Project1.Repository;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;

namespace Project1.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly Project1Context _context;

        public UserController(Project1Context context)
        {
            _context = context;
        }

        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public UserDto Create([FromBody] dynamic user)
        {
            UserDto userDto = JsonConvert.DeserializeObject<UserDto>(user.ToString());

            UserItem userItem = userDto.ConvertTo();
            UserRepository userRepository = new UserRepository(_context);
            userItem = userRepository.Insert(userItem);
            return UserDto.ConvertFrom(userItem);           
        }

        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getusers")]
        [HttpGet]
        public List<UserDto> GetUsers()
        {
            UserRepository userRepository = new UserRepository(_context);
            var users = userRepository.GetAll().AsNoTracking();
            List<UserDto> usersDto = new List<UserDto>();
            foreach (var user in users)
            {
                usersDto.Add(UserDto.ConvertFrom(user));
            }

            return usersDto;
        }

        [Route("/api/v1/[controller]/deleteUser")]
        [HttpDelete]
        public HttpResponseMessage DeleteUser(int id)
        {
            UserRepository userRepository = new UserRepository(_context);
            userRepository.Delete(id);

            return new HttpResponseMessage(System.Net.HttpStatusCode.OK);
        }

        [Route("/api/v1/[controller]/getuserbylogin")]
        [HttpPost]
        public UserDto GetUserByLogin([FromBody] dynamic loginData)
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
        }
    }
}
