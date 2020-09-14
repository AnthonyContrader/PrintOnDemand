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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Project1WPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : BaseForm
    {
        private MainWindowViewModel MainWindowViewModel { get { return ViewModel as MainWindowViewModel; } }

        public MainWindow() : base()
        {
            InitializeComponent();

            ViewModel = new MainWindowViewModel();
            this.DataContext = ViewModel;
        }

        private async void Window_Loaded(object sender, RoutedEventArgs e)
        {
            try
            {
                LoginFrm loginFrm = new LoginFrm();
                loginFrm.Owner = this;
                var result = loginFrm.ShowDialog();
                if (result.GetValueOrDefault(false))
                {
                    loginFrm.Close();
                }
                else
                {
                    this.Close();
                }

                await MainWindowViewModel.LoadUsers();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}
