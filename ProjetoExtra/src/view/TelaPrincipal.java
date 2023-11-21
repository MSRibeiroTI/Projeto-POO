package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import casaDePeças.LogGenerator;
import casaDePeças.casaDePeças;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_title;
	private JButton btnNewButton_sale;
	private JButton btnNewButton_report;
	private JButton btnNewButton_users;
	private JButton btnNewButton_about;


	public TelaPrincipal() {
		setTitle("Gerenciador Comercial");
		setResizable(false);
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Cadastro de Clientes");
		btnNewButton.setBounds(130, 184, 226, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new view.ClientView().setVisible(true);;
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		lblNewLabel_title = new JLabel("GERENCIADOR DE VENDAS");
		lblNewLabel_title.setBounds(10, 12, 692, 31);
		lblNewLabel_title.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_title.setFont(new Font("Aachen BT", Font.BOLD, 25));
		contentPane.add(lblNewLabel_title);
		
		JButton btnNewButton_2 = new JButton("Cadastro de Produtos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view.PartsView().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(130, 234, 226, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cadastro de Fornecedores");
		btnNewButton_3.setBounds(368, 184, 226, 38);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_sale = new JButton("Realizar Venda");
		btnNewButton_sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new view.sales().setVisible(true);
			}
		});
		btnNewButton_sale.setBounds(130, 113, 226, 61);
		contentPane.add(btnNewButton_sale);
		
		JLabel lblNewLabel_2 = new JLabel("Marcelo Ribeiro 2ºP ADS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(541, 344, 163, 13);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_report = new JButton("Vendas Realizadas");
		btnNewButton_report.setBounds(368, 113, 226, 61);
		contentPane.add(btnNewButton_report);
		
		btnNewButton_users = new JButton("Usuários");
		btnNewButton_users.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new view.User().setVisible(true);
			}
		});
		btnNewButton_users.setBounds(130, 285, 226, 38);
		contentPane.add(btnNewButton_users);
		
		btnNewButton_about = new JButton("Sobre");
		btnNewButton_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Programa desenvolvido em JAVA. \nFerramentas utilizadas: IDE Eclipse com WindowBuilder, MySql WorkBench \n"
						+ "Disciplina: Linguagem de Programação Orientada a Objetos\nProfessor: Talles Campos Pacheco\nAluno: Marcelo Ribeiro\n2º Período Análise e Desenvolvimento de Ssistemas.");
			}
		});
		btnNewButton_about.setBounds(368, 234, 226, 38);
		contentPane.add(btnNewButton_about);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					LogGenerator.generateLog("Saiu do Sistema "+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(368, 285, 226, 38);
		contentPane.add(btnNewButton_1);
	}
}
