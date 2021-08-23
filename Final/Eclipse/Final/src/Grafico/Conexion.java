package Grafico;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;



public class Conexion {
	

	private static String url= "jdbc:mysql://localhost:3306/final";
	private static String usuario= "root";
	private static String password="1234";
	
	
	
	public static Connection conectar() {
		Connection  conexion = null;
		
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
			
		} catch (SQLException e) {
			System.out.println("Ocurrio un error al conectar con la base de datos");
		}
		return conexion;
	}
			
}
