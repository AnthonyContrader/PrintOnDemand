package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.OrdersRepository;
import it.contrader.dto.OrdersDTO;
import it.contrader.model.Orders;

/**
 * Estende AbstractService con parametri User e UserDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class OrdersService extends AbstractService<Orders,OrdersDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public OrdersDTO findById(long id) {
		return converter.toDTO(((OrdersRepository)repository).findById(id));
	}

}
