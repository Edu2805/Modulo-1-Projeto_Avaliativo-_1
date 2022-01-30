package agencias;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DataDoSistema {

	public boolean verificaFimDeSemana(LocalDateTime dataDoSistema) {

		DayOfWeek diaDaSemana = dataDoSistema.getDayOfWeek();

		return diaDaSemana == DayOfWeek.SATURDAY || diaDaSemana == DayOfWeek.SUNDAY;
	}

	public boolean verificaTransacoes(LocalDateTime dataDoSistema, LocalDateTime dataAlterada) {

		int compara = dataDoSistema.compareTo(dataAlterada);
		
		if(compara < 0 || compara > 0) {
			
			return false;
		}else {
			
			return true;
		}

	}
}
