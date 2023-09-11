package sistemaBancoAvocado;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroConta extends JFrame {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldSaldo = new JTextField();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroConta window = new TelaCadastroConta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroConta() {
		initialize();
	}

	public TelaCadastroConta(JFrame frame) {
		// super(owner, "Tela Anterior", true);
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(
				new ImageIcon(TelaCadastroConta.class.getResource("/sistemaBancoAvocado/icons8-avocado-96.png")));
		lblNewLabel.setBounds(23, 21, 93, 76);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("AVOCADO BANK");
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(254, 21, 164, 37);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("# O Banco do seu jeito");
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(241, 56, 227, 37);
		frame.getContentPane().add(lblNewLabel_2);

		// Incluindo a Data e Hora Atual
		Calendar calendario = Calendar.getInstance();
		int ano = calendario.get(Calendar.YEAR);
		int mes = calendario.get(Calendar.MONTH) + 1; // Mês começa em 0, então adicionamos 1
		int dia = calendario.get(Calendar.DAY_OF_MONTH);

		JLabel lblDataHora = new JLabel(dia + "/" + mes + "/" + ano);
		lblDataHora.setBounds(577, 21, 53, 13);
		frame.getContentPane().add(lblDataHora);

		JLabel lblNewLabel_3 = new JLabel("NOME: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(53, 142, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("SALDO ATUAL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(53, 181, 105, 13);
		frame.getContentPane().add(lblNewLabel_4);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(116, 140, 445, 19);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldSaldo.setBounds(179, 179, 96, 19);
		frame.getContentPane().add(textFieldSaldo);
		textFieldSaldo.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Tipo Conta");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(324, 181, 83, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JRadioButton radionPf = new JRadioButton("PF");
		radionPf.setBounds(420, 178, 53, 21);
		frame.getContentPane().add(radionPf);

		JRadioButton radionPJ = new JRadioButton("PJ");
		radionPJ.setBounds(473, 178, 103, 21);
		frame.getContentPane().add(radionPJ);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 227, 506, 68);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Ag\u00EAncia", "Conta", "Tipo Conta", "Nome", "Saldo" }));
		scrollPane.setViewportView(table);

		// Ações
		// Botão Criar Conta
		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCriarConta.setBackground(new Color(255, 255, 0));
		btnCriarConta.setForeground(new Color(0, 128, 0));
		btnCriarConta.setBounds(53, 394, 123, 21);
		frame.getContentPane().add(btnCriarConta);

		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tipoConta = "";

				String nome = textFieldNome.getText();
				float saldo = Float.parseFloat(textFieldSaldo.getText());
				Random numero = new Random();
				int agencia = numero.nextInt(100) + 1; // Número aleatório de 1..100.
				double conta = numero.nextInt(99999) + 9999;
				if (radionPf.isSelected()) {
					tipoConta = "P. Física";
				} else {
					tipoConta = "P.Jurídica";
				}

				DefaultTableModel tabelaDados = (DefaultTableModel) table.getModel();
				tabelaDados.addRow(new String[] { String.valueOf(agencia), String.valueOf(conta), tipoConta, nome,
						String.valueOf(saldo) });

			}
		});

		// Botão Excluir
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(476, 396, 85, 21);
		frame.getContentPane().add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
			}
		});

		// Botão Depositar
		JButton btnNewButton = new JButton("Depositar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(202, 394, 123, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() != -1) {

					String valor = JOptionPane.showInputDialog("Digite o valor para depósito");
					String saldoAtual = textFieldSaldo.getText();
					String saldoAtualizado = String.valueOf(Float.parseFloat(saldoAtual) + Float.parseFloat(valor));
					textFieldSaldo.setText(saldoAtualizado);
					table.setValueAt(saldoAtualizado, table.getSelectedRow(), 4); // Setando o valor novo na coluna																					// saldo

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma conta para depósito:");
				}
			}
		});

		// Botão Sacar

		JButton btnNewButton_1 = new JButton("Sacar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() != -1) {

					String valor = JOptionPane.showInputDialog("Digite o valor para saque:");
					String saldoAtual = textFieldSaldo.getText();
					String saldoAtualizado = String.valueOf(Float.parseFloat(saldoAtual) - Float.parseFloat(valor));
					textFieldSaldo.setText(saldoAtualizado);
					table.setValueAt(saldoAtualizado, table.getSelectedRow(), 4); // Setando o valor novo na coluna																					// saldo

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma conta para saque");
				}
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(241, 65, 46));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(355, 394, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);

	}

	public void atualizaDadosDeposito(Cliente cliente) {
		// recebe o cliente da tela de depósito com o novo saldo atualizado

		textFieldSaldo.setText(String.valueOf(cliente.getSaldo()));

	}
}
