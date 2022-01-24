package contas;

import lombok.AllArgsConstructor;
import lombok.Data;
import operacoes.Operacao;

@Data
@AllArgsConstructor
public abstract class Conta implements Operacao {

	private String nome;
	private String cpf;
	private String rendaMensal;
	private String numeroConta;
	private String agencia;
	protected String saldo;
	
}
