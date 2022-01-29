package relatorios;

import java.util.List;

public class TotalValorInvestido {

	protected String nome;
	protected String chaveConta;
	protected double valorInvestido;
	protected double totalInvestido;
	
	
	public TotalValorInvestido(String nome, String chaveConta, double valorInvestido) {
		this.nome = nome;
		this.chaveConta = chaveConta;
		this.valorInvestido = valorInvestido;
	}



	public void listaTotalInvestido(List<TotalValorInvestido> listaValoresInvestidos) {

		totalInvestido += valorInvestido;
		System.out.println("################ TOTAL DE INVESTIMENTOS ######################");

		System.out.println("--------------------------------------------------------------");
		for (TotalValorInvestido dadosValoresInvestidos : listaValoresInvestidos) {

			System.out.println("Conta: " + dadosValoresInvestidos.chaveConta + ", Nome: "
					+ dadosValoresInvestidos.nome + ", Valor total investido (+):" + dadosValoresInvestidos.totalInvestido);

		}
		System.out.println("--------------------------------------------------------------\n");
		
	}	
	
}
