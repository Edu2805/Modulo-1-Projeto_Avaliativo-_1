package operacoes;


public interface Operacao {

	public double saque(double valorSaque);
	public double deposito(double valorDeposito, double limiteAprovado);
	public double saldo(double saque);
	public double transferir(double valorTransferencia);
	public String cadastroNomeDeUsuario();
	public String cadastroDeSenhaUsuario();
	public String alteraDadosCadastrais(String nome, String nomeDeUsuario, String senha);
	public void extrato();
}
