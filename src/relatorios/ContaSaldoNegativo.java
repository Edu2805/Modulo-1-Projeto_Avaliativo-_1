package relatorios;

import java.util.List;

public class ContaSaldoNegativo {

	protected String nome;
	protected String chaveConta;
	protected String agencia;
	protected double chequeEspecialConsumido;
	protected double chequeEspcialPreAprovado;
	public ContaSaldoNegativo(String nome, String chaveConta, String agencia, double chequeEspecialConsumido, double chequeEspcialPreAprovado) {
		super();
		this.nome = nome;
		this.chaveConta = chaveConta;
		this.agencia = agencia;
		this.chequeEspecialConsumido = chequeEspecialConsumido;
		this.chequeEspcialPreAprovado = chequeEspcialPreAprovado;
	}
	
	
	public void listaContaCorrente(List<ContaSaldoNegativo> listaDeContasSaldoNegativo) {

		System.out.println("############### CONTAS COM SALDO NEGATIVO ####################");

		System.out.println("--------------------------------------------------------------");
		for (ContaSaldoNegativo dadosConta : listaDeContasSaldoNegativo) {

			System.out.println("Agência: " + dadosConta.agencia + ", Conta: " + dadosConta.chaveConta + ", Nome: "
					+ dadosConta.nome + ", Valor (-):" + (dadosConta.chequeEspcialPreAprovado - dadosConta.chequeEspecialConsumido));

		}
		System.out.println("--------------------------------------------------------------\n");
	}	
}
