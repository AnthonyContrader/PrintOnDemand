package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.OrdersDTO;
import it.contrader.dto.ClientDTO;
import it.contrader.dto.ItemDTO;

import it.contrader.model.Orders;
import it.contrader.model.Client;
import it.contrader.model.Item;

@Component
public class OrdersConverter extends AbstractConverter<Orders, OrdersDTO> {

	@Override
	public Orders toEntity(OrdersDTO orderDTO) {
		Orders order = null;
		if (orderDTO != null) {
			order = new Orders(orderDTO.getClient() , orderDTO.getItem(), orderDTO.getData(), orderDTO.getPrezzo(),orderDTO.getId());
		}
		return order;
	}

	@Override
	public OrdersDTO toDTO(Orders order) {
		OrdersDTO orderDTO = null;
		if (order != null) {
			orderDTO = new OrdersDTO(order.getClient(), order.getItem(), order.getData(), order.getPrezzo(),order.getId());

		}
		return orderDTO;
	}
}