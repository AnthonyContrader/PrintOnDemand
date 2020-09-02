package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.OrdersDTO;
import it.contrader.service.OrdersService;



@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdersController extends AbstractController<OrdersDTO>{
	
	@Autowired
	private OrdersService ordersService;


	//POST Angular a UserDTO
	@PostMapping(value = "/orders")
	public OrdersDTO getAll( @RequestBody OrdersDTO ordersDTO ) {
		return ordersService.findById(ordersDTO.getId());
	}
}