package erros;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class Teste extends InputMismatchException{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public String trataExcecaoValoresMonetarios2(String depositoInicial) {
		
		return new DecimalFormat("0.##").format(depositoInicial);
		
	}
	
}
