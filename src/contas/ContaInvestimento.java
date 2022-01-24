package contas;

import agencias.Agencia;
import lombok.Data;

@Data
public class ContaInvestimento extends Conta {

	
	private TiposInvestimentos tiposInvestimentos;
	
	public ContaInvestimento(String nome, String cpf, String rendaMensal, String numeroConta, String agencia,
			String saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String saque() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deposito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saldo(String deposito, String saque, String transferencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String extrato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String transferir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alteraDadosCadastrais() {
		// TODO Auto-generated method stub
		
	}
	
	public void simulacaoInvestimento() {
		
		TiposInvestimentos.GOLD.getTiposInvestimentos();
		TiposInvestimentos.PLATINUM.getTiposInvestimentos();
		TiposInvestimentos.BLACK.getTiposInvestimentos();
	}
}
