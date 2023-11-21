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

public class ClientAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_address;
	private JTextField textField_city;
	private JTextField textField_phone;
	private JTextField textField_email;


	public ClientAdd() {
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
		
		textField_name = new JTextField();
		textField_name.setBounds(25, 76, 497, 30);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setBounds(25, 116, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_address = new JTextField();
		textField_address.setBounds(25, 131, 497, 30);
		contentPane.add(textField_address);
		textField_address.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cidade");
		lblNewLabel_2.setBounds(25, 171, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(277, 171, 85, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_city = new JTextField();
		textField_city.setBounds(25, 183, 225, 30);
		contentPane.add(textField_city);
		textField_city.setColumns(10);
		
		textField_phone = new JTextField();
		textField_phone.setBounds(277, 183, 245, 30);
		contentPane.add(textField_phone);
		textField_phone.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setBounds(25, 235, 497, 30);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(437, 289, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_name.getText().equals("") || textField_address.getText().equals("") || textField_city.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Informações incompletas!");;
					
				}else {
				
				casaDePeças.addUser1(textField_name.getText(), textField_address.getText(), textField_city.getText(), textField_phone.getText(), textField_email.getText());		
				ClientAdd.this.dispose();		}
		}});
			
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(335, 289, 85, 21);
		contentPane.add(btnNewButton_1);{
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ClientAdd.this.dispose();
						}
			});
			
		}
		
		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setBounds(25, 223, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CADASTRO DE CLINTES");
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
