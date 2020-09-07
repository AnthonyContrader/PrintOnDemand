package it.contrader.dto;

import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor

	public class ClientDTO {

		private User user;
		
		private String nome;
		
		private String cognome;
		
		private String indirizzo;
		
		private long id;

	}

