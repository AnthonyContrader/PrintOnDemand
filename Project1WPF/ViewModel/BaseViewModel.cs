using Project1WPF.Delegate;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project1WPF.ViewModel
{
    public abstract class BaseViewModel : INotifyPropertyChanged
    {
        public NotifyMessageDelegate NotifyMessage;

        private bool _isValid = true;

        public bool IsValid 
        {
            get { return _isValid; }
            set { _isValid = value; OnPropertyChange(nameof(IsValid)); }
        }

        public BaseViewModel()
        {
            
        }

        public string ValidationMessage { get; set; }

        public event PropertyChangedEventHandler PropertyChanged;

        protected void OnPropertyChange(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }
    }
}
