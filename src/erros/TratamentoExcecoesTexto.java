package erros;

public class TratamentoExcecoesTexto extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TratamentoExcecoesTexto(String error) {
		super(error);
	}

	public boolean trataExcecaoEntradaMenu(String entraMenu) {

		return entraMenu != null && entraMenu.matches("[1-4]{1}");
	}

	public boolean trataExcecaoNomeClientes(String nome) {

		return nome != null && nome.matches("^[a-zA-Z ]*");
	}

	public boolean trataExcecaoCpfClientes(String cpf) {

		return cpf != null && cpf.matches("[0-9]{11}");
	}

	public boolean trataExcecaoEscolhaAgenciaCadastro(String escolheAgencia) {

		return escolheAgencia != null && escolheAgencia.matches("[1-2]{1}");
	}
	
	public boolean trataExcecaoEscolhaContaCadastro(String escolheAgencia) {

		return escolheAgencia != null && escolheAgencia.matches("[1-3]{1}");
	}

	public boolean trataExcecaoSaidaSistema(String saidaSiatema) {

		return saidaSiatema != null && saidaSiatema.matches("[1-2]{1}");
	}

	public boolean trataExcecaoSelecionaAgenciaCorrentista(String login) {

		return login != null && login.matches("[0]{2}[1-2]{1}");
	}

	public boolean trataExcecaoInserirConta(String conta) {

		return conta != null && conta.matches("([0-9]{1,})-([1-3]{1})");
	}
	
	public boolean trataExcecaoNomeDeUsuario(String nome) {

		return nome != null && nome.matches("^[a-zA-Z ]*");
	}
	
	public boolean trataExcecaoSenhaDeUsuario(String nome) {

		return nome != null && nome.matches("^[a-zA-Z ]{4}[0-9]{2}");
	}
	
	public boolean trataExcecaoMenuBanco(String entraMenu) {

		return entraMenu != null && entraMenu.matches("^([1-9]|10{1})$");
	}
	
	public boolean trataExcecaoMenuSaque(String entraMenu) {

		return entraMenu != null && entraMenu.matches("[1-3]{1}");
	}
	
	public boolean trataExcecaoConfirmaDados(String saidaSiatema) {

		return saidaSiatema != null && saidaSiatema.matches("[1-2]{1}");
	}
	
	public boolean trataExcecaoValoresInvestimento(String nome) {

		return nome != null && nome.matches("[+]?([0-9]{1,12}[.])([0-9]{1,2})");
	}
	
	public boolean trataExcecaoInsereMeses(String saidaSiatema) {

		return saidaSiatema != null && saidaSiatema.matches("[1-9]{1,2}");
	}
	
	public boolean trataExcecaoSaidaPlataforma(String saidaSiatema) {

		return saidaSiatema != null && saidaSiatema.matches("[1-3]{1}");
	}
	
	public boolean trataExcecaoMenuGerencial(String saidaSiatema) {

		return saidaSiatema != null && saidaSiatema.matches("[1-9]{1}");
	}
}
