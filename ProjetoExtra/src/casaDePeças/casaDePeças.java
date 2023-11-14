package casaDePeças;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.a.authentication.Sha256PasswordPlugin;

import view.ClientView;
import view.Login;

import java.awt.Choice;
import java.awt.Desktop.Action;
import java.sql.*;


public class casaDePeças {
	private static String CPF = null;
	static Connection conexao = null;
	public static Client Client;
	PreparedStatement pst = null;
	ResultSet rs= null;
	private static String searche;
	
	public static void consult() {
		Statement s = null;
		Connection conexao = ConnectDataBase.conect();
			try {
				s = (Statement) conexao.createStatement();
				ResultSet r = null;
				r = s.executeQuery("Select * from cliente");
				
				DefaultTableModel modelo = (DefaultTableModel) view.ClientView.ClientsTb.getModel();
				modelo.setNumRows(0);
				
				while (r.next()) {
					modelo.addRow(new Object[] {r.getInt("ClienteID"),r.getString("Nname"),r.getString("CPF"),r.getString("Address"),r.getString("City"),r.getString("Phone"),r.getString("Email")});
					
				}
				r.close();
			} catch (Exception e) {
				System.out.println(e);				
			}
	}
	
	public static void consultUser() {
		Statement s = null;
		Connection conexao = ConnectDataBase.conect();
			try {
				s = (Statement) conexao.createStatement();
				ResultSet r = null;
				r = s.executeQuery("Select * from usuario");
				
				DefaultTableModel modelo = (DefaultTableModel) view.User.userTable.getModel();
				modelo.setNumRows(0);
				
				while (r.next()) {
					modelo.addRow(new Object[] {r.getString("nome"), r.getString("pass"), r.getString("cargo"), r.getString("ID")});
					
				}
				r.close();
			} catch (Exception e) {
				System.out.println(e);				
			}
	}
	
	
	public static void search(String search) {
		searche = search;
		Statement s = null;
		Connection conexao = ConnectDataBase.conect();
			try {
				s = (Statement) conexao.createStatement();
				ResultSet r = null;
				r = s.executeQuery("Select * from cliente WHERE Nname LIKE '%"+search+"%'");
				
				DefaultTableModel modelo = (DefaultTableModel) view.ClientView.ClientsTb.getModel();
				modelo.setNumRows(0);
				
				while (r.next()) {
					modelo.addRow(new Object[] {r.getInt("ClienteID"),r.getString("Nname"),r.getString("CPF"),r.getString("Address"),r.getString("City"),r.getString("Phone"),r.getString("Email")});
					
				}
				r.close();
			} catch (Exception e) {
				System.out.println(e);				
			}
	}
	
	public static void searchParts(String searchP) {
		searche = searchP;
		Statement s = null;
		Connection conexao = ConnectDataBase.conect();
			try {
				s = (Statement) conexao.createStatement();
				ResultSet r = null;
				r = s.executeQuery("Select * from parts WHERE Nname LIKE '%"+searchP+"%'");
				
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
	//Função para rodar no console.
//	public static void consult1() {
//		Statement s = null;
//		Connection conexao = ConnectDataBase.conect();
//			try {
//				s = (Statement) conexao.createStatement();
//				ResultSet r = null;
//				r = s.executeQuery("Select * from cliente");
//			
//				while (r.next()) {
//					System.out.println(r.getInt("ClienteID")+" "+r.getString("Nname")+" "+r.getString("CPF")+" "+r.getString("Address")+" "+r.getString("City")+" "+r.getString("Phone")+" "+r.getString("Email"));
//						}
//				r.close();
//			} catch (Exception e) {
//				System.out.println(e);				
//			}
//	}
	//Função para rodar no console.
//	public static void addUser() {
//		try {
//		String add = "insert into cliente ("+"Nname,"+"CPF,"+"Address,"+"City,"+"Phone,"+"Email)"+"values("+"?,"+"?,"+"?,"+"?,"+"?,"+"?);";
//		String Nname = null;
//		String CPF = null;
//		String Address = null;
//		String City = null;
//		String Phone = null;
//		String Email = null;
//		Scanner ins = new Scanner(System.in);
//		
//		System.out.printf("Informe um CPF: ");
//			CPF = ins.nextLine();
//		   	if (ValidateCPF.isCPF(CPF) == true) {
//		   		System.out.printf("%s\n", ValidateCPF.imprimeCPF(CPF));
//		  	   	System.out.println("Digite o nome do novo cliente:");
//		  	   	Nname = ins.nextLine();
//		      	System.out.println("Digite o nome da Rua:");
//		      	Address = ins.nextLine();
//		      	System.out.println("Digite a cidade:");
//		      	City = ins.nextLine();
//		      	System.out.println("Digite o número do telefone:");
//		      	Phone = ins.nextLine();
//		      	System.out.println("Digite o e-mail:");
//		      	Email = ins.nextLine();
//		   	}else System.out.println("Erro, CPF invalido !!!\n");
//		
//		Connection conexao = ConnectDataBase.conect();
//		PreparedStatement ps = conexao.prepareStatement(add);
//		ps.setString(1, Nname.toUpperCase());
//		ps.setString(2, CPF);
//		ps.setString(3, Address.toUpperCase());
//		ps.setString(4, City.toUpperCase());
//		ps.setString(5, Phone);
//		ps.setString(6, Email);
//		ps.executeUpdate();
//		
//		System.out.println("Dados Salvos com Sucesso!");;
//		ins.close();
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//	}
	
	public static void validCPF() {
		CPF = JOptionPane.showInputDialog("Digite um CPF válido, só os números:");
	   	if (ValidateCPF.isCPF(CPF) == true) {
	   		new view.ClientAdd().setVisible(true);
	   			  			   		
	   		}else JOptionPane.showMessageDialog(null, "Erro, CPF inválido !!!\n");
		}
	
	//Função para rodar no JFrame.
	public static void addUser1(String name, String address, String city, String phone, String email) {
		try {
		String add = "INSERT into cliente ("+"Nname,"+"CPF,"+"Address,"+"City,"+"Phone,"+"Email)"+"values ("+"?,"+"?,"+"?,"+"?,"+"?,"+"?);";
		
		Connection conexao = ConnectDataBase.conect();
		PreparedStatement ps = conexao.prepareStatement(add);
		ps.setString(1, name.toUpperCase());
		ps.setString(2, CPF);
		ps.setString(3, address.toUpperCase());
		ps.setString(4, city.toUpperCase());
		ps.setString(5, phone);
		ps.setString(6, email);
		ps.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!");
		ps.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
			System.out.println(e);
		}
	}
	
	public static void addAdmin(String name, String cargo, String pass) {
		try {
		String add = "INSERT into usuario ("+"nome,"+"pass,"+"cargo)"+"values ("+"?,"+"?,"+"?);";

		Connection conexao = ConnectDataBase.conect();
		PreparedStatement ps = conexao.prepareStatement(add);
		ps.setString(1, name.toUpperCase());
		ps.setString(2, pass);
		ps.setString(3, cargo.toUpperCase());
		ps.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!");
		ps.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
		
	public static void login(String nome, String pass) {
		Statement s = null;
		Connection conexao = ConnectDataBase.conect();
			try {
				s = (Statement) conexao.createStatement();
				ResultSet r = null;
				r = s.executeQuery("Select nome, pass from usuario where nome = '"+nome+"' AND pass = '"+pass+"'");
				
				if(r.next()) {
					new view.TelaPrincipal().setVisible(true);
								
				}else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta");
					}
			
				r.close();
			} catch (Exception e) {
				System.out.println(e);		
	}}}


//	public static void main(String[] args) {
//		
//		
//		//casaDePeças.login("marcel", "teste");		
//		//casaDePeças.consult1();
//		//casaDePeças.addUser();
//	
//		
//	
//	
//	}
//
//		
//
//}
