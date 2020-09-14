using Project1WPF.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using static Project1WPF.ViewModel.BaseViewModel;

namespace Project1WPF
{
    /// <summary>
    /// Interaction logic for LoginFrm.xaml
    /// </summary>
    public partial class LoginFrm : BaseForm
    {
        private LoginViewModel LoginViewModel { get { return ViewModel as LoginViewModel; } }

        public LoginFrm() : base()
        {
            InitializeComponent();

            LoginViewModel loginViewModel = new LoginViewModel();
            loginViewModel.LoginCompleted += LoginViewModel_LoginCompleted;
            base.ViewModel = loginViewModel;
            this.DataContext = loginViewModel;
        }

        private void LoginViewModel_LoginCompleted(object sender, Shared.Model.UserItem e)
        {
            this.DialogResult = true;
        }

        private async void Window_Loaded(object sender, RoutedEventArgs e)
        {
            IsEnabled = false;
            try
            {
                await LoginViewModel.SeedUser();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                IsEnabled = true;
            }
        }
    }
}
