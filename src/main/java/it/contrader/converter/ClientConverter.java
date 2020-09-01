package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ClientDTO;

import it.contrader.model.Client;


@Component
public class ClientConverter extends AbstractConverter<Client,ClientDTO>
{

	@Override
	public Client toEntity(ClientDTO clientDTO) {
		Client client = null;
		if (clientDTO != null) {
			client = new Client(clientDTO.getUserID() ,clientDTO.getNome(),clientDTO.getCognome(),clientDTO.getIndirizzo(),clientDTO.getId());			
		}
		return client;
	}

	@Override
	public ClientDTO toDTO(Client client) {
		ClientDTO clientDTO = null;
		if (client != null) {
			clientDTO = new ClientDTO(client.getUserID(),client.getNome(),client.getCognome(),client.getIndirizzo(),client.getId());
			
		}
		return clientDTO;
	}
}