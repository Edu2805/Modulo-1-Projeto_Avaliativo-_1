package clientes;

public abstract class Cliente implements CadastroDaConta{

	protected String nome;
	protected String cpf;
	protected String endereco;
	protected String dataNascimento;
	protected String login;
	protected String senha;
	protected double rendaMensal;

	protected String getNome() {
		return nome;
	}


	protected void setNome(String nome) {
		this.nome = nome;
	}


	protected String getCpf() {
		return cpf;
	}

	protected String getEndereco() {
		return endereco;
	}


	protected void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	protected void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	protected String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	protected String getSenha() {
		return senha;
	}


	protected void setSenha(String senha) {
		this.senha = senha;
	}


	protected double getRendaMensal() {
		return rendaMensal;
	}


	protected void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}
	
}
