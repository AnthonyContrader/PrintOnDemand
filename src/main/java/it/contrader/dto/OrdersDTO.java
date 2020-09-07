package it.contrader.dto;

import it.contrader.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrdersDTO {

	private Client client;
	
	private Item item;

	private String data;

	private String prezzo;

	private long id;

}
