package operacoes;


public interface Operacao {

	public double saque(double valorSaque);
	public double deposito(double valorDeposito, double limiteAprovado);
	public double saldo(double saque);
	public double transferir(double valorTransferencia);
	public String cadastroNomeDeUsuario();
	public String cadastroDeSenhaUsuario();
	public void alteraDadosCadastrais(String nome, String renda, String nomeUsuario, String senha);
	public void extrato();
}
