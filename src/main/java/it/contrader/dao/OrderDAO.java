package it.contrader.dao;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Order;
import it.contrader.model.Item;


public class OrderDAO {

	

	
	//private final String QUERY_DUPLICATE = "INSERT INTO item (nome, descrizione, tipo, colore, taglia, immagine, link) SELECT item nome, descrizione, tipo, colore, taglia, immagine, link FROM item WHERE iditem=?";
	//private final String QUERY_UPDATE = "UPDATE ordine SET user_id=?, client_id=?, date=?, prezzo=? WHERE IDorder=?";
	
	
	
	private final String QUERY_CREATE = "insert into orders (IDclient,IDitem,data,prezzo) values (?,?,?,?)";	
	private final String QUERY_ALL = "select * from orders";
	private final String QUERY_READ = "select * from orders where IDclient=?";
	private final String QUERY_DELETE = "DELETE from orders where IDorder=?";
	
	//operazioni peculiari
	private final String QUERY_DUPLICATE = "INSERT INTO item (nome, descrizione, tipo, colore, taglia, immagine, link) SELECT item.nome, item.descrizione, item.tipo, item.colore, item.taglia, item.immagine, item.link FROM item WHERE iditem=?";
	private final String QUERY_MAX = "SELECT iditem FROM item ORDER BY IDitem DESC LIMIT 1";
	private final String QUERY_CUSTOM = "UPDATE item set immagine=?, link=? WHERE iditem=?";
	
	
	public OrderDAO() {

	}
	
	public String currentDate() {
		Order order= new Order();
		String date= order.getDate();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		date=dtf.format(now);
		return date;
	}

	public List<Order> getAll() {
		List<Order> ordersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Order order;
			
			while (resultSet.next()) {
				int orderId = resultSet.getInt("IDorder");
				int itemId = resultSet.getInt("IDitem");
				int clientId = resultSet.getInt("IDclient");
				String date = resultSet.getString("data");
				int prezzo_tot = resultSet.getInt("prezzo");
				order = new Order(clientId,itemId,date,prezzo_tot,orderId);
				//order.setOrderId(orderId);
				ordersList.add(order);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	public boolean insert(Order order, Item item) {
		Connection connection = ConnectionSingleton.getInstance();
		int maxId=0;
		try {
			Statement statementmax = connection.createStatement();
			PreparedStatement preparedStatementd = connection.prepareStatement(QUERY_DUPLICATE);
			PreparedStatement preparedStatementu = connection.prepareStatement(QUERY_CUSTOM);
			preparedStatementd.setInt(1,item.getId());
			boolean r=preparedStatementd.execute();
			
			if (!r) {
				
				ResultSet resultSet = statementmax.executeQuery(QUERY_MAX);
				resultSet.next();
				maxId=resultSet.getInt("iditem");
				
				preparedStatementu.setString(1,item.getImage());
				preparedStatementu.setString(2,item.getQRLink());
				preparedStatementu.setInt(3,maxId);
				
				
				
			}
			int a = preparedStatementu.executeUpdate();
			if (a > 0)
			{
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
				preparedStatement.setInt(1, order.getClientId());
				preparedStatement.setInt(2, maxId);
				preparedStatement.setString(3, currentDate());
				preparedStatement.setInt(4, order.getPrezzo());
				int b=preparedStatement.executeUpdate();
				if(b>0)	return true;
				else return false;
			}	
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Order> read(int Idclient) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, Idclient); 
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Order> lista=new ArrayList<>();
			Order order=new Order();
			while(resultSet.next()) {
			int itemId,Idorder,prezzo_tot;
			String date;
            
			Idorder=resultSet.getInt("IDorder");
			itemId = resultSet.getInt("IDitem");
			prezzo_tot = resultSet.getInt("prezzo");
			date= resultSet.getString("data");
			order = new Order(Idclient, itemId, date, prezzo_tot,Idorder);
			lista.add(order);
			}
			return lista;
		} catch (SQLException e) {
			
			return null;
		}

	}
	
	
	/*public boolean updateCustom(OrderDTO order) {
		Connection connection = ConnectionSingleton.getInstance();
		
		//Check if id is present
		if (order.getOrderId()==0)
			return false;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, order.getOrderId());
			preparedStatement.setInt(2, order.getClientId());
			preparedStatement.setString(3,currentDate());
			preparedStatement.setInt(4, order.getPrezzo());
			int a = preparedStatement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
	}*/

	public boolean delete(Integer orderId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, orderId);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}

}
