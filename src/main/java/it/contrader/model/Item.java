package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Item {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
private int id;
	

	private String nome;
	private String descrizione;
	private String tipo;
	private String taglia;
	private String colore;
	private String immagine;
	private String link;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Item() {
		
	}

	public Item (String nome, String descrizione, String tipo,String colore,String taglia,String immagine,String link) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.colore = colore;
		this.taglia = taglia;
		this.immagine = immagine;
		this.link = link;
	}

	public Item (String nome, String descrizione, String tipo,String colore,String taglia,String immagine,String link,int id) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.colore = colore;
		this.taglia = taglia;
		this.immagine = immagine;
		this.link = link;
		this.id=id;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getDescr() {
		return this.descrizione;
	}

	public void setDescr(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getName() {
		return nome;
	}
	
	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getColore() {
		return colore;
	}
	
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	public String getTaglia() {
		return taglia;
	}
	
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public String getImmagine() {
		return immagine;
	}
	
	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  nome + "\t"  + descrizione +"\t" +   tipo + "\t" + colore+ "\t"  + taglia +"\t" + immagine +"\t" + link;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		
		if (colore == null) {
			if (other.colore != null)
				return false;
		} else if (!colore.equals(other.colore))
			return false;
		
		if (taglia == null) {
			if (other.taglia != null)
				return false;
		} else if (!taglia.equals(other.taglia))
			return false;
		
		if (immagine == null) {
			if (other.immagine != null)
				return false;
		} else if (!immagine.equals(other.immagine))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		return true;
	}
}
