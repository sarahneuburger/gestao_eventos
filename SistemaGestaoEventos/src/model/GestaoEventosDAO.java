package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import connection.Conexao;

public class GestaoEventosDAO {

	private Conexao conexao = new Conexao();

	// Insert para cadastrar pessoa
	public void CadastrarPessoa(PessoaModel pessoaModel) {
		try {
			String sql1 = "insert into gestaoeventos.pessoas (nomePessoa, sobrenomePessoa, idSalaPrimeiraEtapa, "
					+ "idSalaSegundaEtapa, idEspacoCafe) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql1);
			pstmt.setString(1, pessoaModel.getNomePessoa());
			pstmt.setString(2, pessoaModel.getSobrenomePessoa());
			pstmt.setInt(3, pessoaModel.getIdSalaPrimeiraEtapa());
			pstmt.setInt(4, pessoaModel.getIdSalaSegundaEtapa());
			pstmt.setInt(5, pessoaModel.getIdEspacoCafe());
			pstmt.execute();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

	// Insert para cadastrar sala de evento
	public void CadastrarSalaEvento(SalaEventoModel salaEventoModel) {
		try {
			String sql2 = "insert into gestaoeventos.salaevento (nomeSalaEvento, lotacaoSalaEvento) values (?, ?)";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql2);
			pstmt.setString(1, salaEventoModel.getNomeSalaEvento());
			pstmt.setInt(2, salaEventoModel.getLotacaoSalaEvento());
			pstmt.execute();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	
	// Insert para cadastrar espaço de café
	public void CadastrarEspacoCafe(EspacoCafeModel espacoCafeModel) {
		try {
			String sql3 = "insert into gestaoeventos.espacocafe (nomeEspacoCafe) values (?)";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql3);
			pstmt.setString(1, espacoCafeModel.getNomeEspacoCafe());
			pstmt.execute();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	// Select para apresentar as pessoas cadastradas na tabela
	public DefaultTableModel VisualizarPessoas() {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("Código");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala 1ª Etapa");
		dados.addColumn("ID Sala 2ª Etapa");
		dados.addColumn("ID Espaço Café");
		try {
			String sql4 = "select * from gestaoeventos.pessoas";
			Statement stmt = conexao.conectar().createStatement();
			ResultSet rs = stmt.executeQuery(sql4);
			while(rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
						rs.getInt(5), rs.getInt(6)});
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		return dados;
	}
	
	public DefaultTableModel ConsultarPessoasID(int idPesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("Código");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala 1ª Etapa");
		dados.addColumn("ID Sala 2ª Etapa");
		dados.addColumn("ID Espaço Café");
		try {
			String sql5 = "SELECT * FROM gestaoeventos.pessoas WHERE idPessoa = " + idPesquisa;
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql5);
			ResultSet rs = pstmt.executeQuery(sql5);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6) });
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		return dados;
	}
	
	public DefaultTableModel ConsultarPessoasNome(String nomePesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("Código");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala 1ª Etapa");
		dados.addColumn("ID Sala 2ª Etapa");
		dados.addColumn("ID Espaço Café");
		try {
			String sql6 = "SELECT * FROM gestaoeventos.pessoas WHERE nomePessoa = '" + nomePesquisa + "'";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql6);
			ResultSet rs = pstmt.executeQuery(sql6);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6) });
			}
			rs.close();
			pstmt.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		return dados;
	}
}
