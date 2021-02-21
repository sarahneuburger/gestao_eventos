package model;

public class PessoaModel {
	
	private int idPessoa;
	private String nomePessoa;
	private String sobrenomePessoa;
	private int idSalaPrimeiraEtapa;
	private int idSalaSegundaEtapa;
	private int idEspacoCafe;
	
	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getSobrenomePessoa() {
		return sobrenomePessoa;
	}

	public void setSobrenomePessoa(String sobrenomePessoa) {
		this.sobrenomePessoa = sobrenomePessoa;
	}

	
	public int getIdSalaPrimeiraEtapa() {
		return idSalaPrimeiraEtapa;
	}

	public void setIdSalaPrimeiraEtapa(int idSalaPrimeiraEtapa) {
		this.idSalaPrimeiraEtapa = idSalaPrimeiraEtapa;
	}

	public int getIdSalaSegundaEtapa() {
		return idSalaSegundaEtapa;
	}

	public void setIdSalaSegundaEtapa(int idSalaSegundaEtapa) {
		this.idSalaSegundaEtapa = idSalaSegundaEtapa;
	}

	public int getIdEspacoCafe() {
		return idEspacoCafe;
	}

	public void setIdEspacoCafe(int idEspacoCafe) {
		this.idEspacoCafe = idEspacoCafe;
	}
	
	public PessoaModel(int idPessoa, String nomePessoa, String sobrenomePessoa, int idSalaPrimeiraEtapa,
			int idSalaSegundaEtapa, int idEspacoCafe) {
		this.idPessoa = idPessoa;
		this.nomePessoa = nomePessoa;
		this.sobrenomePessoa = sobrenomePessoa;
		this.idSalaPrimeiraEtapa = idSalaPrimeiraEtapa;
		this.idSalaSegundaEtapa = idSalaSegundaEtapa;
		this.idEspacoCafe = idEspacoCafe;
	}

	public PessoaModel() {

	}
	
}
