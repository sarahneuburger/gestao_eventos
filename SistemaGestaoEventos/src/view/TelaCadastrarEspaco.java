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
import java.awt.Toolkit;

public class TelaCadastrarEspaco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeEspaco;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarEspaco frame = new TelaCadastrarEspaco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastrarEspaco() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastrarEspaco.class.getResource("/img/imgTelaInicial3.png")));
		setTitle("Cadastrar Espa\u00E7os de Caf\u00E9");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel baseCadastrarEspaco = new JPanel();
		contentPane.add(baseCadastrarEspaco, BorderLayout.CENTER);
		baseCadastrarEspaco.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10dlu"),
				ColumnSpec.decode("70dlu"),
				ColumnSpec.decode("150dlu"),
				ColumnSpec.decode("30dlu"),},
			new RowSpec[] {
				RowSpec.decode("15dlu"),
				RowSpec.decode("30dlu"),
				RowSpec.decode("12dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("12dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("12dlu"),}));
		
		JLabel lblCadastrarEspaco = new JLabel("Cadastrar Espa\u00E7os de Caf\u00E9");
		lblCadastrarEspaco.setFont(new Font("Tahoma", Font.BOLD, 14));
		baseCadastrarEspaco.add(lblCadastrarEspaco, "2, 2, 2, 1");
		
		JLabel lblNomeEspaco = new JLabel("Nome:   ");
		lblNomeEspaco.setHorizontalAlignment(SwingConstants.RIGHT);
		baseCadastrarEspaco.add(lblNomeEspaco, "2, 4, right, default");
		
		tfNomeEspaco = new JTextField();
		baseCadastrarEspaco.add(tfNomeEspaco, "3, 4, fill, default");
		tfNomeEspaco.setColumns(10);
		
		JButton btnCadastrarEspaco = new JButton("Cadastrar");
		btnCadastrarEspaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestaoEventosController controller = new GestaoEventosController();
				try {
					if (tfNomeEspaco.getText() == null || tfNomeEspaco.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
					} else {
					controller.cadastrarEspacoCafe(tfNomeEspaco.getText());
					JOptionPane.showMessageDialog(null, "Espaço de café cadastrada com sucesso.");
					tfNomeEspaco.setText("");
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar espaço de café.");
					System.out.println(erro.getMessage());
				} catch (ParseException erro) {
					System.out.println(erro.getMessage());
				}

			}
		});
		baseCadastrarEspaco.add(btnCadastrarEspaco, "3, 6");
	}

}
