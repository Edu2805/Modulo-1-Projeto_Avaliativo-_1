package contas;

import agencias.Agencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import operacoes.Operacao;

@Data
@AllArgsConstructor
public abstract class Conta implements Operacao {

	private String nome;
	private String cpf;
	private double rendaMensal;
	private int numeroConta;
	private Agencia agencia;
	private double saldo;
	
}
