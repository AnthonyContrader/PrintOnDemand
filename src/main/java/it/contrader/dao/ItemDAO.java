package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Item;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class ItemDAO implements DAO<Item> {

	private final String QUERY_ALL = "SELECT * FROM item";
	private final String QUERY_CREATE = "INSERT INTO item (nome,descrizione,tipo,colore,taglia,immagine,link) VALUES (?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM item WHERE iditem=?";
	private final String QUERY_UPDATE = "UPDATE item SET nome=?, descrizione=?, tipo=?,colore=?,taglia=?,immagine=?,link=? WHERE iditem=?";
	private final String QUERY_DELETE = "DELETE FROM item WHERE iditem=?";

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
				String descrizione = resultSet.getString("descrizione");
				String tipo = resultSet.getString("tipo");
				String colore = resultSet.getString("colore");
				String taglia = resultSet.getString("taglia");
				String immagine = resultSet.getString("immagine");
				String link = resultSet.getString("linke");
				item = new Item(nome, descrizione, tipo,colore, taglia,immagine,link);
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
			preparedStatement.setString(2, itemToInsert.getDescr());
			preparedStatement.setString(3, itemToInsert.getTipo());
			preparedStatement.setString(4, itemToInsert.getColore());
			preparedStatement.setString(5, itemToInsert.getTaglia());
			preparedStatement.setString(6, itemToInsert.getImmagine());
			preparedStatement.setString(7, itemToInsert.getLink());
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
			String nome,descrizione,tipo,colore,taglia,immagine,link;

			nome = resultSet.getString("nome");
			descrizione = resultSet.getString("descrizione");
			tipo = resultSet.getString("tipo");
			colore = resultSet.getString("colore");
			taglia = resultSet.getString("taglia");
			immagine = resultSet.getString("immagine");
			link = resultSet.getString("link");
			Item item = new Item(nome, descrizione, tipo,colore, taglia,immagine,link);
			item.setId(resultSet.getInt("iditem"));

			return item;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Item itemToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (itemToUpdate.getId() == 0)
			return false;

		Item itemRead = read(itemToUpdate.getId());
		if (!itemRead.equals(itemToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (itemToUpdate.getName() == null || itemToUpdate.getName().equals("")) {
					itemToUpdate.setName(itemRead.getName());
				}

				if (itemToUpdate.getDescr() == null || itemToUpdate.getDescr().equals("")) {
					itemToUpdate.setDescr(itemRead.getDescr());
				}

				if (itemToUpdate.getTipo() == null || itemToUpdate.getTipo().equals("")) {
					itemToUpdate.setTipo(itemRead.getTipo());
				}
				if (itemToUpdate.getColore() == null || itemToUpdate.getColore().equals("")) {
					itemToUpdate.setColore(itemRead.getColore());
				}
				if (itemToUpdate.getTaglia() == null ||itemToUpdate.getTaglia().equals("")) {
					itemToUpdate.setTaglia(itemRead.getTaglia());
				}
				if (itemToUpdate.getImmagine() == null || itemToUpdate.getImmagine().equals("")) {
					itemToUpdate.setImmagine(itemRead.getImmagine());
				}
				if (itemToUpdate.getLink() == null || itemToUpdate.getLink().equals("")) {
					itemToUpdate.setLink(itemRead.getLink());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, itemToUpdate.getName());
				preparedStatement.setString(2, itemToUpdate.getDescr());
				preparedStatement.setString(3, itemToUpdate.getTipo());
				preparedStatement.setString(4, itemToUpdate.getColore());
				preparedStatement.setString(5, itemToUpdate.getTaglia());
				preparedStatement.setString(6, itemToUpdate.getImmagine());
				preparedStatement.setString(7, itemToUpdate.getLink());
				preparedStatement.setInt(8, itemToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
