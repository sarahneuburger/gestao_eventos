package model;

public class EspacoCafeModel {
	
	private int idEspacoCafe;
	
	private String nomeEspacoCafe;

	public int getIdEspacoCafe() {
		return idEspacoCafe;
	}

	public void setIdEspacoCafe(int idEspacoCafe) {
		this.idEspacoCafe = idEspacoCafe;
	}

	public String getNomeEspacoCafe() {
		return nomeEspacoCafe;
	}

	public void setNomeEspacoCafe(String nomeEspacoCafe) {
		this.nomeEspacoCafe = nomeEspacoCafe;
	}

	public EspacoCafeModel(int idEspacoCafe, String nomeEspacoCafe) {
		this.idEspacoCafe = idEspacoCafe;
		this.nomeEspacoCafe = nomeEspacoCafe;
	}
	
	public EspacoCafeModel(String nomeEspacoCafe) {
		this.nomeEspacoCafe = nomeEspacoCafe;
	}
	public EspacoCafeModel() {
		
	}

}
