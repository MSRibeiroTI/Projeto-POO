package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import casaDePeças.Parts;
import casaDePeças.casaDePeças;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import java.awt.Canvas;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class UpdateParts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_pName;
	private JTextField textField_amount;
	private JTextField textField_price;


	public UpdateParts() throws IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Produtos");
		lblNewLabel.setFont(new Font("Aachen BT", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 501, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(33, 80, 130, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_pName = new JTextField((String)Parts.getName1());
		textField_pName.setBounds(33, 95, 452, 31);
		contentPane.add(textField_pName);
		textField_pName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(33, 136, 130, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_amount = new JTextField((String)Parts.getQuant());
		textField_amount.setHorizontalAlignment(SwingConstants.CENTER);
		textField_amount.setBounds(33, 151, 96, 31);
		contentPane.add(textField_amount);
		textField_amount.setColumns(10);
		
		JLabel lblNewLabel_description = new JLabel("Descrição");
		lblNewLabel_description.setBounds(33, 192, 96, 13);
		contentPane.add(lblNewLabel_description);
		
		JTextArea textArea_description = new JTextArea((String)Parts.getDescription1());
		textArea_description.setLineWrap(true);
		textArea_description.setBounds(33, 221, 452, 150);
		contentPane.add(textArea_description);
		
		JLabel lblNewLabel_5 = new JLabel((String)Parts.getID());
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(156, 159, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Preço");
		lblNewLabel_6.setBounds(299, 136, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		textField_price = new JTextField((String)Parts.getPrice());
		textField_price.setFont(new Font("Tahoma", Font.BOLD, 17));
		textField_price.setBounds(299, 151, 186, 31);
		contentPane.add(textField_price);
		textField_price.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_pName.getText().equals("") || textField_amount.getText().equals("") || textArea_description.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de salvar.");
				}else {
				
				Parts.updateParts1(lblNewLabel_5.getText(), textField_pName.getText(), textArea_description.getText(), textField_amount.getText(), textField_price.getText());
				dispose();
			
			}}
		});
		btnNewButton.setBounds(33, 381, 113, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_cancel = new JButton("Cancelar");
		btnNewButton_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_cancel.setBounds(156, 381, 113, 36);
		contentPane.add(btnNewButton_cancel);
		
		JLabel lblNewLabel_4 = new JLabel("Nº ID:");
		lblNewLabel_4.setBounds(156, 136, 102, 13);
		contentPane.add(lblNewLabel_4);
		
		
		
		
		
		
		
		
		
		
	}
}
