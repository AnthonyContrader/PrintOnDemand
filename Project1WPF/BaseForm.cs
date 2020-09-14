using Project1WPF.Delegate;
using Project1WPF.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Project1WPF
{
    public abstract class BaseForm : System.Windows.Window
    {
        public NotifyMessageDelegate NotifyMessageDt { get; set; }

        public BaseViewModel ViewModel { get; set; }

        public BaseForm()
        {
            NotifyMessageDt = new NotifyMessageDelegate(NotifyMessage);
            this.Loaded += BaseForm_Loaded;
        }

        private void BaseForm_Loaded(object sender, RoutedEventArgs e)
        {
            ViewModel.NotifyMessage = NotifyMessageDt;
        }

        public void NotifyMessage(string message)
        {
            MessageBox.Show(message);
        }
    }
}
