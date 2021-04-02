package controller;


import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.table.TableModel;

import model.TarefaModel;
import model.TarefasDAO;

public class TarefasController {
	
	// Método para cadastrar tarefa
	public void cadastrarTarefa (String tituloTarefa, String descricaoTarefa, LocalDate dataPrevista, 
			String situacaoTarefa) throws SQLException, ParseException {
		TarefaModel tarefaModel = new TarefaModel();
		tarefaModel.setTituloTarefa(tituloTarefa);
		tarefaModel.setDescricaoTarefa(descricaoTarefa);
		tarefaModel.setDataPrevistaConclusao(dataPrevista);
		tarefaModel.setSituacaoTarefa(situacaoTarefa);
		new TarefasDAO().cadastrarTarefa(tarefaModel);
	}

	
	// Método para cadastrar tarefa
	public TableModel consultarTarefa(String situacaoTarefa) {
		return new TarefasDAO().consultarTarefas(situacaoTarefa);		
	}
	
	// Método para alterar a situação da tarefa
	public void alterarSituacao(int idTarefa) {
		new TarefasDAO().alterarSituacao(idTarefa);
	}
}
