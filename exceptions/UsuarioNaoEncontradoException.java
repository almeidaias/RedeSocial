package Rede.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{
	public String getMessage() {
		return "O usuário não foi encontrado. Cadastre-se ou tente novamente.";
	}	
}
