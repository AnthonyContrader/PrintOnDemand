package it.contrader.model;


public class Order {
	private int clientId;
	private int itemId;
	private String date;
	private int prezzo;
	private int orderId;
	
	
	
	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getClientId() {
		return clientId;
	}



	public void setClientId(int clientId) {
		this.clientId = clientId;
	}



	public int getItemId() {
		return itemId;
	}



	public void setItemId(int itemId) {
		this.itemId = itemId;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	





	public Order(int clientId, int itemId, String date, int prezzo, int orderId) {
		super();
		this.clientId = clientId;
		this.itemId = itemId;
		this.date = date;
		this.prezzo = prezzo;
		this.orderId = orderId;
	}

	public Order() {
		
	} 



	@Override
	public String toString() {
		return  clientId + "\t"  + itemId +"\t\t" +  date + "\t\t" + prezzo + "\t\t" + orderId;
	}


	public boolean equals(Order orderCompare)  {
		if (this.getItemId()!=(orderCompare.getItemId())) {
			return false;
		}
		
		if (this.getClientId()!=(orderCompare.getClientId())) {
			return false;
		}
		
		if (this.getOrderId() != (orderCompare.getOrderId())) {
			
		}
		return true;
	}
}