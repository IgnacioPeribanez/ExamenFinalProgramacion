package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta clase conecta mi paquete de Java con una base de datos de SQL.
 */
public class MySQLAccess {
	private Connection connect = null; 	
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost:3306/examenprogramacion";
	final private String user = "root";
	final private String passwd = "root";

	public Connection readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);
		} catch (Exception e) {
			throw e;
		}	
		return connect;
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo inserta un registro en la base de datos.
	 */
	public void insertRegistro(String letra, String palabra, int linea) throws Exception {
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("insert into registro"
					+ "(letra, palabra, linea) values (?, ?, ?)");
			preparedStatement.setString(1, letra);
			preparedStatement.setString(2, palabra);
			preparedStatement.setInt(3, linea);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	/**
	 * Pre: ---
	 * Post: Cerramos todas las conexiones abiertas, el resultSet y el
	 * 		 statement. 
	 */
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}
}
