package contas;

import java.util.List;
import java.util.Scanner;

import agencias.Agencia;
import erros.TratamentoExcecoesNumeros;
import erros.TratamentoExcecoesTexto;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String nome, String cpf, double rendaMensal, String numeroConta, String agencia,
			double saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
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

			System.out.println("\nSaque realizado com sucesso!\n");

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
	public void alteraDadosCadastrais() {
		// TODO Auto-generated method stub

	}

	public double depositoSaldoInicial(double valorDeposito) {

		return saldo += valorDeposito;

	}

	public void simulacaoDeInvestimento() {

		TratamentoExcecoesTexto trataExcecoesEntradaTexto = new TratamentoExcecoesTexto(null);
		Scanner sc = new Scanner(System.in);

		String valorInvestimento = null;
		String meses = null;
		String taxaRentabilidade = null;
		double montante = 0;

		System.out.print("\nDigite o valor que deseja investir (separe as casas decimais com ponto): ");

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

		System.out.println("\nDigite o período (em meses) que você pretende investir (somente numeros): ");
		while (true) {
			meses = sc.nextLine();

			try {

				if (!trataExcecoesEntradaTexto.trataExcecaoInsereMeses(meses)) {
					throw new TratamentoExcecoesTexto("Digite corretamente o período!");
				} else {

					break;
				}

			} catch (TratamentoExcecoesTexto e) {
				System.out.println("\n" + e.getMessage() + "\n");
			}

		}

		System.out.println("\nInforme a rentabilidade anual da poupança (separe as casas decimais com ponto): ");

		while (true) {
			taxaRentabilidade = sc.nextLine();

			try {

				if (!trataExcecoesEntradaTexto.trataExcecaoValoresInvestimento(taxaRentabilidade)) {
					throw new TratamentoExcecoesTexto("Digite corretamente a rentabilidade!");
				} else {

					break;
				}

			} catch (TratamentoExcecoesTexto e) {
				System.out.println("\n" + e.getMessage() + "\n");
			}

		}

		double taxaRentabilidadeFormatada = Double.parseDouble(taxaRentabilidade);
		double valorInvestimentoFormatado = Double.parseDouble(valorInvestimento);
		double mesesFormatado = Double.parseDouble(meses);

		mesesFormatado = mesesFormatado / 12;
		System.out.println(mesesFormatado);

		montante = valorInvestimentoFormatado
				* Math.pow(1 + (taxaRentabilidadeFormatada / 100), (double) mesesFormatado);

		double taxaEquivalente = (Math.pow((1 + (taxaRentabilidadeFormatada / 100)), (double) mesesFormatado / 12) - 1)
				* 100;

		System.out.println("Taxa equivalente a.m.: " + String.format("%.5f", (double) taxaEquivalente));

		System.out.println("Montante do período solicitado: " + String.format("%.2f", montante));

	}

}
