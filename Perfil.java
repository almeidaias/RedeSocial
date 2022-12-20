package Rede;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfil {
	private String nome;
	private String login;
	private String senha;
	private List<Post> posts;
	private int quantPosts = 0;
	static Scanner sc = new Scanner(System.in);
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public List<Post> getPosts() {
		return posts;
	}
	
	public Perfil(String login, String nome, String senha) {
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.posts = new ArrayList<>();
	}
	
	public boolean confereSenha(String senhaInserida) {
		return senhaInserida.equals(this.senha);
	}
	
	public void novoPost() {
		System.out.println("Insira o conteúdo.");
		String texto = sc.nextLine();
		this.posts.add(new Post(texto, LocalDateTime.now()));
		this.quantPosts++;
		System.out.println("Postado com sucesso! \n");
	}
	
	public void verTimeline(){
		if(quantPosts==0) {
			System.out.println("Ainda não há posts! Poste para poder imprimir a timeline. \n");
		}else {
			DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
			for(Post post : this.posts) {
				System.out.println(post.getData().format(formatadorData)+ " \n " + post.getTexto() + "\n");
			}
		}
	}
	
	
}
