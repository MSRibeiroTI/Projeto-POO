package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import casaDePeças.Client;
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
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable userTable;
	private final JLabel lblNewLabel_2 = new JLabel("Marcelo Ribeiro 2ºP ADS");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					User frame = new User();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
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
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBounds(582, 138, 221, 38);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view.UserAdd().setVisible(true);
			
		}});
		
		JButton btnNewButton_2 = new JButton("Atualizar Senha");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String IDUpdate = JOptionPane.showInputDialog("Qual o ID do Usuário?");
				UserClass.UserSerch(IDUpdate);
				
			}
		});
		btnNewButton_2.setBounds(582, 186, 221, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton_3.setBounds(582, 234, 221, 38);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Administração dos Usuários do Sistema");
		lblNewLabel.setFont(new Font("Aachen BT", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 793, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Sair");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setBounds(582, 282, 221, 38);
		contentPane.add(btnNewButton_4);
		lblNewLabel_2.setBounds(515, 310, 288, 36);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(681, 10, 100, 70);
		contentPane.add(lblNewLabel_1);
	}
}
