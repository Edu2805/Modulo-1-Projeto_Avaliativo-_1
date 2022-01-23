package agencias;

public enum Agencia {

	FLORIANOPOLIS("001"),
	SAOJOSE("002");

	private final String agencias;
	
	Agencia(String agencias) {
		this.agencias = agencias;
		
	}

	public String getAgencias() {
		return agencias;
	}
}
