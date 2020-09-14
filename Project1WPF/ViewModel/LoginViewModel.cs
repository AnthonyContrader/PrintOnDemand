using Project1WPF.Command;
using Project2.IServices;
using Shared.Model;
using Shared.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Net.Http;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Input;

namespace Project1WPF.ViewModel
{
    public class LoginViewModel : BaseViewModel, IDataErrorInfo
    {
        #region fields

        private string _login;
        private string _password;

        public string Login
        {
            get { return _login; }
            set
            {
                if (_login != value)
                {
                    _login = value;
                    OnPropertyChange(nameof(Login));
                }
            }
        }

        public string Password
        {
            get { return _password; }
            set
            {
                if (_password != value)
                {
                    _password = value;
                    OnPropertyChange(nameof(Password));
                }
            }
        }

        #endregion

        #region events
        public event EventHandler<UserItem> LoginCompleted;
        #endregion

        #region command

        private ICommand _loginCommand;

        public ICommand LoginCommand
        {
            get
            {
                return _loginCommand;
            }
            set
            {
                _loginCommand = value;
            }
        }

        #endregion

        #region ctor
        public LoginViewModel()
        {
            LoginCommand = new RelayCommand(OnLogin);
        }
        #endregion
      
        #region methods

        private async void OnLogin(object obj)
        {
            try
            {
                if (!Validate(out string message))
                {
                    NotifyMessage(message);
                    return;
                }

                UserItem user = null;
                using (HttpClient client = new HttpClient())
                {
                    client.BaseAddress = new Uri(Shared.Define.CommonDefine.SERVICE1_BASEURL);
                    IProject1Service service = new Project1Service(client);
                    user = await service.GetUserByLogin(Login, Password);
                    if (user == null)
                    {
                        NotifyMessage("Credenziali non valide");
                        return;
                    }
                }

                if (LoginCompleted != null)
                    LoginCompleted(this, user);
            }
            catch (Exception ex)
            {
                NotifyMessage(ex.Message);
            }
        }

        public async Task SeedUser()
        {
            try
            {
                // seed users
                List<UserItem> users = new List<UserItem>();
                using (HttpClient client = new HttpClient())
                {
                    client.BaseAddress = new Uri(Shared.Define.CommonDefine.SERVICE2_BASEURL);
                    IProject1Service service = new Project1Service(client);
                    users = await service.SeedUsers(10);
                }
            }
            catch(Exception ex)
            {
                NotifyMessage(ex.Message);
            }
        }
        #endregion

        #region validation
        public bool Validate(out string message)
        {
            message = string.Empty;
            bool isValid = true;
            if (string.IsNullOrEmpty(Login))
            {
                message = "Inserire la login";
                isValid = false;
            }
            if (string.IsNullOrEmpty(Password))
            {
                message += System.Environment.NewLine + "Inserire la password";
                isValid = false;
            }

            return isValid;
        }

        public string this[string columnName]
        {
            get
            {
                string result = string.Empty;
                IsValid = Validate(out string message);
                ValidationMessage = message;
                if (columnName == "Login")
                {
                    if (string.IsNullOrEmpty(Login))
                    {
                        result = "Inserire la login";
                    }
                }
                if (columnName == "Password")
                {
                    if (string.IsNullOrEmpty(Password))
                    {
                        result = "Inserire la password";
                    }
                }

                return result;
            }
        }

        public string Error
        {
            get
            {
                return string.Empty;
            }
        }
        #endregion
    }
}
