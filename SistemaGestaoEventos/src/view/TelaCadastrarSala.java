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
import java.awt.Toolkit;

public class TelaCadastrarSala extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeSala;
	private JTextField tfLotacaoSala;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarSala frame = new TelaCadastrarSala();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastrarSala() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastrarSala.class.getResource("/img/imgTelaInicial3.png")));
		setTitle("Cadastrar Salas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel baseCadastrarSalas = new JPanel();
		contentPane.add(baseCadastrarSalas, BorderLayout.CENTER);
		baseCadastrarSalas.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10dlu"),
				ColumnSpec.decode("58dlu"),
				ColumnSpec.decode("140dlu"),
				ColumnSpec.decode("40dlu"),},
			new RowSpec[] {
				RowSpec.decode("10dlu"),
				RowSpec.decode("30dlu:grow"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("12dlu:grow"),}));
		
		JLabel lblCadastrarSalas = new JLabel("Cadastro de Salas de Eventos");
		lblCadastrarSalas.setFont(new Font("Tahoma", Font.BOLD, 14));
		baseCadastrarSalas.add(lblCadastrarSalas, "2, 2, 2, 1");
		
		JLabel lblNomeSala = new JLabel("Nome:   ");
		lblNomeSala.setHorizontalAlignment(SwingConstants.RIGHT);
		baseCadastrarSalas.add(lblNomeSala, "2, 4, right, default");
		
		tfNomeSala = new JTextField();
		baseCadastrarSalas.add(tfNomeSala, "3, 4, fill, center");
		tfNomeSala.setColumns(10);
		
		JLabel lblLotacaoSala = new JLabel("Lota\u00E7\u00E3o:   ");
		lblLotacaoSala.setHorizontalAlignment(SwingConstants.RIGHT);
		baseCadastrarSalas.add(lblLotacaoSala, "2, 6, right, default");
		
		tfLotacaoSala = new JTextField();
		tfLotacaoSala.setColumns(10);
		baseCadastrarSalas.add(tfLotacaoSala, "3, 6, fill, default");
		
		JButton btnCadastrarSala = new JButton("Cadastrar");
		btnCadastrarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestaoEventosController controller = new GestaoEventosController();
				try {
					if ((tfNomeSala.getText() == null || tfNomeSala.getText().trim().isEmpty())
						|| (tfLotacaoSala.getText() == null || tfLotacaoSala.getText().trim().isEmpty())) {
						JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
					} else {			
					controller.cadastrarSalaEvento(tfNomeSala.getText(), tfLotacaoSala.getText());
					JOptionPane.showMessageDialog(null, "Sala de evento cadastrada com sucesso.");
					tfNomeSala.setText("");
					tfLotacaoSala.setText("");
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar sala de evento.");
					System.out.println(erro.getMessage());

				} catch (ParseException erro) {
					System.out.println(erro.getMessage());
				}

			}
		});
		baseCadastrarSalas.add(btnCadastrarSala, "3, 8");
	}

}
