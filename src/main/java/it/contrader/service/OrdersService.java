package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ClientConverter;
import it.contrader.converter.OrdersConverter;
import it.contrader.dao.*;
import it.contrader.dto.*;
import it.contrader.model.*;

@Service
public class OrdersService extends AbstractService<Orders, OrdersDTO> {

	@Autowired
	private OrdersConverter converter;
	@Autowired
	private ClientConverter cconverter;
	@Autowired
	private OrdersRepository repository;

	public OrdersDTO findById(int id) {
		return converter.toDTO(repository.findById(id));
	}
	public List<OrdersDTO> findByclientIn(List<ClientDTO> listDTO) {
		List<Client> list=new ArrayList<>();
		for(ClientDTO u: listDTO) {
			list.add((cconverter.toEntity(u)));			
		}
		return converter.toDTOList(((OrdersRepository) crudRepository).findByclientIn(list));
		//((ClientRepository) crudRepository).findAllById(id)   .findAllById(id)
	}
}
