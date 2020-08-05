package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.model.Client;
import it.contrader.utils.ConnectionSingleton;


public class ClientDAO implements DAO<Client>{

	private final String QUERY_ALL = "SELECT * FROM client";
	private final String QUERY_CREATE = "INSERT INTO client (userID, nome, cognome, indirizzo) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM client WHERE idclient=?";
	private final String QUERY_UPDATE = "UPDATE client SET nome=?, cognome=?, indirizzo=? WHERE idclient=?";
	private final String QUERY_DELETE = "DELETE FROM client WHERE idclient=?";

	public ClientDAO() {

	}

	public List<Client> getAll() {
		List<Client> clientsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Client client;
			while (resultSet.next()) {
				int idclient = resultSet.getInt("idclient");
				String name = resultSet.getString("nome");
				String surname = resultSet.getString("cognome");
				String address = resultSet.getString("indirizzo");
				int idUser = resultSet.getInt("userID");
				client = new Client(idUser, name, surname, address,idclient);
				client.setUserId(idUser);
				clientsList.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsList;
	}


	public boolean insert(Client userToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, userToInsert.getUserId());
			preparedStatement.setString(2, userToInsert.getName());
			preparedStatement.setString(3, userToInsert.getSurname());
			preparedStatement.setString(4, userToInsert.getAddress());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Client read(int idclient) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idclient);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name,surname,address;
			int idClient;
			
			name = resultSet.getString("nome");
			surname = resultSet.getString("cognome");
			address = resultSet.getString("indirizzo");
			idClient = resultSet.getInt("idclient");
			Client client = new Client(name,surname,address,idClient);
			client.setUserId(resultSet.getInt("userID"));

			return client;
		} catch (SQLException e) {
			return null;
		}

	}



	public boolean update(Client clientToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (clientToUpdate.getIdclient() == 0)
			return false;

		Client clientRead = read(clientToUpdate.getIdclient());
		if (!clientRead.equals(clientToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (clientToUpdate.getName() == null || clientToUpdate.getName().equals("")) {
					clientToUpdate.setName(clientRead.getName());
				}
				
				if (clientToUpdate.getSurname() == null || clientToUpdate.getSurname().equals("")) {
					clientToUpdate.setSurname(clientRead.getSurname());
				}
				
				if (clientToUpdate.getAddress() == null || clientToUpdate.getAddress().equals("")) {
					clientToUpdate.setAddress(clientRead.getAddress());
				}
				

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, clientToUpdate.getName());
				preparedStatement.setString(2, clientToUpdate.getSurname());
				preparedStatement.setString(3, clientToUpdate.getAddress());
				preparedStatement.setInt(4, clientToUpdate.getIdclient());				
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
