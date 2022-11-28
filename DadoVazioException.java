package Rede;

public class DadoVazioException extends RuntimeException{
	public String getMessage() {
		return "Os dados devem ser todos preenchidos. Tente novamente.";
	}
}

class LoginIndisponivelException extends RuntimeException{
	public String getMessage() {
		return "Esse login j� existe. Fa�a o login ou tente novamente.";
	}
}

class UsuarioNaoEncontradoException extends RuntimeException{
	public String getMessage() {
		return "O usu�rio n�o foi encontrado. Cadastre-se ou tente novamente.";
	}	
}

class SenhaIncorretaException extends RuntimeException{
	public String getMessage() {
		return "Senha incorreta. Tente novamente";
	}
}