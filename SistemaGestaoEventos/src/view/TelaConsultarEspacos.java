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

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class TelaConsultarEspacos extends JFrame {


	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField tfIdEspaco;
	private JTextField tfNomeEspacoPesquisar;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarEspacos frame = new TelaConsultarEspacos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaConsultarEspacos() {
		setTitle("Consultar Espa\u00E7os de Caf\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel baseConsultarEspacos = new JPanel();
		contentPane.add(baseConsultarEspacos, BorderLayout.CENTER);
		baseConsultarEspacos.setLayout(new FormLayout(new ColumnSpec[] {
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
		
		JLabel lblConsultarEspaco = new JLabel("Consulta de Espa\u00E7os de Caf\u00E9");
		lblConsultarEspaco.setFont(new Font("Tahoma", Font.BOLD, 13));
		baseConsultarEspacos.add(lblConsultarEspaco, "2, 2");
		
		JPanel baseIdEspaco = new JPanel();
		baseConsultarEspacos.add(baseIdEspaco, "2, 4, fill, fill");
		baseIdEspaco.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(94dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblIdEspaco = new JLabel("C\u00F3digo:   ");
		lblIdEspaco.setHorizontalAlignment(SwingConstants.RIGHT);
		baseIdEspaco.add(lblIdEspaco, "1, 1, right, default");
		
		tfIdEspaco = new JTextField();
		baseIdEspaco.add(tfIdEspaco, "2, 1, fill, default");
		tfIdEspaco.setColumns(10);
		
		JPanel baseNomeEspaco = new JPanel();
		baseConsultarEspacos.add(baseNomeEspaco, "2, 6, fill, fill");
		baseNomeEspaco.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(94dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNomeEspacoPesquisar = new JLabel("Nome:   ");
		lblNomeEspacoPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
		baseNomeEspaco.add(lblNomeEspacoPesquisar, "1, 1, right, default");
		
		tfNomeEspacoPesquisar = new JTextField();
		baseNomeEspaco.add(tfNomeEspacoPesquisar, "2, 1, fill, default");
		tfNomeEspacoPesquisar.setColumns(10);
		
		JPanel baseBotaoPesquisarEspaco = new JPanel();
		baseConsultarEspacos.add(baseBotaoPesquisarEspaco, "2, 8, fill, fill");
		baseBotaoPesquisarEspaco.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("23dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnPesquisarEspaco = new JButton("Pesquisar");
		baseBotaoPesquisarEspaco.add(btnPesquisarEspaco, "4, 1");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Sobrenome"
			}
		));
		table.setShowHorizontalLines(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		baseConsultarEspacos.add(table, "2, 10, fill, fill");
	}

}
