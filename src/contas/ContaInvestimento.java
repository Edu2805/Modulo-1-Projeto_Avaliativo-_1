package contas;

import java.util.Scanner;
import erros.TratamentoExcecoesTexto;

public class ContaInvestimento extends Conta {

	private TiposInvestimentos tiposInvestimentos;

	public ContaInvestimento(String nome, String cpf, double rendaMensal, String numeroConta, String agencia,
			double saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	public ContaInvestimento(double valorSaque, double valorDeposito, double valorTransferencia) {
		super(valorSaque, valorDeposito, valorTransferencia);
	}
	
	
	@Override
	public double saque(double valorSaque) {

		if (valorSaque <= saldo) {
			saldo -= valorSaque;

			System.out.println("\nSaque realizado com sucesso!\n");

		} else {
			System.out.println("\nVocê não possui saldo suficiente para realizar esta operação!\n");
		}
		return this.valorSaque = valorSaque;
		

	}

	@Override
	public double deposito(double valorDeposito, double limiteAprovado) {

		this.valorDeposito = valorDeposito;
		
		return saldo += valorDeposito;
		

	}

	@Override
	public double saldo(double saldo) {

		return this.saldo = saldo;
	}

	@Override
	public void extrato() {

		System.out.println("Saldo............................................(=) = " + saldo);
		System.out.println("Depósito.........................................(+) = " + valorDeposito);
		System.out.println("Transferência....................................(-) = " + valorTransferencia);
		System.out.println("Saque............................................(-) = " + valorSaque);
		
	}

	@Override
	public double transferir(double valorTransferencia) {

		if (valorTransferencia <= saldo) {
			saldo -= valorTransferencia;

			System.out.println("\nTransferência realizado com sucesso!\n");

		} else {
			System.out.println("\nVocê não possui saldo suficiente para realizar esta operação!\n");
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

	public void simulacaoInvestimento() {

		TratamentoExcecoesTexto trataExcecoesEntradaTexto = new TratamentoExcecoesTexto(null);
		Scanner sc = new Scanner(System.in);
		String valorInvestimento = null;
		String entradaMenu = null;

		System.out.println("\nInvista em uma de nossas categorias e garanta bons rendimentos anuais\n");
		System.out.println("Faça simulações gratuitas e escolha a melhor categoria!\n");
		System.out.println(
				"Escolha uma das categorias\n1- Categoria GOLD(8,0% a.a.)\n2- Categoria PLATINUM(10,0% a.a.)\n3- Categoria BLACk(15,0% a.a.)\n-->");

		while (true) {

			entradaMenu = sc.nextLine();

			try {

				if (!trataExcecoesEntradaTexto.trataExcecaoEntradaMenu(entradaMenu)) {
					throw new TratamentoExcecoesTexto("Digite uma opção válida!");
				} else {

					break;
				}

			} catch (TratamentoExcecoesTexto e) {
				System.out.println("\n" + e.getMessage() + "\n");
			}
		}

		if (Integer.parseInt(entradaMenu) == 1) {

			System.out.print(
					"\nNa categoria GOLD não possui investimento mínimo, você pode começar com muito pouco, digite o valor que deseja investir\n-->");

			while (true) {
				valorInvestimento = sc.nextLine();

				try {

					if (!trataExcecoesEntradaTexto.trataExcecaoValoresInvestimento(valorInvestimento)) {
						throw new TratamentoExcecoesTexto("Digite corretamente o valor!");
					} else {

						break;
					}

				} catch (TratamentoExcecoesTexto e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}

			}

			double valorInvestimentoFormatado = Double.parseDouble(valorInvestimento);

			valorInvestimentoFormatado *= 1 + TiposInvestimentos.GOLD.getTiposInvestimentos();

			System.out.println("Valor do montante categoria GOLD: " + valorInvestimentoFormatado);

		} else if (Integer.parseInt(entradaMenu) == 2) {

			System.out.print(
					"\nNa categoria PLATINUM você precisar investir no mínimo R$ 1000.00,  digite o valor que deseja investir\n-->");

			while (true) {
				valorInvestimento = sc.nextLine();

				try {

					if (!trataExcecoesEntradaTexto.trataExcecaoValoresInvestimento(valorInvestimento)
							& Double.parseDouble(valorInvestimento) < 1000.00) {
						throw new TratamentoExcecoesTexto("Digite corretamente o valor!");
					} else {

						break;
					}

				} catch (TratamentoExcecoesTexto e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}

			}

			double valorInvestimentoFormatado = Double.parseDouble(valorInvestimento);

			valorInvestimentoFormatado *= 1 + TiposInvestimentos.PLATINUM.getTiposInvestimentos();

			System.out.println("\nValor do montante categoria PLATINUM: " + valorInvestimentoFormatado);

		} else {

			System.out.print(
					"\nNa categoria BLACK você precisar investir no mínimo R$ 2000.00,  digite o valor que deseja investir\n-->");

			while (true) {
				valorInvestimento = sc.nextLine();

				try {

					if (!trataExcecoesEntradaTexto.trataExcecaoValoresInvestimento(valorInvestimento)
							& Double.parseDouble(valorInvestimento) < 2000.00) {
						throw new TratamentoExcecoesTexto("Digite corretamente o valor!");
					} else {

						break;
					}

				} catch (TratamentoExcecoesTexto e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}

			}

			double valorInvestimentoFormatado = Double.parseDouble(valorInvestimento);

			valorInvestimentoFormatado *= 1 + TiposInvestimentos.BLACK.getTiposInvestimentos();

			System.out.println("\nValor do montante categoria PLATINUM: " + valorInvestimentoFormatado);

		}

	}

	public double depositoSaldoInicial(double valorDeposito) {

		return saldo += valorDeposito;

	}

}
