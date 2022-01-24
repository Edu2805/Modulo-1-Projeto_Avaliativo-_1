package clientes;

public abstract class Cliente implements CadastroDaConta{

	protected String nome;
	protected String cpf;
	protected String rendaMensal;
	
	
	protected String getNome() {
		return nome;
	}
	
	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	protected String getCpf() {
		return cpf;
	}
	
	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	protected String getRendaMensal() {
		return rendaMensal;
	}
	
	protected void setRendaMensal(String rendaMensal) {
		this.rendaMensal = rendaMensal;
	}
}
