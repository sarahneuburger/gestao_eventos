package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			String idEspacoCafe) throws SQLException, ParseException {
		PessoaModel pessoa = new PessoaModel();
		pessoa.setNomePessoa(nomePessoa);
		pessoa.setSobrenomePessoa(sobrenomePessoa);
		pessoa.setIdSalaPrimeiraEtapa(Integer.parseInt(idSalaPrimeiraEtapa));
		pessoa.setIdSalaSegundaEtapa(Integer.parseInt(idSalaSegundaEtapa));
		pessoa.setIdEspacoCafe(Integer.parseInt(idEspacoCafe));
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
	
}
