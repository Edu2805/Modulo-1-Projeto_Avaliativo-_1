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
		

		System.out.println("--------------------------------------------------------------");
		
		for (int i = 0; i < listaTransacoesClientes.size(); i++) {
			
			System.out.println("Nome: " + listaTransacoesClientes.get(i).nome + ", Agência: " + listaTransacoesClientes.get(i).agencia + ", Conta: " + listaTransacoesClientes.get(i).chaveConta);
			
			
			for (int j = 0; j < listaTransacoesClientes.size(); j++) {
				
				if(i == j) {
					
					System.out.println("Depósito inicial: " + listaTransacoesClientes.get(j).depositoIncial + ", Depósito: " + listaTransacoesClientes.get(j).deposito 
							+ ", Saque: " + listaTransacoesClientes.get(j).saque + ", Transferência: " + listaTransacoesClientes.get(j).transferencia);
					
					
				} else if(j > i) {
					
					 //evita que o usuário imediatamente anterior receba dados do usuário seguinte, por isso esse campo fica vazio
				}
					
					
					
					
					
			}
		}
		
		System.out.println("\n");
		
		System.out.println("--------------------------------------------------------------\n");
	}	
	
}
