package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;


public class ClientConverter   {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public ClientDTO toDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO(client.getUserId(),client.getName(),client.getSurname(),client.getAddress(),client.getId());
		return clientDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Client toEntity(ClientDTO clientDTO) {
		Client client = new Client(clientDTO.getUserId(), clientDTO.getName(),clientDTO.getSurname(),clientDTO.getAddress(),clientDTO.getId());
		return client;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	public List<ClientDTO> toDTOList(List<Client> clientList) {
		//Crea una lista vuota.
		List<ClientDTO> clientDTOList = new ArrayList<ClientDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Client client : clientList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			clientDTOList.add(toDTO(client));
		}
		return clientDTOList;
	}

	
	
}