<<<<<<< HEAD
package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TelaCadastrarPessoa extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCampoNome;
	private JTextField tfCampoSobrenome;
	private JTextField tfSalaPrimeiraEtapa;
	private JTextField tfSalaSegundaEtapa;
	private JTextField tfEspacoCafe;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarPessoa frame = new TelaCadastrarPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastrarPessoa() {
		setTitle("Cadastrar Pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel baseTelaCadastrarPessoa = new JPanel();
		contentPane.add(baseTelaCadastrarPessoa, BorderLayout.CENTER);
		baseTelaCadastrarPessoa.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("15dlu"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("10dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCadastrarPessoa = new JLabel("Cadastro de Pessoas");
		lblCadastrarPessoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		baseTelaCadastrarPessoa.add(lblCadastrarPessoa, "2, 2");
		
		JLabel lblDadosPessoas = new JLabel("Dados pessoais");
		lblDadosPessoas.setFont(new Font("Tahoma", Font.BOLD, 12));
		baseTelaCadastrarPessoa.add(lblDadosPessoas, "2, 4");
		
		JLabel lblNomePessoa = new JLabel("Nome:   ");
		lblNomePessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		baseTelaCadastrarPessoa.add(lblNomePessoa, "2, 5, right, default");
		
		tfCampoNome = new JTextField();
		baseTelaCadastrarPessoa.add(tfCampoNome, "3, 5, fill, default");
		tfCampoNome.setColumns(10);
		
		JLabel lblSobrenomePessoa = new JLabel("Sobrenome:   ");
		lblSobrenomePessoa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSobrenomePessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		baseTelaCadastrarPessoa.add(lblSobrenomePessoa, "2, 6, right, default");
		
		tfCampoSobrenome = new JTextField();
		tfCampoSobrenome.setColumns(10);
		baseTelaCadastrarPessoa.add(tfCampoSobrenome, "3, 6, fill, default");
		
		JLabel lblDadosInternospor = new JLabel("Dados internos (por c\u00F3digo)");
		lblDadosInternospor.setFont(new Font("Tahoma", Font.BOLD, 12));
		baseTelaCadastrarPessoa.add(lblDadosInternospor, "2, 8");
		
		JLabel lblSalaPrimeiraEtapa = new JLabel("Sala primeira etapa:   ");
		lblSalaPrimeiraEtapa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalaPrimeiraEtapa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		baseTelaCadastrarPessoa.add(lblSalaPrimeiraEtapa, "2, 9, right, default");
		
		tfSalaPrimeiraEtapa = new JTextField();
		tfSalaPrimeiraEtapa.setColumns(10);
		baseTelaCadastrarPessoa.add(tfSalaPrimeiraEtapa, "3, 9, fill, default");
		
		JLabel lblSalaSegundaEtapa = new JLabel("Sala segunda etapa:   ");
		lblSalaSegundaEtapa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalaSegundaEtapa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		baseTelaCadastrarPessoa.add(lblSalaSegundaEtapa, "2, 10, right, default");
		
		tfSalaSegundaEtapa = new JTextField();
		tfSalaSegundaEtapa.setColumns(10);
		baseTelaCadastrarPessoa.add(tfSalaSegundaEtapa, "3, 10, fill, default");
		
		JLabel lblEspacoCafe = new JLabel("Espa\u00E7o Caf\u00E9:   ");
		lblEspacoCafe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEspacoCafe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		baseTelaCadastrarPessoa.add(lblEspacoCafe, "2, 11, right, default");
		
		tfEspacoCafe = new JTextField();
		tfEspacoCafe.setColumns(10);
		baseTelaCadastrarPessoa.add(tfEspacoCafe, "3, 11, fill, default");
		
		JButton btnCadastrarPessoa = new JButton("Cadastrar");
		baseTelaCadastrarPessoa.add(btnCadastrarPessoa, "3, 13");
	}

}
=======
package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TelaCadastrarPessoa extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCampoNome;
	private JTextField tfCampoSobrenome;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarPessoa frame = new TelaCadastrarPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastrarPessoa() {
		setTitle("Cadastrar Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel baseTelaCadastrarPessoa = new JPanel();
		contentPane.add(baseTelaCadastrarPessoa, BorderLayout.CENTER);
		baseTelaCadastrarPessoa.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("15dlu"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("10dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCadastrarPessoa = new JLabel("Cadastro de Pessoas");
		lblCadastrarPessoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		baseTelaCadastrarPessoa.add(lblCadastrarPessoa, "2, 2");
		
		JLabel lblNomePessoa = new JLabel("Nome:   ");
		lblNomePessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		baseTelaCadastrarPessoa.add(lblNomePessoa, "2, 4, right, default");
		
		tfCampoNome = new JTextField();
		baseTelaCadastrarPessoa.add(tfCampoNome, "3, 4, fill, default");
		tfCampoNome.setColumns(10);
		
		JLabel lblSobrenomePessoa = new JLabel("Sobrenome:   ");
		lblSobrenomePessoa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSobrenomePessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		baseTelaCadastrarPessoa.add(lblSobrenomePessoa, "2, 6, right, default");
		
		tfCampoSobrenome = new JTextField();
		tfCampoSobrenome.setColumns(10);
		baseTelaCadastrarPessoa.add(tfCampoSobrenome, "3, 6, fill, default");
		
		JButton btnCadastrarPessoa = new JButton("Cadastrar");
		baseTelaCadastrarPessoa.add(btnCadastrarPessoa, "3, 8");
	}

}
>>>>>>> 51895fd3468c1e415dac0dcdfad9f47959b0ea87
