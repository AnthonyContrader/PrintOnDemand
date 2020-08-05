package it.contrader.model;
public class Client {
	private int idclient;
	private int userId;
	private String nome;
	private String cognome;
	private String indirizzo;
	public Client() {
	}
	public Client (int userId, String nome, String cognome, String indirizzo) {
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}
	public Client(String nome, String cognome, String indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}
	public Client (String nome, String cognome, String indirizzo, int idclient) {
		this.idclient=idclient;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}
	
	public Client (int userId, String nome, String cognome, String indirizzo, int idclient) {
		
		this.userId= userId;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.idclient=idclient;
	}

	
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
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
	public String toString() {
		return  userId+"\t"+ nome + "\t"  + cognome +"\t" + indirizzo +"\t"+idclient;
	}
		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (idclient != other.idclient)
			return false;
		if (userId != other.userId)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		return true;
	}
}