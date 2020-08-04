package it.contrader.service;

import java.util.List;

import it.contrader.converter.OrderConverter;
import it.contrader.dao.OrderDAO;
import it.contrader.dto.OrderDTO;
import it.contrader.model.Order;



public class OrderService extends AbstractService<Order,OrderDTO>{
	public OrderService(){
		this.dao = new OrderDAO();
		this.converter = new OrderConverter();
	}
		
	}
