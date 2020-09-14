using Project1.Infrastructure;
using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Repository
{
    public class UserRepository : BaseRepositoty<UserItem>
    {
        public UserRepository(Project1Context context) : base(context)
        {
        }

        public UserItem GetByLogin(string login, string password)
        {
            var users = GetAll().Where(a => a.Login == login && a.Password == password);
            if (users.Count() > 1)
                throw new Exception("One one user with login and password");
          
            return users.FirstOrDefault();
        }
    }
}
