using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
    public class UserDto
    {
        public int? Id { get; set; }
        public string Surname { get; set; }
        public string Name { get; set; }
        public string Login { get; set; }
        public string Password { get; set; }
        public string Email { get; set; }
        public bool IsAdmin { get; set; }

        public UserItem ConvertTo()
        {
            return new UserItem
            {
                Id = this.Id,
                Login = this.Login,
                Name = this.Name,
                Password = this.Password,
                Surname = this.Surname,
                Email = this.Email,
                IsAdmin = this.IsAdmin,
            };
        }

        public static UserDto ConvertFrom(UserItem user)
        {
            return new UserDto
            {
                Id = user.Id,
                Login = user.Login,
                Name = user.Name,
                Password = user.Password,
                Surname = user.Surname,
                Email = user.Email,
                IsAdmin = user.IsAdmin,
            };
        }
    }
}
