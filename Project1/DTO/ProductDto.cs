using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
    public class ProductDto
    {
        public int? Id { get; set; }
        public double Price { get; set; }
        public string Name { get; set; }
        public int? OwnerId { get; set; }

        public ProductItem ConvertTo()
        {
            return new ProductItem
            {
                Id = this.Id,
                Name = this.Name,
                OwnerId = this.OwnerId,
                Price = this.Price
            };
        }

        public static ProductDto ConvertFrom(ProductItem product)
        {
            return new ProductDto
            {
                Id = product.Id,
                Name = product.Name,
                OwnerId = product.OwnerId,
                Price = product.Price
            };
        }
    }
}
