package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import connection.Conexao;
import controller.GestaoEventosController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TelaCadastrarPessoa extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCampoNome;
	private JTextField tfCampoSobrenome;
	private JTextField tfCampoPrimeiraSala;
	private JTextField tfCampoSegundaSala;
	private JTextField tfEspaco;


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
		setBounds(100, 100, 450, 345);
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
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),}));
		
		JLabel lblCadastrarPessoa = new JLabel("Cadastro de Pessoas");
		lblCadastrarPessoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		baseTelaCadastrarPessoa.add(lblCadastrarPessoa, "2, 2");
		
		JLabel lblNomePessoa = new JLabel("Nome:   ");
		lblNomePessoa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		baseTelaCadastrarPessoa.add(lblNomePessoa, "2, 4, right, default");
		
		tfCampoNome = new JTextField();
		baseTelaCadastrarPessoa.add(tfCampoNome, "3, 4, fill, default");
		tfCampoNome.setColumns(10);
		
		JLabel lblSobrenomePessoa = new JLabel("Sobrenome:   ");
		lblSobrenomePessoa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSobrenomePessoa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		baseTelaCadastrarPessoa.add(lblSobrenomePessoa, "2, 6, right, default");
		
		tfCampoSobrenome = new JTextField();
		tfCampoSobrenome.setColumns(10);
		baseTelaCadastrarPessoa.add(tfCampoSobrenome, "3, 6, fill, default");
		
		JLabel lblIdSalaPrimeiraEtapa = new JLabel("Sala Primeira Etapa:    ");
		lblIdSalaPrimeiraEtapa.setHorizontalAlignment(SwingConstants.RIGHT);
		baseTelaCadastrarPessoa.add(lblIdSalaPrimeiraEtapa, "2, 8, right, default");
		
		tfCampoPrimeiraSala = new JTextField();
		tfCampoPrimeiraSala.setColumns(10);
		baseTelaCadastrarPessoa.add(tfCampoPrimeiraSala, "3, 8, fill, default");
		
		JLabel lblIdSalaSegundaEtapa = new JLabel("Sala Segunda Etapa:    ");
		lblIdSalaSegundaEtapa.setHorizontalAlignment(SwingConstants.RIGHT);
		baseTelaCadastrarPessoa.add(lblIdSalaSegundaEtapa, "2, 10, right, default");
		
		tfCampoSegundaSala = new JTextField();
		tfCampoSegundaSala.setColumns(10);
		baseTelaCadastrarPessoa.add(tfCampoSegundaSala, "3, 10, fill, default");
		
		JLabel lblIdEspacoCafe = new JLabel("Espa\u00E7o de Caf\u00E9:    ");
		lblIdEspacoCafe.setHorizontalAlignment(SwingConstants.RIGHT);
		baseTelaCadastrarPessoa.add(lblIdEspacoCafe, "2, 12, right, default");
		
		tfEspaco = new JTextField();
		tfEspaco.setColumns(10);
		baseTelaCadastrarPessoa.add(tfEspaco, "3, 12, fill, default");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// ver forma de voltar para a tela principal sem fechar tudo
				TelaInicial frameInicial = new TelaInicial();
				frameInicial.setVisible(true);
			}
		});
		baseTelaCadastrarPessoa.add(btnVoltar, "3, 16");
		
		JButton btnCadastrarPessoa = new JButton("Cadastrar");
		btnCadastrarPessoa.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Método para cadastrar pessoa
			String nomePessoa = tfCampoNome.getText();
			String sobrenomePessoa = tfCampoSobrenome.getText();
			int idSalaPrimeiraEtapa = Integer.parseInt(tfCampoPrimeiraSala.getText());
			int idSalaSegundaEtapa = Integer.parseInt(tfCampoSegundaSala.getText());
			int idEspacoCafe = Integer.parseInt(tfEspaco.getText());
				try {
				Conexao conexao = new Conexao();
				String sql = "INSERT INTO gestaoeventos.pessoas (nomePessoa, sobrenomePessoa, idSalaPrimeiraEtapa, idSalaSegundaEtapa, idEspacoCafe) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement pstmt = conexao.conectar().prepareStatement(sql);
				pstmt.setString(1, nomePessoa);
				pstmt.setString(2, sobrenomePessoa);
				pstmt.setInt(3, idSalaPrimeiraEtapa);
				pstmt.setInt(4, idSalaSegundaEtapa);
				pstmt.setInt(5, idEspacoCafe);
				pstmt.execute();
				
				JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso.");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar pessoa.");
					System.out.println(erro.getMessage());
				}
			
		}
	});
		baseTelaCadastrarPessoa.add(btnCadastrarPessoa, "3, 14");
		
	}

}

