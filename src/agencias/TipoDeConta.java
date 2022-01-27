package agencias;

public enum TipoDeConta {

	CORRENTE("1"),
	POUPANCA("2"),
	INVESTIMENTO("3");

	
private final String tipoConta;
	
	TipoDeConta(String tipoConta) {
		this.tipoConta = tipoConta;
		
	}

	public String getTipoDeConta() {
		return tipoConta;
	}
	
}
