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
			String sql1 = "insert into gestaoeventos.pessoas (nomePessoa, sobrenomePessoa, idSalaPrimeiraEtapa, "
					+ "idSalaSegundaEtapa, idEspacoPrimeiraEtapa, idEspacoSegundaEtapa) values (?, ?, ?, ?, ?, ?)";
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
			String sql2 = "insert into gestaoeventos.salaevento (nomeSalaEvento, lotacaoSalaEvento) values (?, ?)";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql2);
			pstmt.setString(1, salaEventoModel.getNomeSalaEvento());
			pstmt.setInt(2, salaEventoModel.getLotacaoSalaEvento());
			pstmt.execute();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	
	// Insert para cadastrar espaço de café - Tela Cadastrar Espaço Café
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
	
	// Select para apresentar todas as pessoas cadastradas na tabela - Tela Consultar Pessoas
	public DefaultTableModel VisualizarPessoas() {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("Código");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Sala 1ª Etapa");
		dados.addColumn("ID Sala 2ª Etapa");
		dados.addColumn("ID Espaço Café 1ª Etapa");
		dados.addColumn("ID Espaço Café 2ª Etapa");
		try {
			String sql4 = "select * from gestaoeventos.pessoas";
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
	
	// Select buscar pelo nome da pessoa e apresentar seus dados na tabela - Tela Consultar Pessoas
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
	
	// Select para apresentar os espaços cadastrados e as pessoas a eles vinculados - Tela Consultar Espaço Café
	public DefaultTableModel VisualizarEspacos() {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espaço 1ª Etapa");
		dados.addColumn("ID Espaço 2ª Etapa");
		try {
			String sql7 = "select idPessoa, nomePessoa, sobrenomePessoa, idEspacoPrimeiraEtapa, idEspacoSegundaEtapa "
					+ "from gestaoeventos.pessoas";
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
	
	// Select buscar pela ID do espaço da PRIMEIRA ETAPA e apresentar seus dados na tabela - Tela Consultar Espaços
	public DefaultTableModel ConsultarEspacoPrimeiraID(int idPesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espaço Café");
		dados.addColumn("Nome Espaço Café");
		try {
			String sql8 = "select P.idPessoa, P.nomePessoa, P.sobrenomePessoa, E.idEspacoCafe, E.nomeEspacoCafe "
					+ "from gestaoeventos.pessoas as P "
					+ "inner join gestaoeventos.espacocafe as E on P.idEspacoPrimeiraEtapa = E.idEspacoCafe "
					+ "where E.idEspacoCafe = " + idPesquisa;
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

	// Select buscar pela ID do espaço da SEGUNDA ETAPA e apresentar seus dados na tabela - Tela Consultar Espaços
	public DefaultTableModel ConsultarEspacoSegundaID(int idPesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espaço Café");
		dados.addColumn("Nome Espaço Café");
		try {
			String sql9 = "select P.idPessoa, P.nomePessoa, P.sobrenomePessoa, E.idEspacoCafe, E.nomeEspacoCafe "
					+ "from gestaoeventos.pessoas as P "
					+ "inner join gestaoeventos.espacocafe as E on P.idEspacoSegundaEtapa = E.idEspacoCafe "
					+ "where E.idEspacoCafe = " + idPesquisa;
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
	
	// Select buscar pela nome do espaço da PRIMEIRA ETAPA e apresentar seus dados na tabela - Tela Consultar Espaços
	public DefaultTableModel ConsultarEspacoPrimeiraNome(String nomePesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espaço");
		dados.addColumn("Nome Espaço");
		try {
			String sql10 = "select P.idPessoa, P.nomePessoa, P.sobrenomePessoa, E.idEspacoCafe, E.nomeEspacoCafe "
					+ "from gestaoeventos.pessoas as P "
					+ "inner join gestaoeventos.espacocafe as E on P.idEspacoPrimeiraEtapa = E.idEspacoCafe "
					+ "where E.nomeEspacoCafe = '" + nomePesquisa + "'";
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
	
	// Select buscar pela nome do espaço da SEGUNDA ETAPA e apresentar seus dados na tabela - Tela Consultar Espaços
	public DefaultTableModel ConsultarEspacoSegundaNome(String nomePesquisa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("ID Pessoa");
		dados.addColumn("Nome");
		dados.addColumn("Sobrenome");
		dados.addColumn("ID Espaço");
		dados.addColumn("Nome Espaço");
		try {
			String sql11 = "select P.idPessoa, P.nomePessoa, P.sobrenomePessoa, E.idEspacoCafe, E.nomeEspacoCafe "
					+ "from gestaoeventos.pessoas as P "
					+ "inner join gestaoeventos.espacocafe as E on P.idEspacoSegundaEtapa = E.idEspacoCafe "
					+ "where E.nomeEspacoCafe = '" + nomePesquisa + "'";
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
		dados.addColumn("ID Sala 1ª Etapa");
		dados.addColumn("ID Sala 1ª Etapa");
		try {
			String sql12 = "select idPessoa, nomePessoa, sobrenomePessoa, idSalaPrimeiraEtapa, idSalaSegundaEtapa from gestaoeventos.pessoas";
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
		dados.addColumn("Lotação");
		try {
			String sq13 = "select P.idPessoa, P.nomePessoa, P.sobrenomePessoa, P.idSalaPrimeiraEtapa, S.nomeSalaEvento, S.lotacaoSalaEvento "
					+ "from gestaoeventos.pessoas as P "
					+ "inner join gestaoeventos.salaevento as S on P.idSalaPrimeiraEtapa = S.idSalaEvento "
					+  "where S.idSalaEvento = " + idPesquisa;
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
		dados.addColumn("Lotação");
		try {
			String sq14 = "select P.idPessoa, P.nomePessoa, P.sobrenomePessoa, P.idSalaSegundaEtapa, S.nomeSalaEvento, S.lotacaoSalaEvento "
					+ "from gestaoeventos.pessoas as P "
					+ "inner join gestaoeventos.salaevento as S on P.idSalaSegundaEtapa = S.idSalaEvento "
					+ "where S.idSalaEvento = " + idPesquisa;
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
		dados.addColumn("Lotação");
		try {
			String sql15 = "select P.idPessoa, P.nomePessoa, P.sobrenomePessoa, P.idSalaPrimeiraEtapa, S.nomeSalaEvento, S.lotacaoSalaEvento "
					+ "from gestaoeventos.pessoas as P "
					+ "inner join gestaoeventos.salaevento as S on P.idSalaPrimeiraEtapa = S.idSalaEvento "
					+ "where S.nomeSalaEvento = '" + nomePesquisa + "'";
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
		dados.addColumn("Lotação");
		try {
			String sql16 = "select P.idPessoa, P.nomePessoa, P.sobrenomePessoa, P.idSalaSegundairaEtapa, S.nomeSalaEvento, S.lotacaoSalaEvento "
					+ "from gestaoeventos.pessoas as P "
					+ "inner join gestaoeventos.salaevento as S on P.idSalaSegundairaEtapa = S.idSalaEvento "
					+ "where S.nomeSalaEvento = '" + nomePesquisa + "'";
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
	
	
	
}
