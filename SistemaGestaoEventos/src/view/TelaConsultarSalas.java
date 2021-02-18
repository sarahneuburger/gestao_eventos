package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class TelaConsultarSalas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField tfIdSala;
	private JTextField tfNomeSalaPesquisar;
	private JTable tabelaSalas;

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

	public TelaConsultarSalas() {
		setTitle("Consultar Salas de Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel baseConsultarSalas = new JPanel();
		contentPane.add(baseConsultarSalas, BorderLayout.CENTER);
		baseConsultarSalas.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormSpecs.DEFAULT_ROWSPEC,
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
		
		JPanel baseBotaoPesquisarSala = new JPanel();
		baseConsultarSalas.add(baseBotaoPesquisarSala, "2, 8, fill, fill");
		baseBotaoPesquisarSala.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnPesquisarSala = new JButton("Pesquisar");
		baseBotaoPesquisarSala.add(btnPesquisarSala, "4, 1");
		
		tabelaSalas = new JTable();
		tabelaSalas.setShowHorizontalLines(false);
		tabelaSalas.setCellSelectionEnabled(true);
		tabelaSalas.setColumnSelectionAllowed(true);
		tabelaSalas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Sobrenome"
			}
		));
		baseConsultarSalas.add(tabelaSalas, "2, 10, fill, fill");
	}

}
