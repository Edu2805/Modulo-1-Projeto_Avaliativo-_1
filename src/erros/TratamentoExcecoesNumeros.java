package erros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TratamentoExcecoesNumeros {


	protected double valorTratadoDouble;
	protected int valorTratadoInt;
	protected boolean trataSintaxeDouble;
	protected boolean trataSintaxeInt;

	
	public double verificaEntradaIncorretaDouble() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			try {
				valorTratadoDouble = sc.nextDouble();
				break;

			} catch (InputMismatchException e) {
				
				break;
			}
		}
		
		return valorTratadoDouble;

	}
	
	public int verificaEntradaIncorretaInt() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			try {
				valorTratadoInt = sc.nextInt();
				break;

			} catch (InputMismatchException e) {

				break;
			}
		}
		
		return valorTratadoInt;

	}
	
	
	public boolean trataValorDeEntradaDouble(double valorTratadoDouble) {
		
		String valorString = Double.toString(valorTratadoDouble);
		// String rendaMensal = new DecimalFormat("##############0.00").format(valor);

		// com 00 após o ponto nao esta funcionando
		trataSintaxeDouble = valorString != null && valorString.matches("([0-9]{1,12}[.])([0-9]{1,2})");
		
		return trataSintaxeDouble;
	}
	
	public boolean trataValorDeEntradaInt(int valor) {

		String valorString = Double.toString(valor);
		// String rendaMensal = new DecimalFormat("##############0.00").format(valor);

		// com 00 após o ponto nao esta funcionando
		trataSintaxeInt = valorString != null && valorString.matches("[0-9]");

		return trataSintaxeInt;
	}

	

	public boolean isTrataSintaxe() {
		return trataSintaxeDouble;
	}

	public void setTrataSintaxe(boolean trataSintaxe) {
		this.trataSintaxeDouble = trataSintaxe;
	}

	public double getValorTratado() {
		return valorTratadoDouble;
	}

	public void setValorTratado(double valorTratado) {
		this.valorTratadoDouble = valorTratado;
	}

	public double getValorTratadoDouble() {
		return valorTratadoDouble;
	}

	public void setValorTratadoDouble(double valorTratadoDouble) {
		this.valorTratadoDouble = valorTratadoDouble;
	}

	public int getValorTratadoInt() {
		return valorTratadoInt;
	}

	public void setValorTratadoInt(int valorTratadoInt) {
		this.valorTratadoInt = valorTratadoInt;
	}

	public boolean isTrataSintaxeDouble() {
		return trataSintaxeDouble;
	}

	public void setTrataSintaxeDouble(boolean trataSintaxeDouble) {
		this.trataSintaxeDouble = trataSintaxeDouble;
	}

	public boolean isTrataSintaxeInt() {
		return trataSintaxeInt;
	}

	public void setTrataSintaxeInt(boolean trataSintaxeInt) {
		this.trataSintaxeInt = trataSintaxeInt;
	}
	
}
