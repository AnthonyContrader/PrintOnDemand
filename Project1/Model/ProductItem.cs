using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class ProductItem : BaseModel
    {
        public double Price { get; set; }
        public string Name { get; set; }
        public virtual UserItem Owner { get; set; }
        public int? OwnerId { get; set; }
    }
}
