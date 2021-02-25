package controller;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.table.TableModel;

import model.EspacoCafeModel;
import model.GestaoEventosDAO;
import model.PessoaModel;
import model.SalaEventoModel;


public class GestaoEventosController {
		
	// M�todos para intera��o entre interface e Banco de Dados
	
	// M�todo para cadastrar pessoa
	public void CadastrarPessoa(String nomePessoa, String sobrenomePessoa, String idSalaPrimeiraEtapa, String idSalaSegundaEtapa, 
			String idEspacoPrimeiraEtapa, String idEspacoSegundaEtapa) throws SQLException, ParseException {
		PessoaModel pessoa = new PessoaModel();
		pessoa.setNomePessoa(nomePessoa);
		pessoa.setSobrenomePessoa(sobrenomePessoa);
		pessoa.setIdSalaPrimeiraEtapa(Integer.parseInt(idSalaPrimeiraEtapa));
		pessoa.setIdSalaSegundaEtapa(Integer.parseInt(idSalaSegundaEtapa));
		pessoa.setIdEspacoPrimeiraEtapa(Integer.parseInt(idEspacoPrimeiraEtapa));
		pessoa.setIdEspacoSegundaEtapa(Integer.parseInt(idEspacoSegundaEtapa));
		new GestaoEventosDAO().CadastrarPessoa(pessoa);	
	}
	
	// M�todo para cadastrar sala de evento
	public void CadastrarSalaEvento(String nomeSalaEvento, String lotacaoSalaEvento) throws SQLException, ParseException {
		SalaEventoModel salaEventoModel = new SalaEventoModel();
		salaEventoModel.setNomeSalaEvento(nomeSalaEvento);
		salaEventoModel.setLotacaoSalaEvento(Integer.parseInt(lotacaoSalaEvento));
		new GestaoEventosDAO().CadastrarSalaEvento(salaEventoModel);	
	}

	// M�todo para cadastrar espa�o de caf�
	public void CadastrarEspacoCafe(String nomeEspacoCafe) throws SQLException, ParseException {
		EspacoCafeModel espacoCafeModel = new EspacoCafeModel();
		espacoCafeModel.setNomeEspacoCafe(nomeEspacoCafe);
		new GestaoEventosDAO().CadastrarEspacoCafe(espacoCafeModel);	
	}
	
	// M�todo para visualizar a tabela de pessoas
	public TableModel VisualizarPessoas() throws SQLException, ParseException {
		return new GestaoEventosDAO().VisualizarPessoas();
		
	}
	
	// M�todo para consultar pessoas conforme par�metros de ID
	public TableModel ConsultarPessoasID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().ConsultarPessoasID(converteID);
		
	}
	
	// M�todo para consultar pessoas conforme par�metros de nome
	public TableModel ConsultarPessoasNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().ConsultarPessoasNome(nomePessoa);
		
	}
	
	// M�todo para visualizar a tabela de espa�os de caf�
	public TableModel VisualizarEspacos() throws SQLException, ParseException {
		return new GestaoEventosDAO().VisualizarEspacos();
		
	}
	
	// M�todo para consultar espa�os da PRIMEIRA ETAPA conforme par�metros de ID
	public TableModel ConsultarEspacoPrimeiraID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().ConsultarEspacoPrimeiraID(converteID);
	}
	
	// M�todo para consultar espa�os da SEGUNDA ETAPA conforme par�metros de ID
	public TableModel ConsultarEspacoSegundaID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().ConsultarEspacoSegundaID(converteID);			
	}
		
	// M�todo para consultar espa�os da PRIMEIRA ETAPA conforme par�metros de nome
	public TableModel ConsultarEspacoPrimeiraNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().ConsultarEspacoPrimeiraNome(nomePessoa);
	
	}
	
	// M�todo para consultar espa�os da SEGUNDA ETAPA conforme par�metros de nome
	public TableModel ConsultarEspacoSegundaNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().ConsultarEspacoSegundaNome(nomePessoa);
	
	}
	
	// M�todo para visualizar a tabela de salas de eventos
	public TableModel VisualizarSalas() throws SQLException, ParseException {
		return new GestaoEventosDAO().VisualizarSalas();
		
	}
	
	// M�todo para consultar salas da PRIMEIRA ETAPA conforme par�metros de ID
	public TableModel ConsultarSalaPrimeiraID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().ConsultarSalaPrimeiraID(converteID);
	}
	
	
	// M�todo para consultar salas da PRIMEIRA ETAPA conforme par�metros de nome
	public TableModel ConsultarSalaPrimeiraNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().ConsultarSalaPrimeiraNome(nomePessoa);
	}
	
	
	// M�todo para consultar salas da SEGUNDA ETAPA conforme par�metros de ID
	public TableModel ConsultarSalaSegundaID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().ConsultarSalaSegundaID(converteID);
	}
	
	
	// M�todo para consultar salas da SEGUNDA ETAPA conforme par�metros de nome
	public TableModel ConsultarSalaSegundaNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().ConsultarSalaSegundaNome(nomePessoa);
	}
	
	// M�todo para cria��o das tabelas no banco
	public void CriarTabelas() throws SQLException, ParseException {
		new GestaoEventosDAO().CriarTabelas();
	}
}
