package Rede.exceptions;

public class LoginIndisponivelException extends RuntimeException{
	public String getMessage() {
		return "Esse login já existe. Faça o login ou tente novamente.";
	}
}


