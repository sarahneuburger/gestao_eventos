package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.jgoodies.forms.layout.FormLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setTitle("Sistema de Gest\u00E3o de Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 367);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("20dlu"),
				ColumnSpec.decode("50dlu:grow"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblCadastros = new JLabel("Cadastros");
		lblCadastros.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastros.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCadastros, "2, 2");
		
		JButton btnCadPessoa = new JButton("Pessoas");
		btnCadPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarPessoa frameCadPessoa = new TelaCadastrarPessoa();
				frameCadPessoa.setVisible(true);
			}
		});
		panel.add(btnCadPessoa, "2, 3");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/imgTelaInicial3.png")));
		panel.add(lblNewLabel_1, "4, 2, 2, 9, fill, fill");
		
		JButton btnCadSalaEvento = new JButton("Sala de Eventos");
		btnCadSalaEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				TelaCadastrarSala frameCadSala = new TelaCadastrarSala();
				frameCadSala.setVisible(true);
			}
		});
		panel.add(btnCadSalaEvento, "2, 4");
		
		JButton btnCadEspacoCafe = new JButton("Espa\u00E7os Caf\u00E9");
		btnCadEspacoCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarEspaco frameCadEspaco = new TelaCadastrarEspaco();
				frameCadEspaco.setVisible(true);
			}
		});
		panel.add(btnCadEspacoCafe, "2, 5");
		
		JLabel lblNewLabel = new JLabel("Consultas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel, "2, 7");
		
		JButton btnConsultaPessoa = new JButton("Pessoas");
		btnConsultaPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultarPessoas frameConsPessoa = new TelaConsultarPessoas();
				frameConsPessoa.setVisible(true);
			}
		});
		panel.add(btnConsultaPessoa, "2, 8");
		
		JButton btnConsultaSalaEventos = new JButton("Sala de Eventos");
		btnConsultaSalaEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultarSalas frameConsSala = new TelaConsultarSalas();
				frameConsSala.setVisible(true);
			}
		});
		panel.add(btnConsultaSalaEventos, "2, 9");
		
		JButton btnConsultaEspacoCafe = new JButton("Espa\u00E7os Caf\u00E9");
		btnConsultaEspacoCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultarEspacos frameConsEspaco = new TelaConsultarEspacos();
				frameConsEspaco.setVisible(true);
			}
		});
		panel.add(btnConsultaEspacoCafe, "2, 10");
	}

}
