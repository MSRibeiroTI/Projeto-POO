package casaDePeças;

import java.sql.*;


public class ConnectDataBase {
	
	public static Connection conect() {
		java.sql.Connection conexao = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/houseparts";
		String user = "root";
		String password = "marcelo81";
		
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão bem sucedida!");
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
}
