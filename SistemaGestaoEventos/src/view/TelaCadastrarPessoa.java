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

