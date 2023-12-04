package casaDePeças;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserClass extends Base {
	private String password;
	private String function;
	
	public UserClass(String Name, int id, String function, String password) {
		super(Name, id);
		this.function = function;
		this.password = password;
		
	}

	private static Object Name1;
	private static Object Pass;
	private static Object Cargo;
	private static Object ID1;
	
	
	public static void UpdateUser(String name, String pass, String cargo, String ID) throws IOException {
		try {
		String add = "UPDATE usuario SET nome = ?, pass = ?, cargo = ? WHERE ID = "+ID+";";
		
		Connection conexao = ConnectDataBase.conect();
		PreparedStatement ps = conexao.prepareStatement(add);
		ps.setString(1, name.toUpperCase());
		ps.setLong(2, pass.hashCode());
		ps.setString(3, cargo.toUpperCase());
		ps.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!");
		LogGenerator.generateLog("Alteração de Usuário ID: "+ID+" "+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		ps.close();
		}catch(Exception e) {
			System.out.println(e);
			LogGenerator.generateLog("ERRO: "+e+" "+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		}
	}
	
	public static void UserSerch(String id) throws IOException {
		
		Statement s = null;
		Connection conexao = ConnectDataBase.conect();
			try {
				s = (Statement) conexao.createStatement();
				ResultSet r = null;
				r = s.executeQuery("Select * from usuario WHERE ID = "+id+"");
				
				DefaultTableModel modelo = (DefaultTableModel) view.User.userTable.getModel();
				modelo.setNumRows(0);
				
				while (r.next()) {
					modelo.addRow(new Object[] {r.getString("nome"), r.getString("pass"), r.getString("cargo"), r.getString("ID")});
				try {
					setName((modelo.getDataVector().elementAt(0).elementAt(0)));
					setCargo((modelo.getDataVector().elementAt(0).elementAt(2)));
					setPass((modelo.getDataVector().elementAt(0).elementAt(1)));
					setID1(modelo.getDataVector().elementAt(0).elementAt(3));
					
					LogGenerator.generateLog("Consulta Usuário ID: "+id+" "+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
					
					} catch (Exception e) {
					System.out.println(e);
				}
					
					
				new view.UserUpdate().setVisible(true);	
				}
				r.close();
			} catch (Exception e) {
				System.out.println(e);
				LogGenerator.generateLog("ERRO: "+e+" "+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
			}
	}
	public static void deleteUser(String id) throws IOException {
		try {
			String del = "DELETE FROM usuario WHERE ID = '"+id+"'";

			Connection conexao = ConnectDataBase.conect();
			PreparedStatement ps = conexao.prepareStatement(del);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Dados Deletados com Sucesso!");
			LogGenerator.generateLog("Usuário Deletado ID: "+id  +LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
			ps.close();
			}catch(Exception e) {
				System.out.println(e);
				LogGenerator.generateLog("ERRO: "+e+" "+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
			}
		}
		
	

	public static Object getName1() {
		return Name1;
	}

	public static void setName(Object name) {
		Name1 = name;
	}

	public static Object getPass() {
		return Pass;
	}

	public static void setPass(Object pass) {
		Pass = pass;
	}

	public static Object getCargo() {
		return Cargo;
	}

	public static void setCargo(Object cargo) {
		Cargo = cargo;
	}
	public static Object getID1() {
		return ID1;
	}

	public static void setID1(Object id) {
		ID1 = id;
}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}}
