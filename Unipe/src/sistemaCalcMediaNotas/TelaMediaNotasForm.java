package sistemaCalcMediaNotas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;


public class TelaMediaNotasForm {

	private JFrame frame;
	private JTable table_notas;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField notaUm;
	private JTextField notaDois;
	private JTextField notaTres;
	private JTextField notaQuatro;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMediaNotasForm window = new TelaMediaNotasForm();
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
	public TelaMediaNotasForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 822, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("MÉDIA NOTAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(342, 10, 119, 30);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 86, 698, 115);
		frame.getContentPane().add(scrollPane);

		table_notas = new JTable();
		table_notas.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Aluno", "Nota1", "Nota2", "Nota3", "Nota4", "M\u00E9dia" }));
		scrollPane.setViewportView(table_notas);

		lblNewLabel_1 = new JLabel("NOTA 1");
		lblNewLabel_1.setBounds(159, 287, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("NOTA2");
		lblNewLabel_2.setBounds(316, 287, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("NOTA3");
		lblNewLabel_3.setBounds(460, 287, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("NOTA4");
		lblNewLabel_4.setBounds(611, 287, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);

		notaUm = new JTextField();
		notaUm.setBounds(136, 300, 96, 19);
		frame.getContentPane().add(notaUm);
		notaUm.setColumns(10);

		notaDois = new JTextField();
		notaDois.setBounds(294, 300, 96, 19);
		frame.getContentPane().add(notaDois);
		notaDois.setColumns(10);

		notaTres = new JTextField();
		notaTres.setBounds(439, 300, 96, 19);
		frame.getContentPane().add(notaTres);
		notaTres.setColumns(10);

		notaQuatro = new JTextField();
		notaQuatro.setBounds(587, 300, 96, 19);
		frame.getContentPane().add(notaQuatro);
		notaQuatro.setColumns(10);

		lblNewLabel_5 = new JLabel("Escolha o tipo do Aluno:");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(136, 222, 160, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		JRadioButton rdbEspecial = new JRadioButton("Especial");
		JRadioButton rdbRegular = new JRadioButton("Regular");
		
			
		rdbEspecial.setForeground(new Color(0, 128, 0));
		rdbEspecial.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbEspecial.setBounds(497, 228, 103, 21);
		frame.getContentPane().add(rdbEspecial);


		
		rdbRegular.setForeground(new Color(0, 128, 0));
		rdbRegular.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbRegular.setBounds(316, 228, 103, 21);
		frame.getContentPane().add(rdbRegular);


		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Recebendo da Tela
				String nota1 = notaUm.getText();
				String nota2 = notaDois.getText();
				String nota3 = notaTres.getText();
				String nota4 = notaQuatro.getText();
				String aluno = null;
				

				float media = 0.0f;

				// Chamada usando polimorfismo
				// Aluno Recular Selecionado
				if (rdbRegular.isSelected()) {

					Aluno alunoRegular = new AlunoRegular();
					media = alunoRegular.calcularMedia(Float.parseFloat(nota1), Float.parseFloat(nota2),
							Float.parseFloat(nota3), Float.parseFloat(nota4));
					
					aluno = "Regular";
					
				}

				if (rdbEspecial.isSelected()) {
					
					Aluno alunoEspecial = new AlunoEspecial();
					media = alunoEspecial.calcularMedia(Float.parseFloat(nota1), Float.parseFloat(nota2),
							Float.parseFloat(nota3), Float.parseFloat(nota4));
					
					aluno = "Especial";
		
				}

				// Adicionar as notas e média na tabela
				DefaultTableModel tabela = (DefaultTableModel) table_notas.getModel();
				tabela.addRow(new String[] { aluno, nota1, nota2, nota3, nota4, String.valueOf(media) });

				// Limpar Campos
				notaUm.setText("");
				notaDois.setText("");
				notaTres.setText("");
				notaQuatro.setText("");
				rdbEspecial.setSelected(false);
				rdbRegular.setSelected(false);

				notaUm.requestFocus();

			}
		});
		
		btnCadastro.setBounds(136, 364, 96, 21);
		frame.getContentPane().add(btnCadastro);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Remove a linha selecionada.
				((DefaultTableModel) table_notas.getModel()).removeRow(table_notas.getSelectedRow());
			}
		});
		btnExcluir.setBounds(590, 364, 93, 21);
		frame.getContentPane().add(btnExcluir);

	}
}
