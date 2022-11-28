package Rede;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Perfil {
	String nome;
	String login;
	String senha;
	
	Post [] posts = new Post [100];
	int quantPosts = 0;
	Scanner sc = new Scanner(System.in);
	
	public void novoPost() {
		this.posts[quantPosts] = new Post();
		insereData();
		insereHora();
		System.out.println("Insira o conteúdo.");
		this.posts[quantPosts].texto = sc.nextLine();
		this.quantPosts++;
		System.out.println("Postado com sucesso! \n");
		RedeSocial.menuDoUsuario();
	}
	
	public void verTimeline(){
		if(quantPosts==0) {
			System.out.println("Ainda não há posts! Poste para poder imprimir a timeline. \n");
		}else {
			for(int i=0 ; i<quantPosts ; i++) {
				System.out.println(this.posts[i].data + " às " + this.posts[i].hora + " - " + this.posts[i].texto + "\n");
			}
		}
		RedeSocial.menuDoUsuario();
	}
	
	public void insereData() {
		boolean dataCorreta = false;
		while(!dataCorreta){
			System.out.println("Insira a data (dd/mm/aaaa)");
			this.posts[quantPosts].data = sc.nextLine();
			DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			try {
				LocalDate inputDate = LocalDate.parse(this.posts[quantPosts].data, formatadorData);
				dataCorreta=true;
			} catch (Exception e) {
				System.out.println("ERRO! Insira a data no formato correto!");
			}
		}
	}
	
	public void insereHora() {
		boolean horaCorreta=false;
		while(!horaCorreta){
			System.out.println("Insira a hora. (hh:mm)");
			this.posts[quantPosts].hora = sc.nextLine();
			DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
			try {
				LocalTime inputTime = LocalTime.parse(this.posts[quantPosts].hora, formatadorHora);
				horaCorreta=true;
			} catch (Exception e) {
				System.out.println("ERRO! Insira a hora no formato correto!");
			}
		}
	}
}
