package contas;

import java.util.Scanner;

import erros.TratamentoExcecoesTexto;

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
	protected double descontaSaldo;
	protected double descontaSaque;

	public double defineValorChequeEspecial(double valorRenda) {

		double criterio = 1.5;

		double valorAprovado = criterio * valorRenda;

		return valorAprovado;
	}

	@Override
	public double saque(double valorSaque) {

		double descontaSaldo = 0.0;

		if (valorSaque <= saldo) {
			saldo -= valorSaque;

			System.out.println("\nSaque realizado com sucesso!\n");

		} else if (valorSaque == saldo + valorChequeEspecial) {

			descontaSaldo = valorSaque - saldo;
			valorSaque -= descontaSaldo;
			saldo -= valorSaque;

			valorChequeEspecial -= descontaSaldo;

		} else if (valorSaque >= saldo) {
			System.out.println("\nVocê está usando o seu limite de cheque especial\n");

			descontaSaldo = valorSaque - saldo;
			valorSaque -= descontaSaldo;
			saldo -= valorSaque;

			valorChequeEspecial -= descontaSaldo;

			if (valorChequeEspecial <= valorSaque) {
				System.out
						.println("\nVocê já consumiu todo o seu saldo e limite de cheque especialseu cheque especial");
				System.out.println("ˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆ");

				valorChequeEspecial += descontaSaldo;
				saldo += valorSaque;
				// ver problema pra limpar transferencia e saldo...
			}

		}

		this.descontaSaque = descontaSaldo;

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
		System.out.println(
				"Transferência....................................(-) = " + (valorTransferencia + this.descontaSaldo));
		System.out
				.println("Saque............................................(-) = " + (valorSaque + this.descontaSaque));

	}

	@Override
	public double transferir(double valorTransferencia) {

		double descontaSaldo = 0.0;

		if (valorTransferencia <= saldo) {
			saldo -= valorTransferencia;

			System.out.println("\nTransferencia realizado com sucesso!\n");

		} else if (valorTransferencia == saldo + valorChequeEspecial) {

			descontaSaldo = valorTransferencia - saldo;
			valorTransferencia -= descontaSaldo;
			saldo -= valorTransferencia;

			valorChequeEspecial -= descontaSaldo;

		} else if (valorTransferencia >= saldo) {
			System.out.println("\nVocê está usando o seu limite de cheque especial\n");

			descontaSaldo = valorTransferencia - saldo;
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
		this.descontaSaldo = descontaSaldo;

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

	public void depositoSaldoInicial(double valorDeposito) {

		saldo += valorDeposito;

	}

	@Override
	public String alteraDadosCadastrais(String nome, String nomeDeUsuario, String senha) {

		TratamentoExcecoesTexto trataExcecoesEntradaTexto = new TratamentoExcecoesTexto(null);
		String opcoesMenu = null;
		String alteraChave = null;

		Scanner sc = new Scanner(System.in);

		System.out.println("#########################################################");
		System.out.println("#               O QUE VOCE DESEJA ALTERAR?              #");
		System.out.print("#########################################################\n");
		System.out.println("#########################################################");
		System.out.println("#                                                       #");
		System.out.println("#           DIGITE 1- NOME DE USUÁRIO                   #");
		System.out.println("#           DIGITE 2- SENHA                             #");
		System.out.println("#                                                       #");
		System.out.println("#########################################################");
		System.out.print("-->");

		boolean validacaoMenu = false;
		
		while (!validacaoMenu) {

			opcoesMenu = sc.nextLine();
			try {

				if (!trataExcecoesEntradaTexto.trataExcecaoEntradaMenu(opcoesMenu)) {
					throw new TratamentoExcecoesTexto("Digite uma opção válida!");
				} else {

					break;
				}

			} catch (TratamentoExcecoesTexto e) {
				System.out.println("\n" + e.getMessage() + "\n");
			}
		}

		switch (Integer.parseInt(opcoesMenu)) {

		case 1:

			while (!validacaoMenu) {
				System.out.print("\nInsira o seu nome de usuário: ");
				nomeDeUsuario = sc.nextLine();

				try {

					if (!trataExcecoesEntradaTexto.trataExcecaoNomeDeUsuario(nomeDeUsuario)) {
						throw new TratamentoExcecoesTexto("Insira corretamente o seu nome de usuário!");

					} else {

						break;
					}

				} catch (TratamentoExcecoesTexto e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
			}

			break;
		case 2:

			while (!validacaoMenu) {

				System.out.print("\nInsira a sua senha de QUATRO LETRAS E DOIS NÚMEROS: ");
				senha = sc.nextLine();

				try {

					if (!trataExcecoesEntradaTexto.trataExcecaoSenhaDeUsuario(senha)) {
						throw new TratamentoExcecoesTexto(

								"Formato inválido, digite uma senha que contenha quatro letras e dois numeros!");
					} else {

						break;
					}

				} catch (TratamentoExcecoesTexto e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}

			}

			break;
		
		}

		System.out.println("\nConfira os seus dados\n");
		System.out.println("Nome: " + nome + "\nNomeUsuário: " + nomeDeUsuario + "\nSenha: " + senha + "\n");
		
		alteraChave = nome.concat("-").concat(nomeDeUsuario).concat(senha);

		return alteraChave;

	}

	public double getValorChequeEspecial() {

		return valorChequeEspecial;
	}

	// Não remover...
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
