package it.contrader.service;

import java.util.List;

import it.contrader.dao.OrderDAO;
import it.contrader.dao.ItemDAO;
import it.contrader.converter.OrderConverter;
import it.contrader.converter.ItemConverter;
import it.contrader.dto.OrderDTO;
import it.contrader.dto.ItemDTO;

public class OrderService {

	private OrderDAO orderDAO;
	private OrderConverter orderConverter;
	private ItemDAO itemDAO;
	private ItemConverter itemConverter;
	
	
		public OrderService() {
			this.orderDAO = new OrderDAO();
			this.itemDAO = new ItemDAO();
			this.orderConverter=new OrderConverter();
			this.itemConverter=new ItemConverter();
		}

		public List<OrderDTO> getAll() {
			
			// Ottiene una lista di entità e le restituisce convertendole in DTO
			return orderConverter.toDTOList(orderDAO.getAll());
		}

		public boolean insert(OrderDTO order, ItemDTO item) {
			//System.out.println(orderConverter.toEntity(order));
			
			return orderDAO.insert(orderConverter.toEntity(order),itemConverter.toEntity(item));
		}
		
		public List<OrderDTO> read(int orderId) {
			
			return orderConverter.toDTOList(orderDAO.read(orderId));
		}
		
		public boolean delete(int orderId) {
			
			return orderDAO.delete(orderId);
		}
		
		
	}
