package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import connection.Conexao;

public class GestaoEventosDAO {

	private Conexao conexao = new Conexao();

	// Insert para cadastrar pessoa  Tela Cadastrar Pessoa
	public void CadastrarPessoa(PessoaModel pessoaModel) {
		try {
			String sql1 = "INSERT INTO gestaoeventos.pessoas (nomePessoa, sobrenomePessoa, idSalaPrimeiraEtapa, "
					+ "idSalaSegundaEtapa, idEspacoPrimeiraEtapa, idEspacoSegundaEtapa) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql1);
			pstmt.setString(1, pessoaModel.getNomePessoa());
			pstmt.setString(2, pessoaModel.getSobrenomePessoa());
			pstmt.setInt(3, pessoaModel.getIdSalaPrimeiraEtapa());
			pstmt.setInt(4, pessoaModel.getIdSalaSegundaEtapa());
			pstmt.setInt(5, pessoaModel.getIdEspacoPrimeiraEtapa());
			pstmt.setInt(6, pessoaModel.getIdEspacoSegundaEtapa());
			pstmt.execute();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

	// Insert para cadastrar sala de evento - Tela Cadastrar Sala Evento
	public void CadastrarSalaEvento(SalaEventoModel salaEventoModel) {
		try {
			String sql2 = "INSERT INTO gestaoeventos.salaevento (nomeSalaEvento, lotacaoSalaEvento) VALUES (?, ?)";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql2);
			pstmt.setString(1, salaEventoModel.getNomeSalaEvento());
			pstmt.setInt(2, salaEventoModel.getLotacaoSalaEvento());
			pstmt.execute();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	
	// Insert para cadastrar espa�o de caf� - Tela Cadastrar Espa�o Caf�
	public void CadastrarEspacoCafe(EspacoCafeModel espacoCafeModel) {
		try {
			String sql3 = "INSERT INTO gestaoeventos.espacocafe (nomeEspacoCafe) VALUES (?)";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql3);
			pstmt.setString(1, espacoCafeModel.getNomeEspacoCafe());
			pstmt.execute();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	// Select para apresentar todas as pessoas cadastradas na tabela - Tela Consultar Pessoas
	public DefaultTableModel VisualizarPessoas() {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("C�digo");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala 1� Etapa");
		dados.addColumn("ID Sala 2� Etapa");
		dados.addColumn("ID Espa�o Caf� 1� Etapa");
		dados.addColumn("ID Espa�o Caf� 2� Etapa");
		try {
			String sql4 = "SELECT * FROM gestaoeventos.pessoas";
			Statement stmt = conexao.conectar().createStatement();
			ResultSet rs = stmt.executeQuery(sql4);
			while(rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
						rs.getInt(5), rs.getInt(6), rs.getInt(7)});
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		return dados;
	}
	
	// Select buscar pela ID da pessoa e apresentar seus dados na tabela - Tela Consultar Pessoas
	public DefaultTableModel ConsultarPessoasID(int idPesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("C�digo");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala 1� Etapa");
		dados.addColumn("ID Sala 2� Etapa");
		dados.addColumn("ID Espa�o Caf�");
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
	
	// Select buscar pelo nome da pessoa e apresentar seus dados na tabela - Tela Consultar Pessoas
	public DefaultTableModel ConsultarPessoasNome(String nomePesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("C�digo");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala 1� Etapa");
		dados.addColumn("ID Sala 2� Etapa");
		dados.addColumn("ID Espa�o Caf�");
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
	
	// Select para apresentar os espa�os cadastrados e as pessoas a eles vinculados - Tela Consultar Espa�o Caf�
	public DefaultTableModel VisualizarEspacos() {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espa�o 1� Etapa");
		dados.addColumn("ID Espa�o 2� Etapa");
		try {
			String sql7 = "SELECT idPessoa, nomePessoa, sobrenomePessoa, idEspacoPrimeiraEtapa, idEspacoSegundaEtapa "
					+ "FROM gestaoeventos.pessoas";
			Statement stmt = conexao.conectar().createStatement();
			ResultSet rs = stmt.executeQuery(sql7);
			while(rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
						rs.getString(5)});
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		return dados;
	}
	
	// Select buscar pela ID do espa�o da PRIMEIRA ETAPA e apresentar seus dados na tabela - Tela Consultar Espa�os
	public DefaultTableModel ConsultarEspacoPrimeiraID(int idPesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espa�o Caf�");
		dados.addColumn("Nome Espa�o Caf�");
		try {
			String sql8 = "SELECT P.idPessoa, P.nomePessoa, P.sobrenomePessoa, E.idEspacoCafe, E.nomeEspacoCafe "
					+ "FROM gestaoeventos.pessoas AS P "
					+ "INNER JOIN gestaoeventos.espacocafe AS E ON P.idEspacoPrimeiraEtapa = E.idEspacoCafe "
					+ "WHERE E.idEspacoCafe = " + idPesquisa;
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql8);
			ResultSet rs = pstmt.executeQuery(sql8);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)});
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		return dados;
	}

	// Select buscar pela ID do espa�o da SEGUNDA ETAPA e apresentar seus dados na tabela - Tela Consultar Espa�os
	public DefaultTableModel ConsultarEspacoSegundaID(int idPesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espa�o Caf�");
		dados.addColumn("Nome Espa�o Caf�");
		try {
			String sql9 = "SELECT P.idPessoa, P.nomePessoa, P.sobrenomePessoa, E.idEspacoCafe, E.nomeEspacoCafe "
					+ "FROM gestaoeventos.pessoas AS P "
					+ "INNER join gestaoeventos.espacocafe AS E ON P.idEspacoSegundaEtapa = E.idEspacoCafe "
					+ "WHERE E.idEspacoCafe = " + idPesquisa;
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql9);
			ResultSet rs = pstmt.executeQuery(sql9);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)});
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		return dados;
	}
	
	// Select buscar pela nome do espa�o da PRIMEIRA ETAPA e apresentar seus dados na tabela - Tela Consultar Espa�os
	public DefaultTableModel ConsultarEspacoPrimeiraNome(String nomePesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espa�o");
		dados.addColumn("Nome Espa�o");
		try {
			String sql10 = "SELECT P.idPessoa, P.nomePessoa, P.sobrenomePessoa, E.idEspacoCafe, E.nomeEspacoCafe "
					+ "FROM gestaoeventos.pessoas AS P "
					+ "INNER JOIN gestaoeventos.espacocafe AS E ON P.idEspacoPrimeiraEtapa = E.idEspacoCafe "
					+ "WHERE E.nomeEspacoCafe = '" + nomePesquisa + "'";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql10);
			ResultSet rs = pstmt.executeQuery(sql10);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)});
			}
			rs.close();
			pstmt.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		return dados;
	}
	
	// Select buscar pela nome do espa�o da SEGUNDA ETAPA e apresentar seus dados na tabela - Tela Consultar Espa�os
	public DefaultTableModel ConsultarEspacoSegundaNome(String nomePesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espa�o");
		dados.addColumn("Nome Espa�o");
		try {
			String sql11 = "SELECT P.idPessoa, P.nomePessoa, P.sobrenomePessoa, E.idEspacoCafe, E.nomeEspacoCafe "
					+ "FROM gestaoeventos.pessoas AS P "
					+ "INNER JOIN gestaoeventos.espacocafe AS E ON P.idEspacoSegundaEtapa = E.idEspacoCafe "
					+ "WHERE E.nomeEspacoCafe = '" + nomePesquisa + "'";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql11);
			ResultSet rs = pstmt.executeQuery(sql11);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)});
			}
			rs.close();
			pstmt.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		return dados;
	}
	
	// Select para apresentar as salas cadastradas e as pessoas a elas vinculadas - Tela Consultar Salas de Eventos
	public DefaultTableModel VisualizarSalas() {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala 1� Etapa");
		dados.addColumn("ID Sala 1� Etapa");
		try {
			String sql12 = "SELECT idPessoa, nomePessoa, sobrenomePessoa, idSalaPrimeiraEtapa, idSalaSegundaEtapa FROM gestaoeventos.pessoas";
			Statement stmt = conexao.conectar().createStatement();
			ResultSet rs = stmt.executeQuery(sql12);
			while(rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)});
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		return dados;
	}
	
	// Select buscar pela ID da sala primeira etapa e apresentar seus dados na tabela - Tela Consultar Salas
	public DefaultTableModel ConsultarSalaPrimeiraID(int idPesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala");
		dados.addColumn("Nome Sala");
		dados.addColumn("Lota��o");
		try {
			String sq13 = "SELECT P.idPessoa, P.nomePessoa, P.sobrenomePessoa, P.idSalaPrimeiraEtapa, S.nomeSalaEvento, S.lotacaoSalaEvento "
					+ "FROM gestaoeventos.pessoas AS P "
					+ "INNER JOIN gestaoeventos.salaevento AS S ON P.idSalaPrimeiraEtapa = S.idSalaEvento "
					+  "WHERE S.idSalaEvento = " + idPesquisa;
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sq13);
			ResultSet rs = pstmt.executeQuery(sq13);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6)});
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		return dados;
	}
	
	// Select buscar pela ID da sala segunda etapa e apresentar seus dados na tabela - Tela Consultar Salas
	public DefaultTableModel ConsultarSalaSegundaID(int idPesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala");
		dados.addColumn("Nome Sala");
		dados.addColumn("Lota��o");
		try {
			String sq14 = "SELECT P.idPessoa, P.nomePessoa, P.sobrenomePessoa, P.idSalaSegundaEtapa, S.nomeSalaEvento, S.lotacaoSalaEvento "
					+ "FROM gestaoeventos.pessoas AS P "
					+ "INNER JOIN gestaoeventos.salaevento AS S ON P.idSalaSegundaEtapa = S.idSalaEvento "
					+ "WHERE S.idSalaEvento = " + idPesquisa;
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sq14);
			ResultSet rs = pstmt.executeQuery(sq14);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6)});
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		return dados;
	}
	
	
	// Select buscar pela nome da sala e apresentar seus dados na tabela - Tela Consultar Salas
	public DefaultTableModel ConsultarSalaPrimeiraNome(String nomePesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala");
		dados.addColumn("Nome Sala");
		dados.addColumn("Lota��o");
		try {
			String sql15 = "SELECT P.idPessoa, P.nomePessoa, P.sobrenomePessoa, P.idSalaPrimeiraEtapa, S.nomeSalaEvento, S.lotacaoSalaEvento "
					+ "FROM gestaoeventos.pessoas AS P "
					+ "INNER JOIN gestaoeventos.salaevento AS S ON P.idSalaPrimeiraEtapa = S.idSalaEvento "
					+ "WHERE S.nomeSalaEvento = '" + nomePesquisa + "'";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql15);
			ResultSet rs = pstmt.executeQuery(sql15);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6)});
			}
			rs.close();
			pstmt.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		return dados;
	}
	
	// Select buscar pela nome da sala e apresentar seus dados na tabela - Tela Consultar Salas
	public DefaultTableModel ConsultarSalaSegundaNome(String nomePesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala");
		dados.addColumn("Nome Sala");
		dados.addColumn("Lota��o");
		try {
			String sql16 = "SELECT P.idPessoa, P.nomePessoa, P.sobrenomePessoa, P.idSalaSegundairaEtapa, S.nomeSalaEvento, S.lotacaoSalaEvento "
					+ "FROM gestaoeventos.pessoas AS P "
					+ "INNER JOIN gestaoeventos.salaevento AS S on P.idSalaSegundairaEtapa = S.idSalaEvento "
					+ "WHERE S.nomeSalaEvento = '" + nomePesquisa + "'";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql16);
			ResultSet rs = pstmt.executeQuery(sql16);
			while (rs.next()) {
				dados.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6)});
			}
			rs.close();
			pstmt.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		return dados;
	}
	
	// Cria��o das tabelas no banco de dados
	public void CriarTabelas() {
		try {
			//String createSchema = "CREATE SCHEMA IF NOT EXISTS gestaoeventos";
			//String useSchema = "USE DATABASE gestaoeventos";
			String tablePessoas = "CREATE TABLE IF NOT EXISTS  gestaoeventos.pessoas (idPessoa INT NOT NULL AUTO_INCREMENT, "
					+ "nomePessoa VARCHAR(45) NULL, sobrenomePessoa VARCHAR(45) NULL, IdSalaPrimeiraEtapa INT NULL, "
					+ "idSalaSegundaEtapa INT NULL, idEspacoPrimeiraEtapa INT NULL, idEspacoSegundaEtapa INT NULL, "
					+ "PRIMARY KEY (idPessoa))";
		
			String tableSalaEvento = "CREATE TABLE IF NOT EXISTS  gestaoeventos.salaevento (idSalaEvento INT NOT NULL AUTO_INCREMENT, "
					+ "nomeSalaEvento VARCHAR(45) NULL, lotacaoSalaEvento INT NULL, "
					+ "PRIMARY KEY (idSalaEvento))";
		
			String tableEspacoCafe = "CREATE TABLE IF NOT EXISTS  gestaoeventos.espacocafe (idEspacoCafe INT NOT NULL AUTO_INCREMENT, "
					+ "nomeEspacoCafe VARCHAR(45) NULL, PRIMARY KEY (idEspacoCafe))";
		
			PreparedStatement pstmt = conexao.conectar().prepareStatement(tablePessoas);
			//pstmt.addBatch(useSchema);			
			//pstmt.addBatch(tablePessoas);			
			pstmt.addBatch(tableSalaEvento);
			pstmt.addBatch(tableEspacoCafe);
			pstmt.execute();
			pstmt.executeBatch();
			pstmt.clearBatch();
			pstmt.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
}
