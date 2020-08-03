package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Item;





public class ItemDAO {
	private final String QUERY_ALL = "SELECT * FROM item WHERE (immagine='' OR immagine IS NULL)";
	private final String QUERY_CREATE = "INSERT INTO item (nome, descrizione, tipo, colore, taglia, immagine, link) VALUES (?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM item WHERE iditem=?";
	private final String QUERY_DELETE = "DELETE FROM item WHERE iditem=?";
	private final String QUERY_SEARCH = "SELECT * FROM item WHERE tipo=? AND (immagine='' OR immagine IS NULL)";
	
	public ItemDAO() {
	}
	
	public List<Item> getAll() {
		List<Item> itemsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Item item;
			while (resultSet.next()) {
				int id = resultSet.getInt("iditem");
				String nome = resultSet.getString("nome");
				String desc = resultSet.getString("descrizione");
				String tipo = resultSet.getString("tipo");
				int colore = resultSet.getInt("colore");
				String taglia = resultSet.getString("taglia");
				String immagine = resultSet.getString("immagine");
				String link = resultSet.getString("link");
				
				item = new Item(nome, desc, tipo, colore, taglia, immagine, link);
				item.setId(id);
				itemsList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemsList;
	}
	
	public boolean insert(Item itemToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, itemToInsert.getName());
			preparedStatement.setString(2, itemToInsert.getDesc());
			preparedStatement.setString(3, itemToInsert.getItemtype());
			preparedStatement.setInt(4, itemToInsert.getColor());
			preparedStatement.setString(5, itemToInsert.getSize());
			preparedStatement.setString(6, itemToInsert.getImage());
			preparedStatement.setString(7, itemToInsert.getQRLink());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	public Item read(int itemId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String nome,desc,tipo,taglia, immagine, link;
			int colore;
			
			nome = resultSet.getString("nome");
			desc = resultSet.getString("descrizione");
			tipo = resultSet.getString("tipo");
			colore = resultSet.getInt("colore");
			taglia = resultSet.getString("taglia");
			immagine = resultSet.getString("immagine");
			link = resultSet.getString("link");
			Item item = new Item(nome, desc, tipo, colore, taglia, immagine, link);
			item.setId(resultSet.getInt("iditem"));

			return item;
		} catch (SQLException e) {
			return null;
		}

	}
	public List<Item> search(String tipo) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SEARCH);
			preparedStatement.setString(1, tipo);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			Item item=new Item();
			List<Item> result=new ArrayList<>();
			String nome,desc,taglia, immagine, link;
			int colore;
			while (resultSet.next()) {
			nome = resultSet.getString("nome");
			desc = resultSet.getString("descrizione");
			tipo = resultSet.getString("tipo");
			colore = resultSet.getInt("colore");
			taglia = resultSet.getString("taglia");
			immagine = resultSet.getString("immagine");
			link = resultSet.getString("link");
			item = new Item(nome, desc, tipo, colore, taglia, immagine, link);
			item.setId(resultSet.getInt("iditem"));
			result.add(item);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		

	}
	
	
	public boolean delete(Integer id) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)	return true;
		} catch (SQLException e){}
		return false;
	}

	
	
}