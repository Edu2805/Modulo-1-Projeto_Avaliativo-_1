package contas;

import java.util.Scanner;

import agencias.Agencia;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String nome, String cpf, double rendaMensal, String numeroConta, String agencia,
			double saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	

	public void simulacaoDeInvestimento() {
		
		
	}

	@Override
	public double saque(double valorSaque) {

		if (valorSaque <= saldo) {
			saldo -= valorSaque;

			System.out.println("\nSaque realizado com sucesso!\n");

		} else {
			System.out.println("\nVocê não possui saldo suficiente para realizar esta operação!\n");
		}
		
		return getSaldo();
	}

	@Override
	public double deposito(double valorDeposito, double limiteAprovado) {

		//O atributo limiteAprovado não se aplica neste tipo de conta
		saldo += valorDeposito;
		
		
		return getSaldo();
	}

	@Override
	public double saldo(double valorChequeEspecial) {

		
		return saldo;
	}

	@Override
	public String extrato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double transferir(double valorTransferencia) {

		if (valorTransferencia <= saldo) {
			saldo -= valorTransferencia;

			System.out.println("\nSaque realizado com sucesso!\n");

		} else {
			System.out.println("\nVocê não possui saldo suficiente para realizar esta operação!\n");
		}
		return getSaldo();
	}

	@Override
	public String cadastroNomeDeUsuario() {

		Scanner sc = new Scanner(System.in);

		String nomeDeUsuario = sc.nextLine();

		return nomeDeUsuario;
	}

	@Override
	public String cadastroDeSenhaUsuario() {

		Scanner sc = new Scanner(System.in);

		String senhaDeUsuario = sc.nextLine();

		return senhaDeUsuario;
	}

	@Override
	public void alteraDadosCadastrais() {
		// TODO Auto-generated method stub

	}

}
