package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import casaDePeças.Client;
import casaDePeças.casaDePeças;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Address;
	private JTextField textField_City;
	private JTextField textField_Phone;
	private JTextField textField_Email;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientUpdate frame = new ClientUpdate();
//					frame.setLocationRelativeTo(null);
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
	public ClientUpdate() {
		setTitle("Gerenciador Comercial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(25, 63, 45, 13);
		contentPane.add(lblNewLabel);
		
		textField_Name = new JTextField((String) Client.getName1());
		textField_Name.setBounds(25, 76, 497, 30);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setBounds(25, 116, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_Address = new JTextField((String) Client.getAddress1());
		textField_Address.setBounds(25, 131, 497, 30);
		contentPane.add(textField_Address);
		textField_Address.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cidade");
		lblNewLabel_2.setBounds(25, 171, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(277, 171, 85, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_City = new JTextField((String) Client.getCidade());
		textField_City.setBounds(25, 183, 225, 30);
		contentPane.add(textField_City);
		textField_City.setColumns(10);
		
		textField_Phone = new JTextField((String) Client.getPhone1());
		textField_Phone.setBounds(277, 183, 245, 30);
		contentPane.add(textField_Phone);
		textField_Phone.setColumns(10);
		
		textField_Email = new JTextField((String) Client.getEmail1());
		textField_Email.setBounds(25, 235, 497, 30);
		contentPane.add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel((String) Client.getcPF1());
		lblNewLabel_6.setBounds(25, 282, 192, 28);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(437, 289, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_Name.getText().equals("") || textField_Address.getText().equals("") || textField_City.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Informações incompletas!");;
					
				}else {
				
				Client.updateClient(textField_Name.getText(), lblNewLabel_6.getText(), textField_Address.getText(), textField_City.getText(), textField_Phone.getText(), textField_Email.getText());		
				ClientUpdate.this.dispose();		}
		}});
			
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(335, 289, 85, 21);
		contentPane.add(btnNewButton_1);{
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ClientUpdate.this.dispose();
						}
			});
			
		}
		
		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setBounds(25, 223, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ATUALIZAÇÃO DE CLINTES");
		lblNewLabel_5.setFont(new Font("Aachen BT", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 10, 542, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Marcelo Ribeiro 2ºP ADS");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(389, 358, 163, 13);
		contentPane.add(lblNewLabel_2_1);
		
		
	}
}
