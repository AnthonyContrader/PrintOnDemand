package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.ClientDTO;
import it.contrader.service.ClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController extends AbstractController<ClientDTO>{
	
	@Autowired
	private ClientService clientService;


	//POST Angular a UserDTO
	@PostMapping(value = "/client")
	public ClientDTO getAll( @RequestBody ClientDTO clientDTO ) {
		return clientService.findById(clientDTO.getId());
	}
}