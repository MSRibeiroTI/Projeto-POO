package casaDePeças;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserClass {
	
	private static Object Name;
	private static Object Pass;
	private static Object Cargo;
	private static Object ID1;
	
	
	public static void UpdateUser(String name, String pass, String cargo, String ID) {
		try {
		String add = "UPDATE usuario SET nome = ?, pass = ?, cargo = ? WHERE ID = "+ID+";";
		
		Connection conexao = ConnectDataBase.conect();
		PreparedStatement ps = conexao.prepareStatement(add);
		ps.setString(1, name.toUpperCase());
		ps.setString(2, pass);
		ps.setString(3, cargo.toUpperCase());
		ps.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!");
		ps.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void UserSerch(String id) {
		
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
					
					} catch (Exception e) {
					System.out.println(e);
				}
					
					
				new view.UserUpdate().setVisible(true);	
				}
				r.close();
			} catch (Exception e) {
				System.out.println(e);				
			}
	}
	public static void deleteUser() {
		
	}

	public static Object getName() {
		return Name;
	}

	public static void setName(Object name) {
		Name = name;
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

}}
