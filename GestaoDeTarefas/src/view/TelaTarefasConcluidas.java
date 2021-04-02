package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.TarefasController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTable;

public class TelaTarefasConcluidas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaTarefasConcluidas;
	private JTable tableTarefasConcluidas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTarefasConcluidas frame = new TelaTarefasConcluidas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaTarefasConcluidas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaTarefasConcluidas.class.getResource("/img/iconeInicial.PNG")));
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 508);
		telaTarefasConcluidas = new JPanel();
		telaTarefasConcluidas.setBackground(new Color(32, 178, 170));
		telaTarefasConcluidas.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaTarefasConcluidas.setLayout(new BorderLayout(0, 0));
		setContentPane(telaTarefasConcluidas);
		
		JPanel panelTarefasConcluidas = new JPanel();
		panelTarefasConcluidas.setBackground(new Color(32, 178, 170));
		telaTarefasConcluidas.add(panelTarefasConcluidas, BorderLayout.CENTER);
		panelTarefasConcluidas.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("15dlu"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("15dlu"),},
			new RowSpec[] {
				RowSpec.decode("15dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("15dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("15dlu"),}));
		
		JLabel lblTarefasConcluidas = new JLabel("Tarefas Conclu\u00EDdas");
		lblTarefasConcluidas.setForeground(new Color(255, 255, 255));
		lblTarefasConcluidas.setFont(new Font("Monospaced", Font.BOLD, 26));
		panelTarefasConcluidas.add(lblTarefasConcluidas, "2, 2");
		
		JScrollPane scrollTarefasConcluidas = new JScrollPane();
		scrollTarefasConcluidas.setViewportBorder(new LineBorder(new Color(0, 153, 153)));
		panelTarefasConcluidas.add(scrollTarefasConcluidas, "2, 4, fill, fill");
		
		// Tabela apresenta os dados cadastrados no banco cujo a situação seja "Em andamento"
		tableTarefasConcluidas = new JTable();
		TarefasController controller = new TarefasController();
		tableTarefasConcluidas.setModel(controller.consultarTarefa("Concluída"));
		tableTarefasConcluidas.setBackground(new Color(224, 255, 255));
		scrollTarefasConcluidas.setViewportView(tableTarefasConcluidas);
	}

}