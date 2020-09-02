package it.contrader.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	private long IDclient;
	
	private long IDitem;
	
	private String data;
	
	private String prezzo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
}
