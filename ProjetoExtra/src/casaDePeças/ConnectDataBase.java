package casaDePeças;

import java.awt.dnd.DropTargetEvent;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


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
			LogGenerator.generateLog("Login no Sistema "+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
}
