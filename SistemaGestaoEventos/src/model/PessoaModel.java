package model;

public class PessoaModel {

	private int idPessoa;
	private String nomePessoa;
	private String sobrenomePessoa;
	private int idSalaPrimeiraEtapa;
	private int idSalaSegundaEtapa;
	private int idEspacoPrimeiraEtapa;
	private int idEspacoSegundaEtapa;
	
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


	public int getIdEspacoPrimeiraEtapa() {
		return idEspacoPrimeiraEtapa;
	}

	public void setIdEspacoPrimeiraEtapa(int idEspacoPrimeiraEtapa) {
		this.idEspacoPrimeiraEtapa = idEspacoPrimeiraEtapa;
	}

	public int getIdEspacoSegundaEtapa() {
		return idEspacoSegundaEtapa;
	}

	public void setIdEspacoSegundaEtapa(int idEspacoSegundaEtapa) {
		this.idEspacoSegundaEtapa = idEspacoSegundaEtapa;
	}

	
	
	public PessoaModel(int idPessoa, String nomePessoa, String sobrenomePessoa, int idSalaPrimeiraEtapa,
			int idSalaSegundaEtapa, int idEspacoPrimeiraEtapa, int idEspacoSegundaEtapa) {
		this.idPessoa = idPessoa;
		this.nomePessoa = nomePessoa;
		this.sobrenomePessoa = sobrenomePessoa;
		this.idSalaPrimeiraEtapa = idSalaPrimeiraEtapa;
		this.idSalaSegundaEtapa = idSalaSegundaEtapa;
		this.idEspacoPrimeiraEtapa = idEspacoPrimeiraEtapa;
		this.idEspacoSegundaEtapa = idEspacoSegundaEtapa;
	}
	
	public PessoaModel(String nomePessoa, String sobrenomePessoa, int idSalaPrimeiraEtapa,
			int idSalaSegundaEtapa, int idEspacoPrimeiraEtapa, int idEspacoSegundaEtapa) {
		this.nomePessoa = nomePessoa;
		this.sobrenomePessoa = sobrenomePessoa;
		this.idSalaPrimeiraEtapa = idSalaPrimeiraEtapa;
		this.idSalaSegundaEtapa = idSalaSegundaEtapa;
		this.idEspacoPrimeiraEtapa = idEspacoPrimeiraEtapa;
		this.idEspacoSegundaEtapa = idEspacoSegundaEtapa;
	}
	

	public PessoaModel() {

	}
	
}
