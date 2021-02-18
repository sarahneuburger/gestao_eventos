package model;

public class PessoaModel {
	
	private int idPessoa;

	private String nomePessoa;
	
	private String sobrenomePessoa;

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

	public PessoaModel(int idPessoa, String nomePessoa, String sobrenomePessoa) {
		this.idPessoa = idPessoa;
		this.nomePessoa = nomePessoa;
		this.sobrenomePessoa = sobrenomePessoa;
	}
	
	public PessoaModel() {

	}
	
}
