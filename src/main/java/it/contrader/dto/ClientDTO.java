package it.contrader.dto;
public class ClientDTO {
	private int userId;
	private String nome;
	private String cognome;
	private String indirizzo;
	private int idclient;
	
	public ClientDTO() {
	}

	public ClientDTO (int userId, String nome, String cognome, String indirizzo, int idclient) {
		this.idclient=idclient;
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.idclient=idclient;
	}

	public ClientDTO (String nome, String cognome, String indirizzo, int idclient) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.idclient=idclient;
	}
	public ClientDTO (int userId, String nome, String cognome, String indirizzo) {
	
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}

	

	public void setUserId(int userId) {
		this.userId=userId;		
	}

	public int getUserId() {
		return this.userId;		
	}
	
	public String getName() {
		return this.nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}


	public String getSurname() {
		return this.cognome;
	}

	public void setSurname(String cognome) {
		this.cognome = cognome;
	}

	public String getAddress() {
		return this.indirizzo;
	}
	
	public void setAddress(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String toString() {
		return  userId+"\t"+ nome + "\t"  + cognome +"\t" + indirizzo +"\t"+idclient;
	}
	
}