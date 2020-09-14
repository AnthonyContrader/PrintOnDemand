using Project2.IServices;
using Shared.Model;
using Shared.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Project1Form
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Login()
        {
            try
            {
                LoginFrm loginFrm = new LoginFrm();
                loginFrm.ShowDialog(this);
                var dialogResult = loginFrm.DialogResult;
                if (dialogResult != DialogResult.OK)
                {
                    this.Close();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private async void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                Login();

                List<UserItem> users = null;
                using (HttpClient client = new HttpClient())
                {
                    client.BaseAddress = new Uri(Shared.Define.CommonDefine.SERVICE1_BASEURL);
                    IProject1Service service = new Project1Service(client);
                    users = await service.GetUsersAsync();
                }

                _dataGridUsers.DataSource = users;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}
