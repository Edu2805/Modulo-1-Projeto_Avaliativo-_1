package contas;

public class ChaveLoginConta {

	
	public boolean validaLogin(String login, String verificaLogin) {
		
		
		if(login.equals(verificaLogin)) {
			return true;
		} else {
			return false;
		}
	}
}
