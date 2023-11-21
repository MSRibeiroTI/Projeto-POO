package casaDePeças;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.a.authentication.Sha256PasswordPlugin;

public class Client extends Base{
	
	private String cpf;
	private String address;
	private String phone;
	private String city;
	private String email;
	private static Object name1;
	private static Object cPF1;
	private static Object address1;
	private static Object cidade;
	private static Object phone1;
	private static Object email1;
		
	public Client(String Name, int id, String address, String city, String phone, String email) {
		super(Name, id);
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.email = email;
	}
	
	public static void consultClient(String id) {
		Statement s = null;
		Connection conexao = ConnectDataBase.conect();
			try {
				s = (Statement) conexao.createStatement();
				ResultSet r = null;
				r = s.executeQuery("Select * from cliente WHERE ClienteID = "+id+"");
				
				DefaultTableModel modelo = (DefaultTableModel) view.ClientView.ClientsTb.getModel();
				modelo.setNumRows(0);
				
				while (r.next()) {
					modelo.addRow(new Object[] {r.getInt("ClienteID"),r.getString("Nname"),r.getString("CPF"),r.getString("Address"),r.getString("City"),r.getString("Phone"),r.getString("Email")});
				try {
					setName1((modelo.getDataVector().elementAt(0).elementAt(1)));
					setcPF1((modelo.getDataVector().elementAt(0).elementAt(2)));
					setAddress1((modelo.getDataVector().elementAt(0).elementAt(3)));
					setCidade((modelo.getDataVector().elementAt(0).elementAt(4)));
					setPhone1((modelo.getDataVector().elementAt(0).elementAt(5)));
					setEmail1((modelo.getDataVector().elementAt(0).elementAt(6)));
				} catch (Exception e) {
					System.out.println(e);
				}
					
					
				new view.ClientUpdate().setVisible(true);	
				}
				r.close();
			} catch (Exception e) {
				System.out.println(e);				
			}
	}
	
	public static void updateClient(String name, String CPF, String address, String city, String phone, String email) {
		try {
		String add = "UPDATE cliente SET Nname = ?, CPF = ?, Address = ?, City = ?, Phone = ?, Email = ? WHERE CPF = "+CPF+";";
		
		Connection conexao = ConnectDataBase.conect();
		PreparedStatement ps = conexao.prepareStatement(add);
		ps.setString(1, name.toUpperCase());
		ps.setString(2, CPF);
		ps.setString(3, address.toUpperCase());
		ps.setString(4, city.toUpperCase());
		ps.setString(5, phone);
		ps.setString(6, email);
		ps.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso!");
		
		ps.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void deleteClient() {
		
	}
		
	
	
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf (String cpf) {
		this.cpf = cpf;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public static Object getName1() {
		return name1;
	}

	public static void setName1(Object object) {
		Client.name1 = object;
	}

	public static Object getAddress1() {
		return address1;
	}

	public static void setAddress1(Object address1) {
		Client.address1 = address1;
	}

	public static Object getcPF1() {
		return cPF1;
	}

	public static void setcPF1(Object cPF1) {
		Client.cPF1 = cPF1;
	}

	public static Object getCidade() {
		return cidade;
	}

	public static void setCidade(Object cidade) {
		Client.cidade = cidade;
	}

	public static Object getEmail1() {
		return email1;
	}

	public static void setEmail1(Object email1) {
		Client.email1 = email1;
	}

	public static Object getPhone1() {
		return phone1;
	}

	public static void setPhone1(Object phone1) {
		Client.phone1 = phone1;
	}

	
}
