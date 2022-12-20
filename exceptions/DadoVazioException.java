package Rede.exceptions;

public class DadoVazioException extends RuntimeException{
	public String getMessage() {
		return "Os dados devem ser todos preenchidos. Tente novamente.";
	}
}