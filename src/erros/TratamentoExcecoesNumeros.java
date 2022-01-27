package erros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TratamentoExcecoesNumeros {

	protected double valorTratado;
	protected boolean trataSintaxe;

	public double verificaEntradaIncorreta() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			try {
				valorTratado = sc.nextDouble();
				break;

			} catch (InputMismatchException e) {

				break;
			}
		}
		
		return valorTratado;

	}

	public boolean trataValorDeEntrada(double valor) {

		String rendaMensal = Double.toString(valor);
		// String rendaMensal = new DecimalFormat("##############0.00").format(valor);

		// com 00 após o ponto nao esta funcionando
		trataSintaxe = rendaMensal != null && rendaMensal.matches("[+-]?([0-9]{1,12}[.])([0-9]{1,2})");

		return trataSintaxe;
	}

	public double getValorTratado() {
		return valorTratado;
	}

	public void setValorTratado(double valorTratado) {
		this.valorTratado = valorTratado;
	}

	public boolean isTrataSintaxe() {
		return trataSintaxe;
	}

}
