package Rede.exceptions;

public class LoginIndisponivelException extends RuntimeException{
	public String getMessage() {
		return "Esse login j� existe. Fa�a o login ou tente novamente.";
	}
}


