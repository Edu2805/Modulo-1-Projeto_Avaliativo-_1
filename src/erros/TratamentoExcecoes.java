package erros;

public class TratamentoExcecoes extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TratamentoExcecoes(String error) {
		super(error);
	}

	public boolean trataExcecaoEntradaMenu(String inteiro) {

		return inteiro != null && inteiro.matches("[1-3]{1}");
	}

	public boolean trataExcecaoNomeClientes(String nome) {

		return nome != null && nome.matches("^[a-zA-Z ]*");
	}
	
	public boolean trataExcecaoCpfClientes(String cpf) {

		return cpf != null && cpf.matches("[0-9]{11}");
	}
	
	public boolean trataExcecaoRendaClientes(String rendaMensal) {
		
		return rendaMensal != null && rendaMensal.matches("[+-]?([0-9]{1,12}[.])([0-9]{2})");
		
	}
	
	public boolean trataExcecaoEscolhaAgencia(String inteiro) {

		return inteiro != null && inteiro.matches("[1-2]{1}");
	}
}
