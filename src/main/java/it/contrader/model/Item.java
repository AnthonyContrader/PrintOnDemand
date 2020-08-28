package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Item {

	
	
	private String nome;
	private String descrizione;
	private String tipo;
	private String colore;
	private String taglia;
	private String immagine;
	private String link;
	@Id
	@Column(unique = true)
	private long id;

}
