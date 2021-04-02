package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaInicial;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/img/iconeInicial.PNG")));
		setForeground(new Color(32, 178, 170));
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("Gest\u00E3o de Tarefas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 500);
		telaInicial = new JPanel();
		telaInicial.setBackground(new Color(32, 178, 170));
		telaInicial.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaInicial.setLayout(new BorderLayout(0, 0));
		setContentPane(telaInicial);
		
		JPanel panelInicial = new JPanel();
		panelInicial.setBackground(new Color(32, 178, 170));
		telaInicial.add(panelInicial, BorderLayout.CENTER);
		panelInicial.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("30dlu"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("8dlu"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("30dlu"),},
			new RowSpec[] {
				RowSpec.decode("30dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("30dlu"),}));
		
		JLabel lblTitulo = new JLabel("Gest\u00E3o de Tarefas");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBackground(new Color(32, 178, 170));
		lblTitulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTitulo.setFont(new Font("Monospaced", Font.BOLD, 26));
		panelInicial.add(lblTitulo, "2, 2");
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(null);
		panelMenu.setBackground(new Color(32, 178, 170));
		panelInicial.add(panelMenu, "2, 3, fill, fill");
		panelMenu.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("50dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("15dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("15dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnNovaTarefa = new JButton("Inserir Nova Tarefa");
		btnNovaTarefa.setForeground(new Color(255, 255, 255));
		btnNovaTarefa.setBackground(new Color(95, 158, 160));
		btnNovaTarefa.setFont(new Font("Monospaced", Font.BOLD, 18));
		panelMenu.add(btnNovaTarefa, "1, 2");
		btnNovaTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarTarefa frameCadTarefa = null;
				try {
					frameCadTarefa = new TelaCadastrarTarefa();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				frameCadTarefa.setVisible(true);
			}
			
		});
		
		JButton btnTarefasEmAndamento = new JButton("Tarefas em Andamento");
		btnTarefasEmAndamento.setForeground(Color.WHITE);
		btnTarefasEmAndamento.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnTarefasEmAndamento.setBackground(new Color(95, 158, 160));
		panelMenu.add(btnTarefasEmAndamento, "1, 4");
		btnTarefasEmAndamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTarefasEmAndamento frameTarefasAndamento = null;
				frameTarefasAndamento = new TelaTarefasEmAndamento();
				frameTarefasAndamento.setVisible(true);
			} 
		});
		
		JButton btnTarefasConcluidas = new JButton("Tarefas Conclu\u00EDdas");
		btnTarefasConcluidas.setForeground(Color.WHITE);
		btnTarefasConcluidas.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnTarefasConcluidas.setBackground(new Color(95, 158, 160));
		panelMenu.add(btnTarefasConcluidas, "1, 6");
		btnTarefasConcluidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTarefasConcluidas frameTarefasConcluidas = null;
				frameTarefasConcluidas = new TelaTarefasConcluidas();
				frameTarefasConcluidas.setVisible(true);
			} 
		});
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setHorizontalAlignment(SwingConstants.TRAILING);
		lblImagem.setVerticalAlignment(SwingConstants.TOP);
		lblImagem.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/fundo3.png")));
		panelInicial.add(lblImagem, "4, 3");
	}

}
