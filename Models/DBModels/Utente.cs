using System;
using System.Collections.Generic;

namespace POD.Models.DBModels
{
    public partial class Utente
    {
        public int Id { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string Usertype { get; set; }

        public virtual Cliente Cliente { get; set; }
    }
}
