using Project2.IServices;
using Shared.Model;
using Shared.Services;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Project1WPF.ViewModel
{
    public class MainWindowViewModel : BaseViewModel
    {
        #region fields
        private ObservableCollection<UserItem> _users = new ObservableCollection<UserItem>();

        public ObservableCollection<UserItem> Users
        {
            get { return _users; }
            set { _users = value; OnPropertyChange(nameof(Users)); }
        }
        #endregion

        #region methods
        public async Task LoadUsers()
        {
            List<UserItem> users = null;
            using (HttpClient client = new HttpClient())
            {
                client.BaseAddress = new Uri(Shared.Define.CommonDefine.SERVICE1_BASEURL);
                IProject1Service service = new Project1Service(client);
                users = await service.GetUsersAsync();
            }

            _users.Clear();
            foreach (var user in users)
            {
                _users.Add(user);
            }

            Users = _users;
        }

        #endregion
    }
}
