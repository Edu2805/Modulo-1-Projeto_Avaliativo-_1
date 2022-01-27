package agencias;

public class GeradorNumeroConta implements GeraNumeroConta{

	
	@Override
	public String geradorDeContaCorrente(int corrente) {
		
		String contaCorrente = Integer.toString(corrente);
		
		String geraNumeroContaCorrente = contaCorrente.concat("-").concat(TipoDeConta.CORRENTE.getTipoDeConta());
		
		return geraNumeroContaCorrente;
	}

	@Override
	public String geradorDeContaPoupanca(int poupanca) {
		
		String contaPoupanca = Integer.toString(poupanca);
		
		String geraNumeroContaPoupanca = contaPoupanca.concat("-").concat(TipoDeConta.POUPANCA.getTipoDeConta());
		
		return geraNumeroContaPoupanca;
	}

	@Override
	public String geradorDeContaInvestimento(int investimento) {
		
		String contaInvestimento = Integer.toString(investimento);
		
		String geraNumeroContaInvestimento = contaInvestimento.concat("-").concat(TipoDeConta.INVESTIMENTO.getTipoDeConta());
		
		return geraNumeroContaInvestimento;
	}
}
