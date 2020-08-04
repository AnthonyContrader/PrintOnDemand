package it.contrader.service;

import it.contrader.converter.ClientConverter;
import it.contrader.dao.ClientDAO;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

public class ClientService extends AbstractService<Client, ClientDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public ClientService(){
		this.dao = new ClientDAO();
		this.converter = new ClientConverter();
	}
	

}
