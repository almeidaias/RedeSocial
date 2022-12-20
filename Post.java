package Rede;

import java.time.LocalDateTime;

public class Post {
	private LocalDateTime data;
	private String texto;


	public LocalDateTime getData() {
		return data;
	}


	public String getTexto() {
		return texto;
	}


	public Post(String texto, LocalDateTime data) {
		this.texto = texto;
		this.data = data;
	}
}
