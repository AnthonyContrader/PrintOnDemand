package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class ItemDTO {
	
	private int id;
	

	private String nome;
	private String descrizione;
	private String tipo;
	private String taglia;
	private String colore;
	private String immagine;
	private String link;

	
	public ItemDTO() {
		
	}

	public ItemDTO (String nome, String descrizione, String tipo,String colore,String taglia,String immagine,String link) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.colore = colore;
		this.taglia = taglia;
		this.immagine = immagine;
		this.link = link;
	}

	public ItemDTO (String nome, String descrizione, String tipo,String colore,String taglia,String immagine,String link,int id) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.colore = colore;
		this.taglia = taglia;
		this.immagine = immagine;
		this.link = link;
		this.id=id;
	}

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

	@Override
	public String toString() {
		return  nome + "\t"  + descrizione +"\t" +   tipo + "\t" + colore+ "\t"  + taglia +"\t" + immagine +"\t" + link;
	}
}
