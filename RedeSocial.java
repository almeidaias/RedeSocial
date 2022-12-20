package Rede;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Rede.exceptions.DadoVazioException;
import Rede.exceptions.LoginIndisponivelException;
import Rede.exceptions.SenhaIncorretaException;
import Rede.exceptions.UsuarioNaoEncontradoException;

public class RedeSocial {
	
	private List <Perfil> usuarios;
	private int quantUsuarios;
	private int usuarioAtual;
	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] Args) {
		RedeSocial rede = new RedeSocial();
		rede.menuInicial();
	}
	
	public RedeSocial() {
		this.usuarios = new ArrayList<>();
		this.quantUsuarios = 0;
		this.usuarioAtual = 0;
	}
	
	public void menuInicial(){
		String opcao;
		System.out.println("Bem-vindo(a) à Ada+! \nMENU INICIAL \n C - Cadastrar. \n E - Entrar. \n F - Fechar.\n");
		opcao = sc.nextLine().toUpperCase();
		switch(opcao) {
			case "C":
				this.cadastrarUsuario();
				break;
			case "E":
				this.entrar();
				break;
			case "F":
				System.out.println("Programa encerrado.");
				sc.close();
				break;
			default:
				System.out.println("Comando incorreto, tente novamente.");
				this.menuInicial();
		}
	}

	public void cadastrarUsuario(){
		try {
			System.out.println("Crie um login:");
			String login = criaLogin();
			System.out.println("Crie um nome de Usuario:");
			String nome = criaNome();
			System.out.println("Crie uma senha:");
			String senha = criaSenha();
			this.usuarios.add(new Perfil(login, nome, senha));
			quantUsuarios++;
		} catch (DadoVazioException e) {
			System.out.println(e.getMessage());
		} catch (LoginIndisponivelException e) {
			System.out.println(e.getMessage());
		} finally {
			menuInicial();
		}
	}
	
	public String criaLogin() throws LoginIndisponivelException{
		String novoLogin = sc.nextLine();
		dadoVazio(novoLogin);
		boolean usuarioExistente = buscaLogin(novoLogin);
		if(usuarioExistente) {
			throw new LoginIndisponivelException();
		} else {
			return novoLogin;
		}
	}
	
	public boolean buscaLogin(String novoLogin) {
		boolean usuarioExistente = false;
		int i = 0;
		for(Perfil usuario : this.usuarios) {
			if (novoLogin.equalsIgnoreCase(usuario.getLogin())) {
				usuarioExistente = true;
				usuarioAtual = i;
				break;
			}
			i++;
		} 
		return usuarioExistente;
	}
	
	public String criaSenha() {
		String novaSenha = sc.nextLine();
		dadoVazio(novaSenha);
		return novaSenha;
	}
	
	public String criaNome() {
		String novoNome = sc.nextLine();
		dadoVazio(novoNome);
			return novoNome;
	}
	
	public void dadoVazio(String dado) throws DadoVazioException{
		if(dado.isBlank()) {
			throw new DadoVazioException();
		}
	}
	
	public void entrar(){
		if(quantUsuarios==0) {
			System.out.println("Ainda não há usuários. Crie um usuário novo.");
			menuInicial();
		}
		else {
			System.out.println("Insira o login:");
			String tentativaLogin = sc.nextLine();
			try{
				boolean usuarioExistente =buscaLogin(tentativaLogin);
				if (usuarioExistente) {
					System.out.println("Insira sua senha: ");
					String senha = sc.nextLine();
					if (this.usuarios.get(usuarioAtual).confereSenha(senha)) {
						System.out.println("\nLogin realizado com sucesso! \n");
					} else {
						throw new SenhaIncorretaException();
					}
				} else {
					throw new UsuarioNaoEncontradoException();
				}
				menuDoUsuario();
			} catch(SenhaIncorretaException e) {
				System.out.println(e.getMessage());
				menuInicial();
			} catch(UsuarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
				menuInicial();
			}
		}
	}

	public void menuDoUsuario() {
		System.out.println("\n" + this.usuarios.get(usuarioAtual).getNome() + ", Bem-vindo(a) à Ada+! \nMENU: \n 1 - Postar. \n 2 - Imprimir timeline. \n 3 - Sair. \n");
		int opcao = sc.nextInt();
		sc.nextLine();
		switch(opcao) {
			case 1:
				this.usuarios.get(usuarioAtual).novoPost();
				menuDoUsuario();
				break;
			case 2: 
				this.usuarios.get(usuarioAtual).verTimeline();
				menuDoUsuario();
				break;
			case 3: 
				System.out.println("Você será deslogado.");
				menuInicial();
				break;
			default:
				System.out.println("Comando incorreto, tente novamente.");
				menuDoUsuario();
		}
	} 
	

	
}
