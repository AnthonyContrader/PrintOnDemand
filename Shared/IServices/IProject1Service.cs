using Shared.Model;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Project2.IServices
{
    public interface IProject1Service
    {
        Task<UserItem> CreateUserAsync(UserItem user);
        Task<List<UserItem>> CreateSeedUserAsync(int randomUser);
        Task<UserItem> GetUserByLogin(string login, string password);
        Task<List<UserItem>> SeedUsers(int randomUser);
        Task<List<UserItem>> GetUsersAsync();
    }
}
