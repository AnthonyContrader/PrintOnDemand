using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using Project1.DTO;
using Project1.Infrastructure;
using Project1.Model;
using Project1.Repository;

namespace Project1.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class ProductController : ControllerBase
    {
        private readonly Project1Context _context;

        public ProductController(Project1Context context)
        {
            _context = context;
        }

        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public HttpResponseMessage Create([FromBody] dynamic product)
        {
            ProductDto productDto = JsonConvert.DeserializeObject<ProductDto>(product.ToString());

            if (string.IsNullOrWhiteSpace(productDto.Name))
                return new HttpResponseMessage(System.Net.HttpStatusCode.BadRequest);
            if (productDto.Price < 0)
                return new HttpResponseMessage(System.Net.HttpStatusCode.BadRequest);

            ProductItem productItem = productDto.ConvertTo();
            ProductRepository productRepository = new ProductRepository(_context);
            productItem = productRepository.Insert(productItem);
            productDto = ProductDto.ConvertFrom(productItem);

            var resp = new HttpResponseMessage()
            {
                StatusCode = System.Net.HttpStatusCode.OK,
                Version = new Version(1, 0),
                Content = new StringContent(JsonConvert.SerializeObject(productDto))
            };
            resp.Content.Headers.ContentType = new MediaTypeHeaderValue("application/json");
            return resp;
        }

        [Route("/api/v1/[controller]/getproducts")]
        [HttpGet]
        public List<ProductDto> GetProducts()
        {
            ProductRepository productRepository = new ProductRepository(_context);
            var products = productRepository.GetAll().Include("Owner") //eager loading
                .AsNoTracking();
            List<ProductDto> productsDto = new List<ProductDto>();
            foreach (var product in products)
            {
                productsDto.Add(ProductDto.ConvertFrom(product));
            }

            return productsDto;
        }

        [Route("/api/v1/[controller]/deleteProduct")]
        [HttpDelete]
        public HttpResponseMessage DeleteProduct(int id)
        {
            ProductRepository productRepository = new ProductRepository(_context);
            productRepository.Delete(id);

            return new HttpResponseMessage(System.Net.HttpStatusCode.OK);
        }
    }
}
