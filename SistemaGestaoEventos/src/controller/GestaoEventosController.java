package controller;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import connection.Conexao;
import model.EspacoCafeModel;
import model.PessoaModel;
import model.SalaEventoModel;
import view.TelaCadastrarEspaco;
import view.TelaCadastrarPessoa;
import view.TelaCadastrarSala;
import view.TelaConsultarEspacos;
import view.TelaConsultarPessoas;
import view.TelaConsultarSalas;

public class GestaoEventosController {
	
	private PessoaModel pessoaModel = new PessoaModel();
	private SalaEventoModel salaModel;
	private EspacoCafeModel espacoModel;
	private TelaCadastrarPessoa cadPessoaView = new TelaCadastrarPessoa();
	private TelaCadastrarSala cadSalaView;
	private TelaCadastrarEspaco cadEspacoView;
	private TelaConsultarPessoas consultPessoaView;
	private TelaConsultarSalas consultSalaView;
	private TelaConsultarEspacos consultEspacoView;
	
	// Métodos
	
//	// Método para cadastrar pessoa
//	public void CadastrarPessoa() {
//		
//		pessoaModel.setNomePessoa(cadPessoaView.tfCampoNome.getText());
//		pessoaModel.setSobrenomePessoa(cadPessoaView.tfCampoSobrenome.getText());
//		pessoaModel.setIdSalaPrimeiraEtapa(Integer.parseInt(cadPessoaView.tfCampoPrimeiraSala.getText()));
//		pessoaModel.setIdSalaSegundaEtapa(Integer.parseInt(cadPessoaView.tfCampoSegundaSala.getText()));
//		pessoaModel.setIdEspacoCafe(Integer.parseInt(cadPessoaView.tfEspaco.getText()));
//			try {
//			Conexao conexao = new Conexao();
//			String sql = "INSERT INTO gestaoeventos.pessoas (nomePessoa, sobrenomePessoa, idSalaPrimeiraEtapa, idSalaSegundaEtapa, idEspacoCafe) VALUES (?, ?, ?, ?, ?)";
//			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql);
//			pstmt.setString(1, pessoaModel.getNomePessoa());
//			pstmt.setString(2, pessoaModel.getSobrenomePessoa());
//			pstmt.setInt(3, pessoaModel.getIdSalaPrimeiraEtapa());
//			pstmt.setInt(4, pessoaModel.getIdSalaSegundaEtapa());
//			pstmt.setInt(5, pessoaModel.getIdEspacoCafe());
//			pstmt.execute();
//			
//			JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso.");
//			} catch (Exception erro) {
//				JOptionPane.showMessageDialog(null, "Falha ao cadastrar pessoa.");
//				System.out.println(erro.getMessage());
//			}
//			
//		}
	}

