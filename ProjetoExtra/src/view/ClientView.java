package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import casaDePeças.Client;
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
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.Point;

public class ClientView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable ClientsTb;
	private JTextField textFieldbusca;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientView frame = new ClientView();
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
	public ClientView() {
		setResizable(false);
		setTitle("Gerenciador Comercial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 947, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 913, 267);
		contentPane.add(scrollPane);
		
		ClientsTb = new JTable();
		ClientsTb.setAutoCreateRowSorter(true);
		ClientsTb.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "CPF", "Endere\u00E7o", "Cidade", "Telefone", "E-mail"
			}
		));
		ClientsTb.getColumnModel().getColumn(0).setPreferredWidth(23);
		ClientsTb.getColumnModel().getColumn(1).setPreferredWidth(180);
		ClientsTb.getColumnModel().getColumn(2).setPreferredWidth(83);
		ClientsTb.getColumnModel().getColumn(3).setPreferredWidth(103);
		ClientsTb.getColumnModel().getColumn(6).setPreferredWidth(101);
		scrollPane.setViewportView(ClientsTb);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setBounds(750, 384, 173, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CLIENTES CADASTRADOS");
		lblNewLabel.setBounds(10, 10, 913, 34);
		lblNewLabel.setFont(new Font("Aachen BT", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Listar Todos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				casaDePeças.consult();
			}
		});
		btnNewButton_1.setBounds(201, 384, 173, 50);
		contentPane.add(btnNewButton_1);


		btnNewButton_1 = new JButton("Cadastrar Novo Cliente");
		btnNewButton_1.setBounds(10, 384, 181, 50);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				casaDePeças.validCPF();
			}
		});
		contentPane.add(btnNewButton_1);
		
		textFieldbusca = new JTextField();
		textFieldbusca.setBounds(10, 68, 467, 29);
		contentPane.add(textFieldbusca);
		textFieldbusca.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldbusca.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Digite algum nome na busca!");;
					
				}else {
				casaDePeças.search(textFieldbusca.getText());
			}}
		});
		btnNewButton_2.setBounds(487, 68, 122, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Cliente");
		lblNewLabel_1.setBounds(10, 54, 166, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marcelo Ribeiro 2ºP ADS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(760, 444, 163, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton_3.setBounds(567, 384, 173, 50);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Atualizar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDUpdate = JOptionPane.showInputDialog("Qual o ID do cliente?");
				Client.UpdateClient(IDUpdate);
			}
		});
		btnNewButton_4.setBounds(384, 384, 173, 50);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/cliente.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(679, 10, 173, 87);
		contentPane.add(lblNewLabel_3);
	
	}
}