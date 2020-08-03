package it.contrader.dao;
import it.contrader.controller.Request;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.contrader.main.ConnectionSingleton;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class LoginDAO {

	private final String QUERY_LOGIN = "SELECT * FROM user WHERE username = ? AND password = ?";

	
	public Request login (String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			
			statement.setString(1, username);
			statement.setString(2, password);

			String usertype = null;
			int id=0;
			
			ResultSet resultSet;
			
			if(statement.executeQuery().next()) {
				resultSet = statement.executeQuery();
				resultSet.next();
				usertype = resultSet.getString("usertype");
				id=resultSet.getInt("id");
			}
			Request infos=new Request();
			infos.put("usertype", usertype);
			infos.put("id", id);
			return infos;
		}
		
		catch (SQLException e) {
			
			return null;
		}
	}
}
