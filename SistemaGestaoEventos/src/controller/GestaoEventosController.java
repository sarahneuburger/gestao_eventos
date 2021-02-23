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
	public void CadastrarPessoa(String nomePessoa, String sobrenomePessoa, String idSalaPrimeiraEtapa, String idSalaSegundaEtapa, 
			String idEspacoCafe) throws SQLException, ParseException {
		PessoaModel pessoa = new PessoaModel();
		pessoa.setNomePessoa(nomePessoa);
		pessoa.setSobrenomePessoa(sobrenomePessoa);
		pessoa.setIdSalaPrimeiraEtapa(Integer.parseInt(idSalaPrimeiraEtapa));
		pessoa.setIdSalaSegundaEtapa(Integer.parseInt(idSalaSegundaEtapa));
		pessoa.setIdEspacoCafe(Integer.parseInt(idEspacoCafe));
		new GestaoEventosDAO().CadastrarPessoa(pessoa);	
	}
	
	// Método para cadastrar sala de evento
	public void CadastrarSalaEvento(String nomeSalaEvento, String lotacaoSalaEvento) throws SQLException, ParseException {
		SalaEventoModel salaEventoModel = new SalaEventoModel();
		salaEventoModel.setNomeSalaEvento(nomeSalaEvento);
		salaEventoModel.setLotacaoSalaEvento(Integer.parseInt(lotacaoSalaEvento));
		new GestaoEventosDAO().CadastrarSalaEvento(salaEventoModel);	
	}

	// Método para cadastrar espaço de café
	public void CadastrarEspacoCafe(String nomeEspacoCafe) throws SQLException, ParseException {
		EspacoCafeModel espacoCafeModel = new EspacoCafeModel();
		espacoCafeModel.setNomeEspacoCafe(nomeEspacoCafe);
		new GestaoEventosDAO().CadastrarEspacoCafe(espacoCafeModel);	
	}
	
	// Método para visualizar a tabela de pessoas
	public TableModel VisualizarPessoas() throws SQLException, ParseException {
		return new GestaoEventosDAO().VisualizarPessoas();
		
	}
	
	// Método para consultar pessoas conforme parâmetros de ID
	public TableModel ConsultarPessoasID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().ConsultarPessoasID(converteID);
		
	}
	
	// Método para consultar pessoas conforme parâmetros de nome
	public TableModel ConsultarPessoasNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().ConsultarPessoasNome(nomePessoa);
		
	}
	
	// Método para visualizar a tabela de espaços de café
	public TableModel VisualizarEspacos() throws SQLException, ParseException {
		return new GestaoEventosDAO().VisualizarEspacos();
		
	}
	
	// Método para consultar espaços conforme parâmetros de ID
		public TableModel ConsultarEspacosID(String idPesquisa) throws SQLException, ParseException {
			int converteID = Integer.parseInt(idPesquisa);
			return new GestaoEventosDAO().ConsultarEspacoID(converteID);
			
	}
		
	// Método para consultar espaços conforme parâmetros de nome
	public TableModel ConsultarEspacosNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().ConsultarEspacoNome(nomePessoa);
	
	}
	
	
	// Método para visualizar a tabela de salas de eventos
	public TableModel VisualizarSalas() throws SQLException, ParseException {
		return new GestaoEventosDAO().VisualizarSalas();
		
	}
	
	// Método para consultar salas da PRIMEIRA ETAPA conforme parâmetros de ID
	public TableModel ConsultarSalaPrimeiraID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().ConsultarSalaPrimeiraID(converteID);
	}
	
	
	// Método para consultar salas da PRIMEIRA ETAPA conforme parâmetros de nome
	public TableModel ConsultarSalaPrimeiraNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().ConsultarSalaPrimeiraNome(nomePessoa);
	}
	
	
	// Método para consultar salas da SEGUNDA ETAPA conforme parâmetros de ID
	public TableModel ConsultarSalaSegundaID(String idPesquisa) throws SQLException, ParseException {
		int converteID = Integer.parseInt(idPesquisa);
		return new GestaoEventosDAO().ConsultarSalaSegundaID(converteID);
	}
	
	
	// Método para consultar salas da SEGUNDA ETAPA conforme parâmetros de nome
	public TableModel ConsultarSalaSegundaNome(String nomePessoa) throws SQLException, ParseException {
		return new GestaoEventosDAO().ConsultarSalaSegundaNome(nomePessoa);
	}
	
}
