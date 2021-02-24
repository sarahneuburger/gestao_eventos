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

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class TelaConsultarPessoas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfIdPessoa;
	private JTextField tfNomePessoaPesquisar;
	private JTable tabelaPessoas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarPessoas frame = new TelaConsultarPessoas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaConsultarPessoas() throws SQLException, ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsultarPessoas.class.getResource("/img/imgTelaInicial3.png")));
		setTitle("Consultar Pessoas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel baseConsultarPessoas = new JPanel();
		contentPane.add(baseConsultarPessoas, BorderLayout.CENTER);
		baseConsultarPessoas.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10dlu"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("10dlu"),},
			new RowSpec[] {
				RowSpec.decode("10dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("10dlu"),}));
		
		JLabel lblConsultarPessoa = new JLabel("Consulta de Pessoas");
		lblConsultarPessoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		baseConsultarPessoas.add(lblConsultarPessoa, "2, 2");
		
		JPanel baseIdPessoa = new JPanel();
		baseConsultarPessoas.add(baseIdPessoa, "2, 4, fill, fill");
		baseIdPessoa.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(94dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblIdPessoa = new JLabel("C\u00F3digo:   ");
		lblIdPessoa.setHorizontalAlignment(SwingConstants.RIGHT);
		baseIdPessoa.add(lblIdPessoa, "1, 1, right, default");
		
		tfIdPessoa = new JTextField();
		baseIdPessoa.add(tfIdPessoa, "2, 1, fill, default");
		tfIdPessoa.setColumns(10);
		
		JPanel baseNomePessoa = new JPanel();
		baseConsultarPessoas.add(baseNomePessoa, "2, 6, fill, fill");
		baseNomePessoa.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(94dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNomePessoaPesquisa = new JLabel("Nome:   ");
		lblNomePessoaPesquisa.setHorizontalAlignment(SwingConstants.RIGHT);
		baseNomePessoa.add(lblNomePessoaPesquisa, "1, 1, right, default");
		
		tfNomePessoaPesquisar = new JTextField();
		baseNomePessoa.add(tfNomePessoaPesquisar, "2, 1, fill, default");
		tfNomePessoaPesquisar.setColumns(10);
		
		JPanel baseBotaoPesquisarPessoa = new JPanel();
		baseConsultarPessoas.add(baseBotaoPesquisarPessoa, "2, 8, fill, fill");
		baseBotaoPesquisarPessoa.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JScrollPane tabela = new JScrollPane();
		baseConsultarPessoas.add(tabela, "2, 10, fill, fill");
		
		JButton btnPesquisarPessoa = new JButton("Pesquisar");
		btnPesquisarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestaoEventosController controller = new GestaoEventosController();
				try {
					if(tfIdPessoa.getText().length() > 0 && tfNomePessoaPesquisar.getText().length() == 0) {
						tabelaPessoas.setModel(controller.ConsultarPessoasID(tfIdPessoa.getText()));
						tabela.setViewportView(tabelaPessoas);
					} else if (tfNomePessoaPesquisar.getText().length() > 1 && tfIdPessoa.getText().length() == 0) {
						tabelaPessoas.setModel(controller.ConsultarPessoasNome(tfNomePessoaPesquisar.getText()));
						tabela.setViewportView(tabelaPessoas);
					} else {
						JOptionPane.showMessageDialog(null, "Informe um parâmetro válido.");
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Falha ao consultar pessoa.");
					System.out.println(erro.getMessage());
				} catch (ParseException erro) {
					System.out.println(erro.getMessage());
				}

			}
		});
		baseBotaoPesquisarPessoa.add(btnPesquisarPessoa, "4, 1");
			
		tabelaPessoas = new JTable();
		GestaoEventosController controller = new GestaoEventosController();
		tabelaPessoas.setModel(controller.VisualizarPessoas());
		tabela.setViewportView(tabelaPessoas);
	}

}
