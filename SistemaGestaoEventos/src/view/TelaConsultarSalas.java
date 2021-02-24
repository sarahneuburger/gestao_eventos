package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
	import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.GestaoEventosController;

import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class TelaConsultarSalas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField tfIdSala;
	private JTextField tfNomeSalaPesquisar;
	private JTable tabelaSalas;
	private JTextField tfEtapaSala;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarSalas frame = new TelaConsultarSalas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaConsultarSalas() throws SQLException, ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsultarSalas.class.getResource("/img/imgTelaInicial3.png")));
		setTitle("Consultar Salas de Eventos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel baseConsultarSalas = new JPanel();
		contentPane.add(baseConsultarSalas, BorderLayout.CENTER);
		baseConsultarSalas.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10dlu"),
				ColumnSpec.decode("max(124dlu;default):grow"),
				ColumnSpec.decode("10dlu:grow"),},
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
				RowSpec.decode("default:grow"),
				RowSpec.decode("8dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("10dlu"),}));
		
		JLabel lblConsultarSala = new JLabel("Consulta de Salas de Eventos");
		lblConsultarSala.setFont(new Font("Tahoma", Font.BOLD, 13));
		baseConsultarSalas.add(lblConsultarSala, "2, 2");
		
		JPanel baseIdSala = new JPanel();
		baseConsultarSalas.add(baseIdSala, "2, 4, fill, fill");
		baseIdSala.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(94dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblIdSala = new JLabel("C\u00F3digo:   ");
		lblIdSala.setHorizontalAlignment(SwingConstants.RIGHT);
		baseIdSala.add(lblIdSala, "1, 1, right, default");
		
		tfIdSala = new JTextField();
		baseIdSala.add(tfIdSala, "2, 1, fill, default");
		tfIdSala.setColumns(10);
		
		JPanel baseNomeSala = new JPanel();
		baseConsultarSalas.add(baseNomeSala, "2, 6, fill, fill");
		baseNomeSala.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(94dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNomeSalaPesquisar = new JLabel("Nome:   ");
		lblNomeSalaPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
		baseNomeSala.add(lblNomeSalaPesquisar, "1, 1, right, default");
		
		tfNomeSalaPesquisar = new JTextField();
		baseNomeSala.add(tfNomeSalaPesquisar, "2, 1, fill, default");
		tfNomeSalaPesquisar.setColumns(10);
		
		JPanel baseEtapa = new JPanel();
		baseConsultarSalas.add(baseEtapa, "2, 8, fill, fill");
		baseEtapa.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(82dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblEtapa = new JLabel("Etapa (sendo 1 ou 2)*:    ");
		lblEtapa.setHorizontalAlignment(SwingConstants.RIGHT);
		baseEtapa.add(lblEtapa, "2, 1");
		
		tfEtapaSala = new JTextField();
		tfEtapaSala.setColumns(10);
		baseEtapa.add(tfEtapaSala, "3, 1, fill, default");
		
		JPanel panelBtnPesquisar = new JPanel();
		baseConsultarSalas.add(panelBtnPesquisar, "2, 10, fill, fill");
		panelBtnPesquisar.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("10dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JScrollPane tabela = new JScrollPane();
		baseConsultarSalas.add(tabela, "2, 12, fill, fill");
		
		JButton btnPesquisarSala = new JButton("Pesquisar");
		btnPesquisarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestaoEventosController controller = new GestaoEventosController();
				try {	
					if (Integer.parseInt(tfEtapaSala.getText()) == 1) {
						if (tfIdSala.getText().length() > 0 && tfNomeSalaPesquisar.getText().length() == 0) {
							tabelaSalas.setModel(controller.ConsultarSalaPrimeiraID(tfIdSala.getText()));
							tabela.setViewportView(tabelaSalas);
						} else if (tfNomeSalaPesquisar.getText().length() > 1 && tfIdSala.getText().length() == 0) {
							tabelaSalas.setModel(controller.ConsultarSalaPrimeiraNome(tfNomeSalaPesquisar.getText()));
							tabela.setViewportView(tabelaSalas);
						} else {
							JOptionPane.showMessageDialog(null, "Informe um parâmetro válido.");
						}	
					} else if(Integer.parseInt(tfEtapaSala.getText()) == 2) {
						if (tfIdSala.getText().length() > 0 && tfNomeSalaPesquisar.getText().length() == 0) {
							tabelaSalas.setModel(controller.ConsultarSalaSegundaID(tfIdSala.getText()));
							tabela.setViewportView(tabelaSalas);
						} else if (tfNomeSalaPesquisar.getText().length() > 1 && tfIdSala.getText().length() == 0) {
							tabelaSalas.setModel(controller.ConsultarSalaSegundaNome(tfNomeSalaPesquisar.getText()));
							tabela.setViewportView(tabelaSalas);
						} else {
							JOptionPane.showMessageDialog(null, "Informe um parâmetro válido.");
						}
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Falha ao consultar sala.");
					System.out.println(erro.getMessage());
				} catch (ParseException erro) {
					System.out.println(erro.getMessage());
				}
			}
		});
		panelBtnPesquisar.add(btnPesquisarSala, "3, 1");
		
		tabelaSalas = new JTable();
		GestaoEventosController controller = new GestaoEventosController();
		tabelaSalas.setModel(controller.VisualizarSalas());
		tabela.setViewportView(tabelaSalas);
	}

}
