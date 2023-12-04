package casaDePeças;

import java.awt.dnd.DropTargetEvent;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class ConnectDataBase {
	
	public static Connection conect() throws IOException {
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
			LogGenerator.generateLog(e.getMessage()+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
			return null;
		}
	}
	
	
}
