package sistemaNotas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAluno {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldNome;
	private JTextField textFieldNotaUm;
	private JTextField textFieldNotaDois;
	private JTextField textFieldNotaTres;
	private JTextField textFieldNotaQuatro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno window = new TelaAluno();
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
	public TelaAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SISTEMA NOTAS");
		lblNewLabel.setBounds(144, 11, 123, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 327, 52);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ALUNO", "TIPO", "NOTA1", "NOTA2", " NOTA3", "NOTA4", "M\u00C9DIA"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo Aluno:");
		lblNewLabel_1.setBounds(11, 124, 62, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(11, 99, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(52, 96, 86, 20);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nota1 ");
		lblNewLabel_3.setBounds(38, 171, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textFieldNotaUm = new JTextField();
		textFieldNotaUm.setBounds(38, 196, 27, 20);
		frame.getContentPane().add(textFieldNotaUm);
		textFieldNotaUm.setColumns(10);
		
		JRadioButton rdbtnEspecial = new JRadioButton("Especial");
		rdbtnEspecial.setBounds(79, 120, 109, 23);
		frame.getContentPane().add(rdbtnEspecial);
		
		JRadioButton rdbtnRegular = new JRadioButton("Regular");
		rdbtnRegular.setBounds(190, 120, 77, 23);
		frame.getContentPane().add(rdbtnRegular);
		
		JLabel lblNewLabel_4 = new JLabel("Nota 2");
		lblNewLabel_4.setBounds(94, 171, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nota 3");
		lblNewLabel_5.setBounds(161, 171, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nota4");
		lblNewLabel_6.setBounds(242, 171, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textFieldNotaDois = new JTextField();
		textFieldNotaDois.setBounds(91, 196, 36, 20);
		frame.getContentPane().add(textFieldNotaDois);
		textFieldNotaDois.setColumns(10);
		
		textFieldNotaTres = new JTextField();
		textFieldNotaTres.setBounds(154, 196, 36, 20);
		frame.getContentPane().add(textFieldNotaTres);
		textFieldNotaTres.setColumns(10);
		
		textFieldNotaQuatro = new JTextField();
		textFieldNotaQuatro.setBounds(242, 196, 36, 20);
		frame.getContentPane().add(textFieldNotaQuatro);
		textFieldNotaQuatro.setColumns(10);
		
		JButton btnCriar = new JButton("Calcular");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText();
				float nota1 = Float.parseFloat(textFieldNotaUm.getText());
				float nota2 = Float.parseFloat(textFieldNotaDois.getText());
				float nota3 = Float.parseFloat(textFieldNotaTres.getText());
				float nota4 = Float.parseFloat(textFieldNotaQuatro.getText());
				
				boolean tipoAluno = rdbtnEspecial.isSelected();
				
				//Calculo da média
				float media = (nota1+nota2+nota3+nota4)/4;
				
				DefaultTableModel tabela = (DefaultTableModel) table.getModel();
				tabela.addRow(new String[] { nome, "Especial", 
						String.valueOf(nota1), String.valueOf(nota2), 
						String.valueOf(nota3), String.valueOf(nota4), 
						String.valueOf(media) });
				
				
			}
		});
		btnCriar.setBounds(38, 226, 89, 23);
		frame.getContentPane().add(btnCriar);
		
		JButton btnExcluir = new JButton("Deletar");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(210, 226, 89, 23);
		frame.getContentPane().add(btnExcluir);
	}
}
