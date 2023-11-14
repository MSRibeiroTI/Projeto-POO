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
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import java.awt.Canvas;
import javax.swing.JFormattedTextField;

public class AddParts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddParts frame = new AddParts();
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
	public AddParts() {
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
		
		textField = new JTextField();
		textField.setBounds(33, 95, 452, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(33, 136, 130, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(33, 151, 96, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descrição");
		lblNewLabel_3.setBounds(33, 192, 96, 13);
		contentPane.add(lblNewLabel_3);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(33, 208, 452, 163);
		contentPane.add(editorPane);
		
		JLabel lblNewLabel_4 = new JLabel("Preço");
		lblNewLabel_4.setBounds(224, 136, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Aachen BT", Font.BOLD, 17));
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setBounds(223, 151, 262, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || editorPane.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de salvar.");
				}else {
				
				Parts.addParts(textField.getText(), editorPane.getText(), textField_1.getText(), textField_2.getText());
				dispose();
			
			}}
		});
		btnNewButton.setBounds(33, 381, 113, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(156, 381, 113, 36);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}
}
