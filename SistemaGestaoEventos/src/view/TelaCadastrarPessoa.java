package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import controller.GestaoEventosController;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;

public class TelaCadastrarPessoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCampoNome;
	private JTextField tfCampoSobrenome;
	private JTextField tfCampoPrimeiraSala;
	private JTextField tfCampoSegundaSala;
	private JTextField tfEspacoPrimeiraEtapa;
	private JTextField tfEspacoSegundaEtapa;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastrarPessoa.class.getResource("/img/imgTelaInicial3.png")));
		setTitle("Cadastrar Pessoa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel baseTelaCadastrarPessoa = new JPanel();
		contentPane.add(baseTelaCadastrarPessoa, BorderLayout.CENTER);
		baseTelaCadastrarPessoa.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("15dlu"), FormSpecs.DEFAULT_COLSPEC,
						ColumnSpec.decode("default:grow"), ColumnSpec.decode("default:grow"), },
				new RowSpec[] { RowSpec.decode("10dlu"), FormSpecs.DEFAULT_ROWSPEC, RowSpec.decode("8dlu"),
						FormSpecs.DEFAULT_ROWSPEC, RowSpec.decode("8dlu"), FormSpecs.DEFAULT_ROWSPEC,
						RowSpec.decode("8dlu"), FormSpecs.DEFAULT_ROWSPEC, RowSpec.decode("8dlu"),
						FormSpecs.DEFAULT_ROWSPEC, RowSpec.decode("8dlu"), FormSpecs.DEFAULT_ROWSPEC,
						RowSpec.decode("8dlu"), FormSpecs.DEFAULT_ROWSPEC, RowSpec.decode("10dlu"),
						FormSpecs.DEFAULT_ROWSPEC, RowSpec.decode("10dlu"), }));

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

		JLabel lblSalaPrimeiraEtapa = new JLabel("Sala Evento 1\u00AA Etapa:   ");
		lblSalaPrimeiraEtapa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalaPrimeiraEtapa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		baseTelaCadastrarPessoa.add(lblSalaPrimeiraEtapa, "2, 8, right, default");

		tfCampoPrimeiraSala = new JTextField();
		tfCampoPrimeiraSala.setColumns(10);
		baseTelaCadastrarPessoa.add(tfCampoPrimeiraSala, "3, 8, fill, default");

		JLabel lblSalaSegundaEtapa = new JLabel("Sala Evento 2\u00AA Etapa:   ");
		lblSalaSegundaEtapa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalaSegundaEtapa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		baseTelaCadastrarPessoa.add(lblSalaSegundaEtapa, "2, 10, right, default");

		tfCampoSegundaSala = new JTextField();
		tfCampoSegundaSala.setColumns(10);
		baseTelaCadastrarPessoa.add(tfCampoSegundaSala, "3, 10, fill, default");

		JLabel lblEspacoPrimeiraEtapa = new JLabel("Espa\u00E7o Caf\u00E9 1\u00AA Etapa:   ");
		lblEspacoPrimeiraEtapa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEspacoPrimeiraEtapa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		baseTelaCadastrarPessoa.add(lblEspacoPrimeiraEtapa, "2, 12, right, default");

		tfEspacoPrimeiraEtapa = new JTextField();
		tfEspacoPrimeiraEtapa.setColumns(10);
		baseTelaCadastrarPessoa.add(tfEspacoPrimeiraEtapa, "3, 12, fill, default");

		// Botão "cadastrar" chama o método para insert no banco de dados
		JButton btnCadastrarPessoa = new JButton("Cadastrar");
		btnCadastrarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestaoEventosController controller = new GestaoEventosController();
				try {
					if ((tfCampoNome.getText() == null || tfCampoNome.getText().trim().isEmpty())
							|| (tfCampoSobrenome.getText() == null || tfCampoSobrenome.getText().trim().isEmpty())
							|| (tfCampoPrimeiraSala.getText() == null || tfCampoPrimeiraSala.getText().trim().isEmpty())
							|| (tfCampoSegundaSala.getText() == null || tfCampoSegundaSala.getText().trim().isEmpty())
							|| (tfEspacoPrimeiraEtapa.getText() == null
									|| tfEspacoPrimeiraEtapa.getText().trim().isEmpty())
							|| (tfEspacoPrimeiraEtapa.getText() == null
									|| tfEspacoPrimeiraEtapa.getText().trim().isEmpty())
							|| (tfEspacoSegundaEtapa.getText() == null
									|| tfEspacoSegundaEtapa.getText().trim().isEmpty())) {
						JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
					} else {
						controller.cadastrarPessoa(tfCampoNome.getText(), tfCampoSobrenome.getText(),
								tfCampoPrimeiraSala.getText(), tfCampoSegundaSala.getText(),
								tfEspacoPrimeiraEtapa.getText(), tfEspacoSegundaEtapa.getText());
						JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso.");
						tfCampoNome.setText("");
						tfCampoSobrenome.setText("");
						tfCampoPrimeiraSala.setText("");
						tfCampoSegundaSala.setText("");
						tfEspacoPrimeiraEtapa.setText("");
						tfEspacoSegundaEtapa.setText("");
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar pessoa.");
					System.out.println(erro.getMessage());
				} catch (ParseException erro) {
					System.out.println(erro.getMessage());
				}

			}
		});

		JLabel lblEspacoSegundaEtapa = new JLabel("Espa\u00E7o Caf\u00E9 2\u00AA Etapa:   ");
		lblEspacoSegundaEtapa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEspacoSegundaEtapa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		baseTelaCadastrarPessoa.add(lblEspacoSegundaEtapa, "2, 14, right, default");

		tfEspacoSegundaEtapa = new JTextField();
		tfEspacoSegundaEtapa.setColumns(10);
		baseTelaCadastrarPessoa.add(tfEspacoSegundaEtapa, "3, 14, fill, default");
		baseTelaCadastrarPessoa.add(btnCadastrarPessoa, "3, 16");

	}

}
