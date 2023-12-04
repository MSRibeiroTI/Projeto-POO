package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import casaDePeças.Parts;
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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class PartsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable PartsTb;
	private JTextField textFieldbusca;


	public PartsView() {
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
		
		PartsTb = new JTable();
		PartsTb.setFont(new Font("Tahoma", Font.BOLD, 12));
		PartsTb.setAutoCreateRowSorter(true);
		PartsTb.setCellSelectionEnabled(true);
		PartsTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PartsTb.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Descri\u00E7\u00E3o", "Quantidade", "Pre\u00E7o"
			}
		));
		PartsTb.getColumnModel().getColumn(0).setPreferredWidth(23);
		PartsTb.getColumnModel().getColumn(1).setPreferredWidth(244);
		PartsTb.getColumnModel().getColumn(2).setPreferredWidth(303);
		PartsTb.getColumnModel().getColumn(3).setPreferredWidth(50);
		PartsTb.getColumnModel().getColumn(4).setPreferredWidth(50);
		scrollPane.setViewportView(PartsTb);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setBounds(750, 384, 173, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("PRODUTOS CADASTRADOS");
		lblNewLabel.setBounds(10, 10, 913, 34);
		lblNewLabel.setFont(new Font("Aachen BT", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_listAll = new JButton("Listar Todos");
		btnNewButton_listAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Parts.consultParts();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_listAll.setBounds(201, 384, 173, 50);
		contentPane.add(btnNewButton_listAll);


		JButton btnNewButton_addProduct = new JButton("Cadastrar Novo Produto");
		btnNewButton_addProduct.setBounds(10, 384, 181, 50);
		btnNewButton_addProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				new view.AddParts().setVisible(true);
			}
		});
		contentPane.add(btnNewButton_addProduct);
		
		textFieldbusca = new JTextField();
		textFieldbusca.setBounds(10, 68, 467, 29);
		contentPane.add(textFieldbusca);
		textFieldbusca.setColumns(10);
		
		JButton btnNewButton_search = new JButton("Buscar");
		btnNewButton_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldbusca.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Digite algum nome na busca!");;
					
				}else {
				try {
					casaDePeças.searchParts(textFieldbusca.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}}
		});
		btnNewButton_search.setBounds(487, 68, 122, 29);
		contentPane.add(btnNewButton_search);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Produto");
		lblNewLabel_1.setBounds(10, 54, 166, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marcelo Ribeiro 2ºP ADS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(760, 444, 163, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_delete = new JButton("Deletar");
		btnNewButton_delete.setBounds(567, 384, 173, 50);
		contentPane.add(btnNewButton_delete);
		
		JButton btnNewButton_update = new JButton("Atualizar");
		btnNewButton_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String IDUpdate = JOptionPane.showInputDialog("Qual o ID do Produto?");
				try {
					Parts.updateParts(IDUpdate);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_update.setBounds(384, 384, 173, 50);
		contentPane.add(btnNewButton_update);
		
		JLabel lblNewLabel_img = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/produtos.png")).getImage();
		lblNewLabel_img.setIcon(new ImageIcon(img));
		lblNewLabel_img.setBounds(680, 10, 122, 87);
		contentPane.add(lblNewLabel_img);
	
	}
}
