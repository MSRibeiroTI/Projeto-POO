package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import casaDePeças.UserClass;
import casaDePeças.casaDePeças;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UserUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NameUser;
	private JTextField textField_cargo;
	private JPasswordField passwordField;


	public UserUpdate() {
		setTitle("Gerenciador Comercial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atualizar Usuário");
		lblNewLabel.setFont(new Font("Aachen BT", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 506, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Usuário");
		lblNewLabel_1.setBounds(97, 94, 174, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_NameUser = new JTextField((String) UserClass.getName1());
		textField_NameUser.setBounds(97, 106, 338, 31);
		contentPane.add(textField_NameUser);
		textField_NameUser.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cargo");
		lblNewLabel_2.setBounds(97, 147, 70, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_cargo = new JTextField((String) UserClass.getCargo());
		textField_cargo.setBounds(97, 159, 338, 31);
		contentPane.add(textField_cargo);
		textField_cargo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(97, 200, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField((String) UserClass.getPass());
		passwordField.setBounds(97, 215, 338, 31);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setBounds(200, 51, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_IdUser = new JLabel((String) UserClass.getID1());
		lblNewLabel_IdUser.setBounds(223, 51, 45, 13);
		contentPane.add(lblNewLabel_IdUser);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textField_NameUser.getText().equals("") || textField_cargo.getText().equals("") || passwordField.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Informações incompletas!");;
					
				}else {
				
				try {
					UserClass.UpdateUser(textField_NameUser.getText(), passwordField.getText(), textField_cargo.getText(), lblNewLabel_IdUser.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}		
				UserUpdate.this.dispose();
			}
		}});
		btnNewButton.setBounds(158, 277, 114, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(282, 277, 114, 41);
		contentPane.add(btnNewButton_1);
		
		
	}
}
