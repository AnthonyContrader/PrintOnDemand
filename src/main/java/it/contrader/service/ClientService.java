package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ClientConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.ClientRepository;
import it.contrader.dto.ClientDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Client;
import it.contrader.model.User;

@Service
public class ClientService extends AbstractService<Client, ClientDTO> {

	@Autowired
	private ClientConverter converter;
	@Autowired
	private UserConverter converteru;
	@Autowired
	private ClientRepository repository;

	public ClientDTO findById(long id) {
		return converter.toDTO(repository.findById(id));
	}
	public List<ClientDTO> findAllByuser(UserDTO userDTO) {
//		List<Long> ids=new ArrayList<>();
	//	ids.add(id);
		return converter.toDTOList(((ClientRepository) crudRepository).findAllByuser(converteru.toEntity(userDTO)));
		//((ClientRepository) crudRepository).findAllById(id)   .findAllById(id)
	}
}