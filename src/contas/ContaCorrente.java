package contas;

import agencias.Agencia;

public class ContaCorrente  extends Conta{

	
	public ContaCorrente(String nome, String cpf, String rendaMensal, String numeroConta, String agencia, double saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double saque() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposito() {
		
		return 0;
	}

	@Override
	public double saldo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double extrato() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double transferir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void alteraDadosCadastrais() {
		// TODO Auto-generated method stub
		
	}
	
	public double chequeEspecial() {
		return 0;
		
	}

}
