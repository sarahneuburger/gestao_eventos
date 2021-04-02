package model;


import java.time.LocalDate;

public class TarefaModel {
	
	private int idTarefa;
	private String tituloTarefa;
	private String descricaoTarefa;
	private LocalDate dataPrevistaConclusao;
	private String situacaoTarefa;
	private String prazoTarefa;
	
	public int getIdTarefa() {
		return idTarefa;
	}
	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}
	public String getTituloTarefa() {
		return tituloTarefa;
	}
	public void setTituloTarefa(String tituloTarefa) {
		this.tituloTarefa = tituloTarefa;
	}
	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}
	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}
	public LocalDate getDataPrevistaConclusao() {
		return dataPrevistaConclusao;
	}
	public void setDataPrevistaConclusao(LocalDate dataPrevista) {
		this.dataPrevistaConclusao = dataPrevista;
	}
	
	public String getSituacaoTarefa() {
		return situacaoTarefa;
	}
	public void setSituacaoTarefa(String situacaoTarefa) {
		this.situacaoTarefa = situacaoTarefa;
	}
	public String getPrazoTarefa() {
		return prazoTarefa;
	}
	public void setPrazoTarefa(String prazoTarefa) {
		this.prazoTarefa = prazoTarefa;
	}
	
	
	public TarefaModel(int idTarefa, String tituloTarefa, String descricaoTarefa, LocalDate dataPrevistaConclusao,
			String situacaoTarefa, String prazoTarefa) {
		this.idTarefa = idTarefa;
		this.tituloTarefa = tituloTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.situacaoTarefa = situacaoTarefa;
		this.prazoTarefa = prazoTarefa;
	}
	
	public TarefaModel() {
		
	}

	public TarefaModel(int idTarefa, String tituloTarefa, String descricaoTarefa, LocalDate dataPrevistaConclusao,
			String situacaoTarefa) {
		this.idTarefa = idTarefa;
		this.tituloTarefa = tituloTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.situacaoTarefa = situacaoTarefa;
	}
	

}
