package contas;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

import agencias.Agencia;

public class ContaCorrente  extends Conta{

	
	public ContaCorrente(String nome, String cpf, String rendaMensal, String numeroConta, String agencia, String saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String saque() {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String saque = sc.nextLine();
		
		return saque;
	}

	@Override
	public String deposito() {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String depositar = sc.nextLine();
		
		return depositar;
	}

	@Override
	public String saldo(String deposito, String saque, String transferencia) {
		
		double depositoConta = Double.parseDouble(deposito);
		double saqueConta = Double.parseDouble(saque);
		double transferenciaConta = Double.parseDouble(transferencia);
		
		double saldoConta = depositoConta - saqueConta - transferenciaConta;
		
		String saldoContaFormatado = new DecimalFormat("##############0.00").format(saldoConta);

		return saldoContaFormatado;
	}

	@Override
	public String extrato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String transferir() {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String transferencia = sc.nextLine();
		
		return transferencia;
	}

	@Override
	public void alteraDadosCadastrais() {
		// TODO Auto-generated method stub
		
	}
	
	public double chequeEspecial() {
		return 0;
		
	}

}
