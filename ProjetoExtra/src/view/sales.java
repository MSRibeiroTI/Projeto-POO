package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class sales extends JFrame {

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
//					sales frame = new sales();
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
	public sales() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 733, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(32, 99, 97, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(32, 114, 324, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.setBounds(366, 114, 97, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Produto");
		lblNewLabel_1.setBounds(32, 153, 97, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(32, 167, 188, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Incluir");
		btnNewButton_1.setBounds(366, 167, 97, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(230, 153, 126, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(230, 167, 126, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		Image img1 = new ImageIcon(this.getClass().getResource("/octopus.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img1));
		lblNewLabel_3.setBounds(540, 44, 118, 122);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total:");
		lblNewLabel_4.setFont(new Font("Aachen BT", Font.BOLD, 20));
		lblNewLabel_4.setBounds(513, 309, 126, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Painel de Vendas");
		lblNewLabel_5.setFont(new Font("Aachen BT", Font.BOLD, 20));
		lblNewLabel_5.setBounds(32, 32, 243, 36);
		contentPane.add(lblNewLabel_5);
	}
}
