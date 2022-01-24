package operacoes;

public interface Operacao {

	public String saque();
	public String deposito();
	public String saldo(String deposito, String saque, String transferencia);
	public String extrato();
	public String transferir();
	public void alteraDadosCadastrais();
}
