package relatorios;

import java.util.List;

public class TransacoesClientes {

	protected String nome;
	protected String chaveConta;
	protected String agencia;
	protected double depositoIncial;
	protected double deposito;
	protected double saque;
	protected double transferencia;
	
	public TransacoesClientes(String nome, String chaveConta, String agencia, double depositoIncial, double deposito,
			double saque, double transferencia) {
		super();
		this.nome = nome;
		this.chaveConta = chaveConta;
		this.agencia = agencia;
		this.depositoIncial = depositoIncial;
		this.deposito = deposito;
		this.saque = saque;
		this.transferencia = transferencia;
	}

	public void transacaoSaque(List<TransacoesClientes> listaTransacoesClientes) {
		
		
		System.out.println("############### CONTAS COM SALDO NEGATIVO ####################");

		System.out.println("--------------------------------------------------------------");
		
		for (TransacoesClientes nomeCliente : listaTransacoesClientes) {
			
			System.out.println("Nome: " + nomeCliente.nome + "Agência: " + nomeCliente.agencia + ", Conta: " + nomeCliente.chaveConta);
			
			
			for (TransacoesClientes dadosTransacoes : listaTransacoesClientes) {

				

			}
			
		}
		
		System.out.println("--------------------------------------------------------------\n");
	}	
	
}
