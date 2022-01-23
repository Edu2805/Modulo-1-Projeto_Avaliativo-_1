package contas;

import agencias.Agencia;
import lombok.Data;

@Data
public class ContaInvestimento extends Conta {

	
	private TiposInvestimentos tiposInvestimentos;
	
	public ContaInvestimento(String nome, String cpf, double rendaMensal, int numeroConta, Agencia agencia,
			double saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double saque() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposito() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double saldo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double extrato() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double transferir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void alteraDadosCadastrais() {
		// TODO Auto-generated method stub
		
	}
	
	public void simulacaoInvestimento() {
		
		tiposInvestimentos.GOLD.getTiposInvestimentos();
		tiposInvestimentos.PLATINUM.getTiposInvestimentos();
		tiposInvestimentos.BLACK.getTiposInvestimentos();
	}
}
