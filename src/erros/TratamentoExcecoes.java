package erros;

public class TratamentoExcecoes extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TratamentoExcecoes(String error) {
		super(error);
	}

	public boolean trataExcecaoEntradaMenu(String entraMenu) {

		return entraMenu != null && entraMenu.matches("[1-2]{1}");
	}

	public boolean trataExcecaoNomeClientes(String nome) {

		return nome != null && nome.matches("^[a-zA-Z ]*");
	}

	public boolean trataExcecaoCpfClientes(String cpf) {

		return cpf != null && cpf.matches("[0-9]{11}");
	}

	public boolean trataExcecaoValoresMonetarios(String rendaMensal) {

		return rendaMensal != null && rendaMensal.matches("[+-]?([0-9]{1,12}[.])([0-9]{2})");
	}

	public boolean trataExcecaoEscolhaAgenciaCadastro(String escolheAgencia) {

		return escolheAgencia != null && escolheAgencia.matches("[1-2]{1}");
	}

	public boolean trataExcecaoSaidaSistema(String saidaSiatema) {

		return saidaSiatema != null && saidaSiatema.matches("[1-2]{1}");
	}

	public boolean trataExcecaoSelecionaAgenciaCorrentista(String login) {

		return login != null && login.matches("[0]{2}[1-2]{1}");
	}

	public boolean trataExcecaoInserirConta(String conta) {

		return conta != null && conta.matches("([0-9]{1,})-([1-2]{1})");
	}
	
	
	//inserir mais possibilidades
	public boolean trataExcecaoNomeDeUsuario(String nome) {

		return nome != null && nome.matches("^[a-zA-Z ]*");
	}
	
	public boolean trataExcecaoSenhaDeUsuario(String nome) {

		return nome != null && nome.matches("^[a-zA-Z ]{4}[0-9]{2}");
	}
	
	public boolean trataExcecaoMenuBanco(String entraMenu) {

		return entraMenu != null && entraMenu.matches("[1-7]{1}");
	}
	
	public boolean trataExcecaoMenuSaque(String entraMenu) {

		return entraMenu != null && entraMenu.matches("[1-3]{1}");
	}
}
