package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import casaDePeças.Client;
import casaDePeças.LogGenerator;
import casaDePeças.UserClass;
import casaDePeças.casaDePeças;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable userTable;
	private final JLabel lblNewLabel_2 = new JLabel("Marcelo Ribeiro 2ºP ADS");

	
	public User() {
		setTitle("Gerenciador Comercial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 827, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 562, 230);
		contentPane.add(scrollPane);
		
		userTable = new JTable();
		userTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Nome", "Senha", "Fun\u00E7\u00E3o", "ID"
			}
		));
		userTable.getColumnModel().getColumn(0).setPreferredWidth(300);
		userTable.getColumnModel().getColumn(1).setPreferredWidth(30);
		userTable.getColumnModel().getColumn(2).setPreferredWidth(89);
		scrollPane.setViewportView(userTable);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.setBounds(582, 90, 221, 38);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				casaDePeças.consultUser();
			
		}});
		
		JButton btnNewButton_add = new JButton("Cadastrar");
		btnNewButton_add.setBounds(582, 138, 221, 38);
		contentPane.add(btnNewButton_add);
		btnNewButton_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view.UserAdd().setVisible(true);
			
		}});
		
		JButton btnNewButton_updPass = new JButton("Atualizar Senha");
		btnNewButton_updPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String IDUpdate = JOptionPane.showInputDialog("Qual o ID do Usuário?");
				try {
					UserClass.UserSerch(IDUpdate);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_updPass.setBounds(582, 186, 221, 38);
		contentPane.add(btnNewButton_updPass);
		
		JButton btnNewButton_delete = new JButton("Deletar");
		btnNewButton_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String ID = JOptionPane.showInputDialog("Qual a ID do usuário a ser deletado?");
				try {
					UserClass.deleteUser(ID);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_delete.setBounds(582, 234, 221, 38);
		contentPane.add(btnNewButton_delete);
		
		JLabel lblNewLabel_title = new JLabel("Administração dos Usuários do Sistema");
		lblNewLabel_title.setFont(new Font("Aachen BT", Font.BOLD, 25));
		lblNewLabel_title.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_title.setBounds(10, 10, 793, 29);
		contentPane.add(lblNewLabel_title);
		
		JButton btnNewButton_exit = new JButton("Sair");
		btnNewButton_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					LogGenerator.generateLog("Saiu do cadastro de usuário"+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_exit.setBounds(582, 282, 221, 38);
		contentPane.add(btnNewButton_exit);
		lblNewLabel_2.setBounds(515, 310, 288, 36);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_img = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		lblNewLabel_img.setIcon(new ImageIcon(img));
		lblNewLabel_img.setBounds(681, 10, 100, 70);
		contentPane.add(lblNewLabel_img);
	}
}
