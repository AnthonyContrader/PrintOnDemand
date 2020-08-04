package it.contrader.dto;

public class OrderDTO {
	
	private int clientId;
	private int itemId;
	private String date;
	private int prezzo;
	private int orderId;
	
public OrderDTO() {
		
	}

	public OrderDTO (int clientId, int itemId, String date, int prezzo,int orderId) {
		this.clientId = clientId;
		this.itemId = itemId;
		this.date = date;
		this.prezzo = prezzo;
		this.orderId = orderId;
	}

	public OrderDTO (String date, int prezzo, int clientId) {
		this.date = date;
		this.prezzo = prezzo;
		this.clientId = clientId;
	}
	
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
	
	
	@Override
	
	
	public String toString() {
		return  clientId + "\t"  + itemId + "\t" + date + "\t"  +prezzo + "\t"  +orderId; 
	}
	
	public boolean equals(OrderDTO orderCompare)  {
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
	
