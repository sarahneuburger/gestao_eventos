package model;

public class SalaEventoModel {
	
	private int idSalaEvento;
	
	private String nomeSalaEvento;
	
	private String lotacaoSalaEvento;

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

	public String getLotacaoSalaEvento() {
		return lotacaoSalaEvento;
	}

	public void setLotacaoSalaEvento(String lotacaoSalaEvento) {
		this.lotacaoSalaEvento = lotacaoSalaEvento;
	}

	public SalaEventoModel(int idSalaEvento, String nomeSalaEvento, String lotacaoSalaEvento) {
		this.idSalaEvento = idSalaEvento;
		this.nomeSalaEvento = nomeSalaEvento;
		this.lotacaoSalaEvento = lotacaoSalaEvento;
	}
	
	public SalaEventoModel() {
		
	}
	
	
}
