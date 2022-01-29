package relatorios;

import java.util.List;



public interface RelatoriosContas {

	public void listaContaCorrente(List<ListaContas> listaContasCorrente);
	public void listaContaPoupanca(List<ListaContas> listaContasPopuanca);
	public void listaContaInvestimento(List<ListaContas> listaContasInvestimento);
}
