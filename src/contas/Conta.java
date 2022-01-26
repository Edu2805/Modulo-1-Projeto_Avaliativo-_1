package contas;

import operacoes.Operacao;


public abstract class Conta implements Operacao {

	private String nome;
	private String cpf;
	private double rendaMensal;
	private String numeroConta;
	private String agencia;
	protected double saldo;
	public Conta(String nome, String cpf, double rendaMensal, String numeroConta, String agencia, double saldo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rendaMensal = rendaMensal;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = saldo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	public double getRendaMensal() {
		return rendaMensal;
	}
	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
}
