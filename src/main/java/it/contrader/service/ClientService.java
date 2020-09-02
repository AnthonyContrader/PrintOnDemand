package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ClientRepository;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;


@Service
public class ClientService extends AbstractService<Client,ClientDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public ClientDTO findById(long id) {
		return converter.toDTO(((ClientRepository)repository).findById(id));
	}
	
	//CRUD complete

}