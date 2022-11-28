package Rede;

public class DadoVazioException extends RuntimeException{
	public String getMessage() {
		return "Os dados devem ser todos preenchidos. Tente novamente.";
	}
}

class LoginIndisponivelException extends RuntimeException{
	public String getMessage() {
		return "Esse login já existe. Faça o login ou tente novamente.";
	}
}

class UsuarioNaoEncontradoException extends RuntimeException{
	public String getMessage() {
		return "O usuário não foi encontrado. Cadastre-se ou tente novamente.";
	}	
}

class SenhaIncorretaException extends RuntimeException{
	public String getMessage() {
		return "Senha incorreta. Tente novamente";
	}
}