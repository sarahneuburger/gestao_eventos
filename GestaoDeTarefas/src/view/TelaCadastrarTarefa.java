package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.TarefasController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class TelaCadastrarTarefa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaInserirTarefa;
	private JTextField tfTituloTarefa;
	private JTextField tfDetalhesTarefa;
	private JFormattedTextField tfDataConclusao;
	private MaskFormatter ftmData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarTarefa frame = new TelaCadastrarTarefa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	 // @throws ParseException 
	public TelaCadastrarTarefa() throws ParseException {
		setBackground(new Color(32, 178, 170));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastrarTarefa.class.getResource("/img/iconeInicial.PNG")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 531);
		telaInserirTarefa = new JPanel();
		telaInserirTarefa.setBackground(new Color(32, 178, 170));
		telaInserirTarefa.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaInserirTarefa.setLayout(new BorderLayout(0, 0));
		setContentPane(telaInserirTarefa);
		
		JPanel panelInserirTarefa = new JPanel();
		panelInserirTarefa.setForeground(new Color(255, 255, 255));
		panelInserirTarefa.setBackground(new Color(32, 178, 170));
		telaInserirTarefa.add(panelInserirTarefa, BorderLayout.CENTER);
		panelInserirTarefa.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("20dlu"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("50dlu"),},
			new RowSpec[] {
				RowSpec.decode("15dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("30dlu"),
				RowSpec.decode("15dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("50dlu"),
				RowSpec.decode("15dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("15dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("15dlu:grow"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("20dlu"),}));
		
		JLabel lblTituloInserirTarefa = new JLabel("Inserir Nova Tarefa");
		lblTituloInserirTarefa.setFont(new Font("Monospaced", Font.BOLD, 26));
		lblTituloInserirTarefa.setForeground(new Color(255, 255, 255));
		panelInserirTarefa.add(lblTituloInserirTarefa, "2, 2");
		
		JLabel lblTituloTarefa = new JLabel("T\u00EDtulo: *");
		lblTituloTarefa.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblTituloTarefa.setForeground(new Color(255, 255, 255));
		panelInserirTarefa.add(lblTituloTarefa, "2, 4");
		
		tfTituloTarefa = new JTextField();
		tfTituloTarefa.setForeground(new Color(128, 128, 128));
		tfTituloTarefa.setText("Insira um breve t\u00EDtulo para a tarefa...");
		panelInserirTarefa.add(tfTituloTarefa, "2, 5, fill, fill");
		tfTituloTarefa.setColumns(10);
		
		JLabel lblDetalhesTarefa = new JLabel("Detalhes:");
		lblDetalhesTarefa.setForeground(Color.WHITE);
		lblDetalhesTarefa.setFont(new Font("Monospaced", Font.BOLD, 16));
		panelInserirTarefa.add(lblDetalhesTarefa, "2, 7");
		
		tfDetalhesTarefa = new JTextField();
		tfDetalhesTarefa.setToolTipText("");
		tfDetalhesTarefa.setText("Insira os detalhes da tarefa...");
		tfDetalhesTarefa.setForeground(Color.GRAY);
		tfDetalhesTarefa.setColumns(10);
		panelInserirTarefa.add(tfDetalhesTarefa, "2, 8, fill, fill");
		
		JLabel lblPrevConclusao = new JLabel("Previs\u00E3o para conclus\u00E3o: *");
		lblPrevConclusao.setForeground(Color.WHITE);
		lblPrevConclusao.setFont(new Font("Monospaced", Font.BOLD, 16));
		panelInserirTarefa.add(lblPrevConclusao, "2, 10");
		
		ftmData = new MaskFormatter("####-##-##");
		ftmData.setValidCharacters("0123456789");
		tfDataConclusao = new JFormattedTextField(ftmData);
		tfDataConclusao.setForeground(Color.GRAY);
		panelInserirTarefa.add(tfDataConclusao, "2, 11, left, fill");
		tfDataConclusao.setColumns(10);
			
		JLabel lblStatusTarefa = new JLabel("Status da Tarefa: *");
		lblStatusTarefa.setForeground(Color.WHITE);
		lblStatusTarefa.setFont(new Font("Monospaced", Font.BOLD, 16));
		panelInserirTarefa.add(lblStatusTarefa, "2, 13");
		
		JPanel panelRadioButtons = new JPanel();
		panelRadioButtons.setBackground(new Color(32, 178, 170));
		panelInserirTarefa.add(panelRadioButtons, "2, 14, fill, fill");
		panelRadioButtons.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("20dlu"),
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		ButtonGroup buttonGroup = new javax.swing.ButtonGroup();
		
		JRadioButton rdbtnEmAndamento = new JRadioButton("Em andamento");
		rdbtnEmAndamento.setForeground(Color.WHITE);
		rdbtnEmAndamento.setFont(new Font("Monospaced", Font.PLAIN, 14));
		rdbtnEmAndamento.setBackground(new Color(32, 178, 170));
		panelRadioButtons.add(rdbtnEmAndamento, "1, 1");
		
		JRadioButton rdbtnConcluida = new JRadioButton("Conclu\u00EDda");
		rdbtnConcluida.setForeground(Color.WHITE);
		rdbtnConcluida.setFont(new Font("Monospaced", Font.PLAIN, 14));
		rdbtnConcluida.setBackground(new Color(32, 178, 170));
		panelRadioButtons.add(rdbtnConcluida, "3, 1");
		
		buttonGroup.add(rdbtnEmAndamento);
		buttonGroup.add(rdbtnConcluida);
		
		JButton btnCadastrarTarefa = new JButton("Inserir Tarefa");
		btnCadastrarTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.sql.Date dataConvertida = java.sql.Date.valueOf(tfDataConclusao.getText());
				LocalDate converterJavaLocalDate = dataConvertida.toLocalDate();
				TarefasController controller = new TarefasController();
				try {
					if ((tfTituloTarefa.getText() == null || tfTituloTarefa.getText().trim().isEmpty())
							|| (tfDataConclusao.getText() == null || tfDataConclusao.getText().trim().isEmpty())
							|| (buttonGroup.isSelected(null))) {
						JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
					} else {
						if(rdbtnEmAndamento.isSelected() == true) {						
							controller.cadastrarTarefa(tfTituloTarefa.getText(), tfDetalhesTarefa.getText(),
									converterJavaLocalDate, "Em andamento");
							JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso.");
							tfTituloTarefa.setText("");
							tfDetalhesTarefa.setText("");
							tfDataConclusao.setText("");
							buttonGroup.isSelected(null);
							} else if (rdbtnConcluida.isSelected() == true) {
								controller.cadastrarTarefa(tfTituloTarefa.getText(), tfDetalhesTarefa.getText(),
										converterJavaLocalDate, "Concluída");
								JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso.");
								tfTituloTarefa.setText("");
								tfDetalhesTarefa.setText("");
								tfDataConclusao.setText("");
								buttonGroup.isSelected(null);
							}
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar tarefa.");
					System.out.println(erro.getMessage());
				} catch (ParseException erro) {
					System.out.println(erro.getMessage());
				}

			}
		});
		btnCadastrarTarefa.setForeground(new Color(32, 178, 170));
		btnCadastrarTarefa.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnCadastrarTarefa.setBackground(new Color(255, 255, 255));
		panelInserirTarefa.add(btnCadastrarTarefa, "2, 16, right, default");
			
	}
}