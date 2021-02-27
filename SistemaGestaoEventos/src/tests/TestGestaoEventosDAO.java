package tests;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;
import static org.junit.Assert.*;

import model.EspacoCafeModel;
import model.GestaoEventosDAO;
import model.PessoaModel;
import model.SalaEventoModel;

public class TestGestaoEventosDAO {

	GestaoEventosDAO testDAO = new GestaoEventosDAO();

	// --- Testes cadastros ---
	
	// Teste do m�todo para cadastrar pessoa no banco de dados
	@Test
	public void testCadastrarPessoa() throws SQLException, ParseException {
		PessoaModel pessoa = new PessoaModel("Sarah", "Brito", 1, 1, 1, 1);
		if(testDAO.cadastrarPessoa(pessoa)) {
			System.out.println("testCadastrarPessoa() realizado com sucesso");
		} else {
			fail("Erro ao testar testCadastrarPessoa().");
		}
	}
	
	// Teste do m�todo para cadastrar sala de evento no banco de dados
	@Test
	public void testCadastrarSalaEvento() throws SQLException, ParseException {
		SalaEventoModel salaEvento = new SalaEventoModel("Sala A", 10);
		if(testDAO.cadastrarSalaEvento(salaEvento)) {
			System.out.println("testCadastrarSalaEvento() realizado com sucesso");
		} else {
			fail("Erro ao testar testCadastrarSalaEvento().");
		}	
	}
	
	// Teste do m�todo cadastrar espa�o de caf� no banco de dados
	@Test
	public void testCadastrarEspacoCafe() throws SQLException, ParseException {
		EspacoCafeModel salaCafe = new EspacoCafeModel("Break Time");
		if(testDAO.cadastrarEspacoCafe(salaCafe)) {
			System.out.println("testCadastrarEspacoCafe() realizado com sucesso");
		} else {
			fail("Erro ao testar testCadastrarEspacoCafe().");
		}	
	}
	
	//Testes visualizar/consultar pessoas
	
	// Teste do m�todo para visualizar pessoas na tela de consulta (select no banco de dados)
	@Test
	public void testVisualizarPessoas() throws SQLException, ParseException {
		if(testDAO.visualizarPessoas() != null) {
			System.out.println("testVisualizarPessoas() realizado com sucesso. Resultado ID: " 
					+ testDAO.visualizarPessoas());
		} else {
			fail("Erro ao testar testVisualizarPessoas().");
		}	
	}
	
	// Teste do m�todo para consultar pessoas por ID (select no banco de dados)
	@Test
	public void testConsultarPessoasID() throws SQLException, ParseException {
		if(testDAO.consultarPessoasID(1) != null ) {
			System.out.println("testConsultarPessoasID() realizado com sucesso. Resultado ID: " 
					+ testDAO.consultarPessoasID(1));
		} else {
			fail("Erro ao testar testConsultarPessoasID().");
		}	
	}
	
	// Teste do m�todo para consultar pessoas por nome (select no banco de dados)
	@Test
	public void testConsultarPessoasNome() throws SQLException, ParseException {
		if(testDAO.consultarPessoasNome("Sarah") != null ) {
			System.out.println("testConsultarPessoasNome() realizado com sucesso. Resultado ID: " 
					+ testDAO.consultarPessoasNome("Sarah"));
		} else {
			fail("Erro ao testar testConsultarPessoasNome().");
		}	
	}
	
	// --- Testes visualizar/consultar espa�os de caf� ---
	
	// Teste do m�todo para visualizar espa�os de caf� na tela de consulta (select no banco de dados)
	@Test
	public void testVisualizarEspacos() throws SQLException, ParseException {
		if(testDAO.visualizarEspacos() != null) {
			System.out.println("testVisualizarEspacos() realizado com sucesso. Resultado ID: " 
					+ testDAO.visualizarEspacos());
		} else {
			fail("Erro ao testar testVisualizarEspacos().");
		}	
	}
	
	// Teste do m�todo para consultar espa�os de caf� da primeira etapa por ID (select no banco de dados)
	@Test
	public void testConsultarEspacoPrimeiraID() throws SQLException, ParseException {
		if(testDAO.consultarEspacoPrimeiraID(1) != null ) {
			System.out.println("testConsultarEspacoPrimeiraID() realizado com sucesso. Resultado ID: " 
					+ testDAO.consultarEspacoPrimeiraID(1));
		} else {
			fail("Erro ao testar testConsultarEspacoPrimeiraID().");
		}	
	}
	
	// Teste do m�todo para consultar espa�os de caf� da segunda etapa por ID (select no banco de dados)
	@Test
	public void testConsultarEspacoSegundaID() throws SQLException, ParseException {
		if(testDAO.consultarEspacoSegundaID(1) != null ) {
			System.out.println("testConsultarEspacoSegundaID() realizado com sucesso. Resultado ID: " 
					+ testDAO.consultarEspacoSegundaID(1));
		} else {
			fail("Erro ao testar testConsultarEspacoSegundaID().");
		}	
	}
	
	// Teste do m�todo para consultar espa�os de caf� da primeira etapa por nome (select no banco de dados)
	@Test
	public void testConsultarEspacoPrimeiraNome() throws SQLException, ParseException {
		if(testDAO.consultarEspacoPrimeiraNome("Break Time") != null ) {
			System.out.println("testConsultarEspacoPrimeiraNome() realizado com sucesso. Resultado ID: " 
					+ testDAO.consultarEspacoPrimeiraNome("Break Time"));
		} else {
			fail("Erro ao testar testConsultarEspacoPrimeiraNome().");
		}	
	}
	
	// Teste do m�todo para consultar espa�os de caf� da segunda etapa por nome (select no banco de dados)
	@Test
	public void testConsultarEspacoSegundaNome() throws SQLException, ParseException {
		if(testDAO.consultarEspacoSegundaNome("Break Time") != null ) {
			System.out.println("testConsultarEspacoSegundaNome() realizado com sucesso. Resultado ID: " 
					+ testDAO.consultarEspacoSegundaNome("Break Time"));
		} else {
			fail("Erro ao testar testConsultarEspacoSegundaNome().");
		}	
	}
	
	// --- Testes visualizar/consultar salas de eventos ---
	
	// Teste do m�todo para visualizar salas de eventos na tela de consulta (select no banco de dados)
	@Test
	public void testVisualizarSalas() throws SQLException, ParseException {
		if(testDAO.visualizarSalas() != null) {
			System.out.println("testVisualizarSalas() realizado com sucesso. Resultado ID: " 
					+ testDAO.visualizarSalas());
		} else {
			fail("Erro ao testar testVisualizarSalas().");
		}	
	}
	
	// Teste do m�todo para consultar salas de evento da primeira etapa por ID (select no banco de dados)
	@Test
	public void testConsultarSalaPrimeiraID() throws SQLException, ParseException {
		if(testDAO.consultarSalaPrimeiraID(1) != null ) {
			System.out.println("testConsultarSalaPrimeiraID() realizado com sucesso. Resultado ID: " 
					+ testDAO.consultarSalaPrimeiraID(1));
		} else {
			fail("Erro ao testar testConsultarSalaPrimeiraID().");
		}	
	}
	
	// Teste do m�todo para consultar salas de eventos da segunda etapa por ID (select no banco de dados)
	@Test
	public void testConsultarSalaSegundaID() throws SQLException, ParseException {
		if(testDAO.consultarSalaSegundaID(1) != null ) {
			System.out.println("testConsultarSalaSegundaID() realizado com sucesso. Resultado ID: " 
					+ testDAO.consultarSalaSegundaID(1));
		} else {
			fail("Erro ao testar testConsultarSalaSegundaID().");
		}	
	}
	
	// Teste do m�todo para consultar salas de evento da primeira etapa por nome (select no banco de dados)
	@Test
	public void testConsultarSalaPrimeiraNome() throws SQLException, ParseException {
		if(testDAO.consultarSalaPrimeiraNome("Sala A") != null ) {
			System.out.println("testConsultarSalaPrimeiraNome() realizado com sucesso. Resultado ID: " 
					+ testDAO.consultarSalaPrimeiraNome("Sala A"));
		} else {
			fail("Erro ao testar testConsultarSalaPrimeiraNome().");
		}	
	}
	
	// Teste do m�todo para consultar salas de evento da segunda etapa por nome (select no banco de dados)
	@Test
	public void testConsultarSalaSegundaNome() throws SQLException, ParseException {
		if(testDAO.consultarSalaSegundaNome("Sala A") != null ) {
			System.out.println("testConsultarSalaSegundaNome() realizado com sucesso. Resultado ID: " 
		+ testDAO.consultarSalaSegundaNome("Sala A"));
		} else {
			fail("Erro ao testar testConsultarSalaSegundaNome().");
		}	
	}
	
	// --- Teste cria��o das tabelas em banco ---
	
	// Teste do m�todo para cria��o das tabelas e respectivas colunas no banco de dados
	@Test
	public void testCriarTabelas() throws SQLException, ParseException {
		if(testDAO.criarTabelas()) {
			System.out.println("testCriarTabelas() realizado com sucesso");
		} else {
			fail("Erro ao testar testCriarTabelas().");
		}
	}
}
