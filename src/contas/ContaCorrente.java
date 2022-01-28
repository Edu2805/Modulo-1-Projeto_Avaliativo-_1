package contas;

import java.util.List;
import java.util.Scanner;

public class ContaCorrente extends Conta {

	public ContaCorrente(String nome, String cpf, double rendaMensal, String numeroConta, String agencia,
			double saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	public ContaCorrente(double valorSaque, double valorDeposito, double valorTransferencia) {
		super(valorSaque, valorDeposito, valorTransferencia);
	}
	
	protected double valorChequeEspecial;
	protected double saldoInicial;
	

	public double defineValorChequeEspecial(double valorRenda) {

		double criterio = 1.5;

		double valorAprovado = criterio * valorRenda;

		return valorAprovado;
	}

	@Override
	public double saque(double valorSaque) {

		if (valorSaque <= saldo) {
			saldo -= valorSaque;

			System.out.println("\nSaque realizado com sucesso!\n");

		} else if (valorSaque == saldo + valorChequeEspecial) {

			double descontaSaldo = valorSaque - saldo;
			valorSaque -= descontaSaldo;
			saldo -= valorSaque;

			valorChequeEspecial -= descontaSaldo;

		} else if (valorSaque >= saldo) {
			System.out.println("\nVocê está usando o seu limite de cheque especial\n");

			double descontaSaldo = valorSaque - saldo;
			valorSaque -= descontaSaldo;
			saldo -= valorSaque;

			valorChequeEspecial -= descontaSaldo;

			if (valorChequeEspecial <= valorSaque) {
				System.out
						.println("\nVocê já consumiu todo o seu saldo e limite de cheque especialseu cheque especial");
				System.out.println("ˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆ");

				valorChequeEspecial += descontaSaldo;
				saldo += valorSaque;

			}

		}
		return this.valorSaque = valorSaque;
		
	}

	@Override
	public double deposito(double valorDeposito, double limiteAprovado) {

		double saldoDevedor = limiteAprovado - valorChequeEspecial;

		if (valorDeposito > saldoDevedor) {

			valorChequeEspecial += saldoDevedor;
			saldo += valorDeposito - saldoDevedor;

		} else if (valorDeposito == saldoDevedor) {

			valorChequeEspecial += saldoDevedor;

		} else {

			double valorPendente = saldoDevedor - valorDeposito;

			valorChequeEspecial += valorDeposito;

		}
		return this.valorDeposito = valorDeposito;
	}

	@Override
	public double saldo(double saldo) {

		
		
		return saldo;
	}

	@Override
	public void extrato() {
		
		System.out.println("Limite cheque especial...........................(-) = " + valorChequeEspecial);
		System.out.println("Saldo............................................(=) = " + saldo);
		System.out.println("Depósito.........................................(+) = " + valorDeposito);
		System.out.println("Transferência....................................(-) = " + valorTransferencia);
		System.out.println("Saque............................................(-) = " + valorSaque);
		
	}

	@Override
	public double transferir(double valorTransferencia) {

		if (valorTransferencia <= saldo) {
			saldo -= valorTransferencia;

			System.out.println("\nSaque realizado com sucesso!\n");

		} else if (valorTransferencia == saldo + valorChequeEspecial) {

			double descontaSaldo = valorTransferencia - saldo;
			valorTransferencia -= descontaSaldo;
			saldo -= valorTransferencia;

			valorChequeEspecial -= descontaSaldo;

		} else if (valorTransferencia >= saldo) {
			System.out.println("\nVocê está usando o seu limite de cheque especial\n");

			double descontaSaldo = valorTransferencia - saldo;
			valorTransferencia -= descontaSaldo;
			saldo -= valorTransferencia;

			valorChequeEspecial -= descontaSaldo;

			if (valorChequeEspecial <= valorTransferencia) {
				System.out.println("\nVocê já consumiu todo o seu saldo e limite de cheque especial");
				System.out.println("ˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆ");

				valorChequeEspecial += descontaSaldo;
				saldo += valorTransferencia;

			}

		}
		return this.valorTransferencia = valorTransferencia;
		
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

	public void depositoSaldoInicial(double valorDeposito) {

		
			saldo += valorDeposito;

	}
	
	public double getValorChequeEspecial() {

		return valorChequeEspecial;
	}

	//Não remover...
	public double setValorChequeEspecial(double valorChequeEspecial) {
		return this.valorChequeEspecial = valorChequeEspecial;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public double getValorSaque() {
		return valorSaque;
	}

	public double getValorDeposito() {
		return valorDeposito;
	}
	
}
