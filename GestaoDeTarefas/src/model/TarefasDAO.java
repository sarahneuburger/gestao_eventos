package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import connection.ConexaoBanco;

public class TarefasDAO {
	
	private ConexaoBanco conexao = new ConexaoBanco();
	
	// Insert para cadastrar tarefa
	public void cadastrarTarefa(TarefaModel tarefaModel) {
		try {
			java.sql.Date dataConvertida = java.sql.Date.valueOf(tarefaModel.getDataPrevistaConclusao());
			String sql1 = "INSERT INTO gestaotarefas.tarefas (tituloTarefa, descricaoTarefa, dataPrevistaConclusao, "
					+ "situacaoTarefa) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql1);
			pstmt.setString(1, tarefaModel.getTituloTarefa());
			pstmt.setString(2, tarefaModel.getDescricaoTarefa());
			pstmt.setDate(3, dataConvertida);
			pstmt.setString(4, tarefaModel.getSituacaoTarefa());
			pstmt.execute();
			
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
	}

	// Select para visualizar na tela de consultas tarefas em andamento e concluídas
	public DefaultTableModel consultarTarefas(String situacaoTarefa) {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("Código");
		dados.addColumn("Título");
		dados.addColumn("Descrição");
		dados.addColumn("Prazo Previsto");
		dados.addColumn("Situação");
		try {
			String sql2 = "SELECT * FROM gestaotarefas.tarefas WHERE situacaoTarefa = '" + situacaoTarefa + "'";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery(sql2);
			while (rs.next()) {
				dados.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)});
			}
			rs.close();
			pstmt.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

		return dados;

		}
	
	// Update para alterar os status de andamento para concluído
	public void alterarSituacao(int idTarefa) {
		try {
			String sql3 = "UPDATE gestaotarefas.tarefas SET situacaoTarefa = 'Concluída' WHERE idTarefa = ?";
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sql3);
			pstmt.setInt(1, idTarefa);
			pstmt.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		
	}
}
