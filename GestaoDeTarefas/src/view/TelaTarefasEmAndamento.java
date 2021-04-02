package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.TarefasController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaTarefasEmAndamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaTarefasEmAndamento;
	private JTable tableTarefasEmAndamento;
	private JTextField tfIdParaAlterar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTarefasEmAndamento frame = new TelaTarefasEmAndamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaTarefasEmAndamento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaTarefasEmAndamento.class.getResource("/img/iconeInicial.PNG")));
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 534);
		telaTarefasEmAndamento = new JPanel();
		telaTarefasEmAndamento.setBackground(new Color(32, 178, 170));
		telaTarefasEmAndamento.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaTarefasEmAndamento.setLayout(new BorderLayout(0, 0));
		setContentPane(telaTarefasEmAndamento);
		
		JPanel panelTarefasEmAndamento = new JPanel();
		panelTarefasEmAndamento.setBackground(new Color(32, 178, 170));
		telaTarefasEmAndamento.add(panelTarefasEmAndamento, BorderLayout.CENTER);
		panelTarefasEmAndamento.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("15dlu"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("15dlu"),},
			new RowSpec[] {
				RowSpec.decode("15dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("10dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("10dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("15dlu"),}));
		
		JLabel lblTarefasEmAndamento = new JLabel("Tarefas em Andamento");
		lblTarefasEmAndamento.setForeground(new Color(255, 255, 255));
		lblTarefasEmAndamento.setFont(new Font("Monospaced", Font.BOLD, 26));
		panelTarefasEmAndamento.add(lblTarefasEmAndamento, "2, 2");
		TarefasController controller = new TarefasController();
		
		JPanel panelIdParaAlterar = new JPanel();
		panelIdParaAlterar.setBackground(new Color(32, 178, 170));
		panelTarefasEmAndamento.add(panelIdParaAlterar, "2, 4, default, fill");
		panelIdParaAlterar.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("60dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblTarefaParaAlterar = new JLabel("ID Tarefa Conclu\u00EDda (favor selecionar na tabela): ");
		lblTarefaParaAlterar.setForeground(new Color(255, 255, 255));
		lblTarefaParaAlterar.setFont(new Font("Monospaced", Font.PLAIN, 14));
		panelIdParaAlterar.add(lblTarefaParaAlterar, "1, 1, right, default");
		
		tfIdParaAlterar = new JTextField();
		tfIdParaAlterar.setBackground(new Color(224, 255, 255));
		panelIdParaAlterar.add(tfIdParaAlterar, "2, 1");
		tfIdParaAlterar.setColumns(10);
		
		JScrollPane scrollTarefasEmAndamento = new JScrollPane();
		scrollTarefasEmAndamento.setViewportBorder(new LineBorder(new Color(0, 153, 153)));
		panelTarefasEmAndamento.add(scrollTarefasEmAndamento, "2, 6, fill, fill");
		
		// Tabela apresenta os dados cadastrados no banco cujo a situação seja "Em andamento"
		// Habilita a seleção de linhas para obter a ID para posterior alteração da situação
		tableTarefasEmAndamento = new JTable();
		tableTarefasEmAndamento.setModel(controller.consultarTarefa("Em andamento"));
		tableTarefasEmAndamento.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int linhaSelecionada = tableTarefasEmAndamento.getSelectedRow();
				tfIdParaAlterar.setText(tableTarefasEmAndamento.getValueAt(linhaSelecionada, 0).toString());
			}
		});
		tableTarefasEmAndamento.setBackground(new Color(224, 255, 255));
		scrollTarefasEmAndamento.setViewportView(tableTarefasEmAndamento);
		
		// Botão para alterar a situação da tarefa
		JButton btnAlterarSituacao = new JButton("Concluir Tarefa");
		btnAlterarSituacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TarefasController controller = new TarefasController();
				int linhaSelecionada = tableTarefasEmAndamento.getSelectedRow();
				tfIdParaAlterar.setText(tableTarefasEmAndamento.getValueAt(linhaSelecionada, 0).toString());
				controller.alterarSituacao(Integer.parseInt(tfIdParaAlterar.getText()));
				JOptionPane.showMessageDialog(null, "Tarefa alterada com sucesso!");
				tableTarefasEmAndamento.setModel(controller.consultarTarefa("Em andamento"));
				scrollTarefasEmAndamento.setViewportView(tableTarefasEmAndamento);
			}
		});
		btnAlterarSituacao.setForeground(new Color(32, 178, 170));
		btnAlterarSituacao.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnAlterarSituacao.setBackground(Color.WHITE);
		panelTarefasEmAndamento.add(btnAlterarSituacao, "2, 8, right, default");
	}

}
