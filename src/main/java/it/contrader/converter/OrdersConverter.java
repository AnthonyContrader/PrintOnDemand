package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.OrdersDTO;

import it.contrader.model.Orders;


@Component
public class OrdersConverter extends AbstractConverter<Orders,OrdersDTO> {

	@Override
	public Orders toEntity(OrdersDTO ordersDTO) {
		Orders orders = null;
		if (ordersDTO != null) {
			orders = new Orders(ordersDTO.getIDclient(),ordersDTO.getIDitem(),ordersDTO.getData(),ordersDTO.getPrezzo(),ordersDTO.getId());			
		}
		return orders;
	}

	@Override
	public OrdersDTO toDTO(Orders orders) {
		OrdersDTO ordersDTO = null;
		if (orders != null) {
			ordersDTO = new OrdersDTO(orders.getIDclient(),orders.getIDitem(),orders.getData(),orders.getPrezzo(),orders.getId());
			
		}
		return ordersDTO;
	}
}