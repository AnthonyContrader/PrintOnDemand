package it.contrader.dto;
public class ClientDTO {
	private int id;
	private int userId;
	private String nome;
	private String cognome;
	private String indirizzo;
	public ClientDTO() {
	}
	public ClientDTO (String nome, String cognome, String indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}
	public ClientDTO (int userId, String nome, String cognome, String indirizzo) {
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}
	public ClientDTO (String nome, String cognome, String indirizzo,int id) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}

	public ClientDTO (int userId, String nome, String cognome, String indirizzo,int id) {
		this.id=id;
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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

		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDTO other = (ClientDTO) obj;
		if (id != other.id)
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
	public String toString() {
		return  userId+"\t"+ nome + "\t"  + cognome +"\t" + indirizzo +"\t"+id;
	}
}