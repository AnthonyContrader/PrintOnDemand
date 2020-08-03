package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.OrderDTO;

import it.contrader.model.Order;

public class OrderConverter   {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public OrderDTO toDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO(order.getClientId(),order.getItemId(),order.getDate(), order.getPrezzo(), order.getOrderId());
		
		return orderDTO;
	}
	
	public Order toEntity(OrderDTO orderDTO) {
		
		Order order = new Order(orderDTO.getClientId(), orderDTO.getItemId(), orderDTO.getDate(), orderDTO.getPrezzo(),orderDTO.getOrderId());
		return order;
	}
	
	public List<OrderDTO> toDTOList(List<Order> orderList) {
		//Crea una lista vuota.
		
		List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Order order : orderList) {
			
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			orderDTOList.add(toDTO(order));
		}
		return orderDTOList;
	}
}