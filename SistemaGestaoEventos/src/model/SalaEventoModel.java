package model;

public class SalaEventoModel {
	
	private int idSalaEvento;
	
	private String nomeSalaEvento;
	
	private int lotacaoSalaEvento;

	public int getIdSalaEvento() {
		return idSalaEvento;
	}

	public void setIdSalaEvento(int idSalaEvento) {
		this.idSalaEvento = idSalaEvento;
	}

	public String getNomeSalaEvento() {
		return nomeSalaEvento;
	}

	public void setNomeSalaEvento(String nomeSalaEvento) {
		this.nomeSalaEvento = nomeSalaEvento;
	}

	public int getLotacaoSalaEvento() {
		return lotacaoSalaEvento;
	}

	public void setLotacaoSalaEvento(int lotacaoSalaEvento) {
		this.lotacaoSalaEvento = lotacaoSalaEvento;
	}

	public SalaEventoModel(int idSalaEvento, String nomeSalaEvento, int lotacaoSalaEvento) {
		this.idSalaEvento = idSalaEvento;
		this.nomeSalaEvento = nomeSalaEvento;
		this.lotacaoSalaEvento = lotacaoSalaEvento;
	}
	
	public SalaEventoModel(String nomeSalaEvento, int lotacaoSalaEvento) {
		this.nomeSalaEvento = nomeSalaEvento;
		this.lotacaoSalaEvento = lotacaoSalaEvento;
	}
	
	public SalaEventoModel() {
		
	}

	
}

