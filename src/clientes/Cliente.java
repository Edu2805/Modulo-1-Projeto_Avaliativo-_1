package clientes;

public abstract class Cliente implements CadastroDaConta{

	protected String nome;
	protected String cpf;
	protected String endereco;
	protected String dataNascimento;
	protected String login;
	protected String senha;
	protected String rendaMensal;
	
	
	public Cliente(String nome, String cpf, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	protected String getNome() {
		return nome;
	}
	
	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	protected String getCpf() {
		return cpf;
	}
	
	protected String getRendaMensal() {
		return rendaMensal;
	}
	
	protected void setRendaMensal(String rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
