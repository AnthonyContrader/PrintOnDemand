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
    public partial class LoginFrm : Form
    {
        public LoginFrm()
        {
            InitializeComponent();
        }

        private async void _btnLogin_Click(object sender, EventArgs e)
        {
            await OnLogin();
        }

        private async Task OnLogin()
        {
            if (!ValidateTxt(_txtLogin))
                return;
            if (!ValidateTxt(_txtPassword))
                return;

            string login = _txtLogin.Text;
            string password = _txtPassword.Text;

            try
            {
                UserItem user = null;
                using (HttpClient client = new HttpClient())
                {
                    client.BaseAddress = new Uri(Shared.Define.CommonDefine.SERVICE1_BASEURL);
                    IProject1Service service = new Project1Service(client);
                    user = await service.GetUserByLogin(login, password);
                    if (user == null)
                    {
                        MessageBox.Show("Creedenziali non valide");
                        return;
                    }
                }

                this.DialogResult = DialogResult.OK;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private bool ValidateTxt(TextBox txtBox)
        {
            if (string.IsNullOrEmpty(txtBox.Text))
            {
                txtBox.Focus();
                MessageBox.Show("Campo richiesto");
                return false;
            }

            return true;
        }

        private async void LoginFrm_Load(object sender, EventArgs e)
        {
            Enabled = false;

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
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                Enabled = true;
                _txtLogin.Focus();
            }
        }

        private void LoginFrm_Shown(object sender, EventArgs e)
        {
            _txtLogin.Focus();
        }

        private async void _txtPassword_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                await OnLogin();
            }
        }
    }
}
