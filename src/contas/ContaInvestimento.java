package contas;

import agencias.Agencia;
import lombok.Data;

@Data
public class ContaInvestimento extends Conta {

	
	private TiposInvestimentos tiposInvestimentos;
	
	public ContaInvestimento(String nome, String cpf, double rendaMensal, String numeroConta, String agencia,
			double saldo) {
		super(nome, cpf, rendaMensal, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double saque(double valorSaque) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposito(double valorDeposito) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double saldo(double saque) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String extrato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double transferir(double valorTransferencia) {
if (getSaldo() <= 0) {
			
		} else {
			saldo -= valorTransferencia;
		}

		return getSaldo();
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

	@Override
	public String cadastroNomeDeUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cadastroDeSenhaUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
}
