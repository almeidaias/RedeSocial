package Rede.exceptions;

public class SenhaIncorretaException extends RuntimeException{
	public String getMessage() {
		return "Senha incorreta. Tente novamente";
	}
}
