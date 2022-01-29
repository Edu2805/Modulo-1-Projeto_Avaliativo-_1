package relatorios;

import java.util.List;


public class ListaContas implements RelatoriosContas {

	protected String nome;
	protected String chaveConta;
	protected String agencia;

	public ListaContas(String nome, String chaveConta, String agencia) {
		super();
		this.nome = nome;
		this.chaveConta = chaveConta;
		this.agencia = agencia;
	}

	@Override
	public void listaContaCorrente(List<ListaContas> listaDeContasCorrente) {

		System.out.println("#################### CONTAS CORRENTES #########################");

		System.out.println("---------------------------------------------------------------");
		for (ListaContas dadosConta : listaDeContasCorrente) {

			System.out.println("Agência: " + dadosConta.agencia + ", Conta: " + dadosConta.chaveConta + ", Nome: "
					+ dadosConta.nome);

		}
		System.out.println("---------------------------------------------------------------\n");

	}

	@Override
	public void listaContaPoupanca(List<ListaContas> listaContasPopuanca) {

		System.out.println("#################### CONTAS POUPANÇAS #########################");

		System.out.println("---------------------------------------------------------------");
		for (ListaContas dadosConta : listaContasPopuanca) {

			System.out.println("Agência: " + dadosConta.agencia + ", Conta: " + dadosConta.chaveConta + ", Nome: "
					+ dadosConta.nome);

		}
		System.out.println("---------------------------------------------------------------\n");

	}

	@Override
	public void listaContaInvestimento(List<ListaContas> listaContasInvestimento) {

		System.out.println("#################### CONTAS INVESTIMENTOS #####################");

		System.out.println("---------------------------------------------------------------");
		for (ListaContas dadosConta : listaContasInvestimento) {

			System.out.println("Agência: " + dadosConta.agencia + ", Conta: " + dadosConta.chaveConta + ", Nome: "
					+ dadosConta.nome);

		}
		System.out.println("---------------------------------------------------------------\n");

	}

}
