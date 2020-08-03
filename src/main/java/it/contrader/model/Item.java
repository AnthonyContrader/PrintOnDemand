package it.contrader.model;
public class Item {
	private int id;
	private String nome;
	private String desc;
	private String tipo;
	private int colore;
	private String taglia;
	private String immagine;
	private String QRLink;
	public Item() {
	}
	public Item (String nome, String desc, String tipo, int colore, String taglia, String immagine, String QRLink) {
		this.nome = nome;
		this.desc = desc;
		this.tipo = tipo;
		this.colore=colore;
		this.taglia=taglia;
		this.immagine=immagine;
		this.QRLink=QRLink;
	}

	public Item (String nome, String desc, String tipo, int colore, String taglia, String immagine, String QRLink,int id) {
		
		this.nome = nome;
		this.desc = desc;
		this.tipo = tipo;
		this.colore=colore;
		this.taglia=taglia;
		this.immagine=immagine;
		this.QRLink=QRLink;
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
	@Override
	public String toString() {
		return  nome + "\t"  + desc +"\t\t" +  colore + "\t\t" + taglia + "\t\t" + immagine + "\t\t" + QRLink + "\t\t" + id ;
	}
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
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (colore!=other.colore)
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
		if (QRLink == null) {
			if (other.QRLink != null)
				return false;
		} else if (!QRLink.equals(other.QRLink))
			return false;
		return true;
	}
}