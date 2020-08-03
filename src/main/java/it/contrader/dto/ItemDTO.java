package it.contrader.dto;
public class ItemDTO {
	private int id;
	private String nome;
	private String desc;
	private String tipo;
	private int colore;
	private String taglia;
	private String immagine;
	private String QRLink;
	
	
	public ItemDTO() {
	}
	public ItemDTO (String nome, String desc, String tipo, int colore, String taglia, String immagine, String QRLink) {
		this.nome = nome;
		this.desc = desc;
		this.tipo = tipo;
		this.colore=colore;
		this.taglia=taglia;
		this.immagine=immagine;
		this.QRLink=QRLink;
	}

	public ItemDTO (String nome, String desc, String tipo, int colore, String taglia, String immagine, String QRLink,int id) {
		this.nome = nome;
		this.desc = desc;
		this.tipo = tipo;
		this.colore=colore;
		this.taglia=taglia;
		this.immagine=immagine;
		this.QRLink=QRLink;
		this.id=id;
	}
	public ItemDTO (String immagine, String QRLink,int id) {
		this.immagine=immagine;
		this.QRLink=QRLink;
		this.id=id;
	}
	
	public ItemDTO (int id) 
	{
		this.id=id;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getItemtype() {
		return this.tipo;
	}

	public void setItemtype(String itemtype) {
		this.tipo = itemtype;
	}


	public String getName() {
		return this.nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public void setColor(int colore) {
		this.colore = colore;
	}

	public int getColor() {
		return colore;
	}
	
	public void setSize(String taglia) {
		this.taglia = taglia;
	}

	public String getSize() {
		return taglia;
	}
	
	public void setImage(String immagine) {
		this.immagine = immagine;
	}

	public String getImage() {
		return immagine;
	}
	
	public void setQRLink(String QRLink) {
		this.QRLink = QRLink;
	}

	public String getQRLink() {
		return QRLink;
	}
	
	public String toString() {
		return  nome + "\t"  + desc +"\t" + tipo +"\t"+   colore + "\t" + taglia+ "\t" + immagine+ "\t" + QRLink+ "\t" + id;
	}
}