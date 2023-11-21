package casaDePeças;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Parts extends Base{
	
	private String description;
	private int amount;
	private double price1;
	private static Object ID;
	private static Object name1;
	private static Object description1;
	private static Object quant;
	private static Object price;
	
	public Parts(String Name, int id, String description, int amount, double price) {
		super(Name, id);
		this.description = description;
		this.amount = amount;
		this.price1=price;
		
	}


	public String getDescription() {
		return this.description;
	}
	public void setDescription(String descrip) {
		this.description = descrip;
	}
	public int getStorage() {
		return this.amount;
	}
	public void setStorage(int storage) {
		this.amount = storage;
	}
	
	public static void addParts(String name, String description, String amount, String price) {
		try {
		String add = "INSERT into parts ("+"Nname,"+"description,"+"amount,"+"price )"+"values ("+"?,"+"?,"+"?,"+"?);";
		
		Connection conexao = ConnectDataBase.conect();
		PreparedStatement ps = conexao.prepareStatement(add);
		ps.setString(1, name.toUpperCase());
		ps.setString(2, description.toUpperCase());
		ps.setString(3, amount);
		ps.setString(4, price);
		ps.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!");
		ps.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void consultParts() {
		Statement s = null;
		Connection conexao = ConnectDataBase.conect();
			try {
				s = (Statement) conexao.createStatement();
				ResultSet r = null;
				r = s.executeQuery("Select * from parts");
				
				DefaultTableModel modelo = (DefaultTableModel) view.PartsView.PartsTb.getModel();
				modelo.setNumRows(0);
				
				while (r.next()) {
					modelo.addRow(new Object[] {r.getInt("partsID"),r.getString("Nname"),r.getString("Description"),r.getInt("Amount"), r.getDouble("price")});
					
				}
				r.close();
			} catch (Exception e) {
				System.out.println(e);				
			}
	}
	
	public static void updateParts(String id) {
		Statement s = null;
		Connection conexao = ConnectDataBase.conect();
			try {
				s = (Statement) conexao.createStatement();
				ResultSet r = null;
				r = s.executeQuery("Select * from parts WHERE partsID = "+id+"");
				
				DefaultTableModel modelo = (DefaultTableModel) view.PartsView.PartsTb.getModel();
				modelo.setNumRows(0);
				
				while (r.next()) {
					modelo.addRow(new Object[] {r.getString("partsID"),r.getString("Nname"),r.getString("Description"),r.getString("Amount"), r.getString("price")});
					try {
						setID(modelo.getDataVector().elementAt(0).elementAt(0));
						setName1(modelo.getDataVector().elementAt(0).elementAt(1));
						setDescription1(modelo.getDataVector().elementAt(0).elementAt(2));
						setQuant(modelo.getDataVector().elementAt(0).elementAt(3));
						setPrice(modelo.getDataVector().elementAt(0).elementAt(4));
					} catch (Exception e) {
						System.out.println(e);
					}
					new view.UpdateParts().setVisible(true);
				}
				r.close();
			} catch (Exception e) {
				System.out.println(e);				
			}
	}
	
	public static void updateParts1(String id, String name, String description, String amount, String price) {
		try {
		String add = "UPDATE parts SET Nname = ?, Description = ?, Amount = ?, price = ? WHERE partsID = "+id+";";
		
		Connection conexao = ConnectDataBase.conect();
		PreparedStatement ps = conexao.prepareStatement(add);
		ps.setString(1, name.toUpperCase());
		ps.setString(2, description.toUpperCase());
		ps.setString(3, amount);
		ps.setString(4, price);
		ps.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
		ps.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}


	public static Object getName1() {
		return name1;
	}
	public static void setName1(Object name1) {
		Parts.name1 = name1;
	}
	public static Object getDescription1() {
		return description1;
	}
	public static void setDescription1(Object description1) {
		Parts.description1 = description1;
	}
	public static Object getQuant() {
		return quant;
	}
	public static void setQuant(Object quant) {
		Parts.quant = quant;
	}
	public static void setID(Object ID) {
		Parts.ID = ID;
	}
	public static void setPrice(Object Price) {
		Parts.price = Price;
	}
	public static Object getPrice() {
		return price;
	}
	public static Object getID() {
		return ID;
	}
	public double getPrice1() {
		return price1;
	}
	public void setPrice1(double price1) {
		this.price1 = price1;
	}

}
