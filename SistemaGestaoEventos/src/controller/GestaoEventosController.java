package controller;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.table.TableModel;

import model.EspacoCafeModel;
import model.GestaoEventosDAO;
import model.PessoaModel;
import model.SalaEventoModel;

public class GestaoEventosController {

	// Métodos para interação entre interface e Banco de Dados

	// Método para cadastrar pessoa
	public boolean cadastrarPessoa(String nomePessoa, String sobrenomePessoa, String idSalaPrimeiraEtapa,
			String idSalaSegundaEtapa, String idEspacoPrimeiraEtapa, String idEspacoSegundaEtapa)
			throws SQLException, ParseException {
		PessoaModel pessoa = new PessoaModel();
		pessoa.setNomePessoa(nomePessoa);
		pessoa.setSobrenomePessoa(sobrenomePessoa);
		pessoa.setIdSalaPrimeiraEtapa(Integer.parseInt(idSalaPrimeiraEtapa));
		pessoa.setIdSalaSegundaEtapa(Integer.parseInt(idSalaSegundaEtapa));
		pessoa.setIdEspacoPrimeiraEtapa(Integer.parseInt(idEspacoPrimeiraEtapa));
		pessoa.setIdEspacoSegundaEtapa(Integer.parseInt(idEspacoSegundaEtapa));
		new GestaoEventosDAO().cadastrarPessoa(pessoa);
		return false;
	}

	// Método para cadastrar sala de evento
	public void cadastrarSalaEvento(String nomeSalaEvento, String lotacaoSalaEvento)
			throws SQLException, ParseException {
		SalaEventoModel salaEventoModel = new SalaEventoModel();
		salaEventoModel.setNomeSalaEvento(nomeSalaEvento);
		salaEventoModel.setLotacaoSalaEvento(Integer.parseInt(lotacaoSalaEvento));
		new GestaoEventosDAO().cadastrarSalaEvento(salaEventoModel);
	}

	// Método para cadastrar espaço de café
	public void cadastrarEspacoCafe(String nomeEspacoCafe) throws SQLException, ParseException {
		EspacoCafeModel espacoCafeModel = new EspacoCafeModel();
		espacoCafeModel.setNomeEspacoCafe(nomeEspacoCafe);
		new GestaoEventosDAO().cadastrarEspacoCafe(espacoCafeModel);
	}

	// Método para visualizar todas pessoas em uma tabela
	public TableModel visualizarPessoas() throws SQLException, ParseException {
		return new GestaoEventosDAO().visualizarPessoas();

	}

	// Método para consultar pessoas conforme parâmetros de ID
	public TableModel consultarPessoasID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().consultarPessoasID(converteID);

	}

	// Método para consultar pessoas conforme parâmetros de nome
	public TableModel consultarPessoasNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().consultarPessoasNome(nomePessoa);

	}

	// Método para visualizar os espaços de café em uma tabela
	public TableModel visualizarEspacos() throws SQLException, ParseException {
		return new GestaoEventosDAO().visualizarEspacos();

	}

	// Método para consultar espaços da PRIMEIRA ETAPA conforme parâmetros de ID
	public TableModel consultarEspacoPrimeiraID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().consultarEspacoPrimeiraID(converteID);
	}

	// Método para consultar espaços da SEGUNDA ETAPA conforme parâmetros de ID
	public TableModel consultarEspacoSegundaID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().consultarEspacoSegundaID(converteID);
	}

	// Método para consultar espaços da PRIMEIRA ETAPA conforme parâmetros de nome
	public TableModel consultarEspacoPrimeiraNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().consultarEspacoPrimeiraNome(nomePessoa);

	}

	// Método para consultar espaços da SEGUNDA ETAPA conforme parâmetros de nome
	public TableModel consultarEspacoSegundaNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().consultarEspacoSegundaNome(nomePessoa);

	}

	// Método para visualizar aas salas de eventos em uma tabela
	public TableModel visualizarSalas() throws SQLException, ParseException {
		return new GestaoEventosDAO().visualizarSalas();

	}

	// Método para consultar salas da PRIMEIRA ETAPA conforme parâmetros de ID
	public TableModel consultarSalaPrimeiraID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().consultarSalaPrimeiraID(converteID);
	}

	// Método para consultar salas da SEGUNDA ETAPA conforme parâmetros de ID
	public TableModel consultarSalaSegundaID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().consultarSalaSegundaID(converteID);
	}
	
	// Método para consultar salas da PRIMEIRA ETAPA conforme parâmetros de nome
	public TableModel consultarSalaPrimeiraNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().consultarSalaPrimeiraNome(nomePessoa);
	}

	// Método para consultar salas da SEGUNDA ETAPA conforme parâmetros de nome
	public TableModel consultarSalaSegundaNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().consultarSalaSegundaNome(nomePessoa);
	}

	// Método para criação das tabelas no banco
	public void criarTabelas() throws SQLException, ParseException {
		new GestaoEventosDAO().criarTabelas();
	}
}
