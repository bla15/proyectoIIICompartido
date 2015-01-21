package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

	private static Connection connection;
	private static Statement statement;
	public static void conexion() throws ClassNotFoundException {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:highscores.db");
			statement = connection.createStatement();
			try {
				statement.executeUpdate("create table highscores (nombre string, puntuacion int)");
			} catch (SQLException e) {
				if (!e.getMessage().equals("table highscores already exists"))  // Este error sí es correcto si la tabla ya existe
					e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertAccion(String nombre, int puntuacion) {
		String sent = "insert into highscores values('" + nombre + "', " + puntuacion + ")";
		try {
			statement.executeUpdate(sent);
		} catch (SQLException e) {
			System.out.println( "ERROR EN SENTENCIA SQL: " + sent);
			e.printStackTrace();
		}
	}
	public static String obtenerHighScores(int posicion){
		int i = 1;
		try {
			Statement state = connection.createStatement();
			ResultSet resultado = state.executeQuery("SELECT * FROM highscores ORDER BY puntuacion DESC, nombre ASC ");
			while (resultado.next()){
				if(i == posicion){
					return resultado.getString("nombre")+"......"+resultado.getInt("puntuacion");
				}
				i++;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "BLANK......0";
	}
	
	
	public static void finConexion() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
