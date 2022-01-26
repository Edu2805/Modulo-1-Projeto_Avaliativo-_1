package contas;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class ContaCorrente extends Conta {

	public ContaCorrente(String nome, String cpf, double rendaMensal, String numeroConta, String agencia,
			double saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double saque(double valorSaque) {

		if (getSaldo() <= 0) {
			
		} else {
			saldo -= valorSaque;
		}

		return getSaldo();
	}

	@Override
	public double deposito(double valorDeposito) {

		saldo += valorDeposito;

		return getSaldo();
	}

	@Override
	public double saldo(double saldo) {

		//verificar para não somar ao saldo
		saldo += chequeEspecial();

		return saldo;
	}

	@Override
	public String extrato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double transferir(double valorTransferencia) {

		if (getSaldo() <= 0) {
			
		} else {
			saldo -= valorTransferencia;
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

	public double chequeEspecial() {
		
		
		return 0;

	}
}
