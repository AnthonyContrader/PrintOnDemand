package it.contrader.dto;

import it.contrader.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemDTO {

	

	private String nome;
	private String descrizione;
	private String tipo;
	private String colore;
	private String taglia;
	private String immagine;
	private String link;
	private long id;

}