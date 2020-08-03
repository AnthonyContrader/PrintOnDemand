package it.contrader.service;

import java.util.List;

import it.contrader.dao.ClientDAO;
import it.contrader.dto.ClientDTO;
import it.contrader.dto.UserDTO;
import it.contrader.converter.ClientConverter;



public class ClientService {
	private ClientDAO clientDAO;
	private ClientConverter clientConverter;

	public ClientService()
	{
		this.clientDAO= new ClientDAO();
		this.clientConverter = new ClientConverter();
	}
	
	public List<ClientDTO> getAll() {
		 return clientConverter.toDTOList(clientDAO.getAll());
	}
	
	public List<ClientDTO> getAlluser() {
		 return clientConverter.toDTOList(clientDAO.getAlluser());
	}
	public List<ClientDTO> read(int id) {
		return clientConverter.toDTOList(clientDAO.read(id));
	}
	
	public boolean insert(ClientDTO dto) 
	{
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return clientDAO.insert(clientConverter.toEntity(dto));
	}
	
	public boolean update(ClientDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return clientDAO.update(clientConverter.toEntity(dto));
	}
	
	public boolean delete(int id) {
		return clientDAO.delete(id);
	}
}
