package Rede.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{
	public String getMessage() {
		return "O usu�rio n�o foi encontrado. Cadastre-se ou tente novamente.";
	}	
}
