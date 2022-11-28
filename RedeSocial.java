package Rede;

import java.util.Scanner;

public class RedeSocial {
	
	static Perfil [] usuarios = new Perfil[100];
	static Scanner sc = new Scanner(System.in);
	static int quantUsuarios = 0;
	static int usuarioAtual = 0;
	
	public static void main (String[] Args) {
		menuInicial();
	}
	
	public static void menuInicial(){
		String opcao;
		System.out.println("Bem-vindo(a) à Ada+! \nMENU INICIAL \n C - Cadastrar. \n E - Entrar. \n F - Fechar.\n");
		opcao = sc.nextLine().toUpperCase();
		switch(opcao) {
			case "C":
				cadastrarUsuario();
				break;
			case "E":
				entrar();
				break;
			case "F":
				System.out.println("Programa encerrado.");
				sc.close();
				break;
			default:
				System.out.println("Comando incorreto, tente novamente.");
				menuInicial();
		}
	}

	public static void cadastrarUsuario(){
		usuarios[quantUsuarios]=new Perfil();
		try {
			System.out.println("Crie um login:");
			criaLogin();
			System.out.println("Crie um nome de Usuario:");
			criaNome();
			System.out.println("Crie uma senha:");
			criaSenha();
			quantUsuarios++;
		} catch (DadoVazioException e) {
			System.out.println(e.getMessage());
		} catch (LoginIndisponivelException e) {
			System.out.println(e.getMessage());
		} finally {
			menuInicial();
		}
	}
	
	public static void criaLogin() throws LoginIndisponivelException{
		String novoLogin = sc.nextLine();
		dadoVazio(novoLogin);
		boolean usuarioExistente = buscaLogin(novoLogin);
		if(usuarioExistente) {
			throw new LoginIndisponivelException();
		} else {
			usuarios[quantUsuarios].login = novoLogin;
		}
	}
	
	public static boolean buscaLogin(String novoLogin) {
		boolean usuarioExistente = false;
		int i = 0;
		do {
			if (novoLogin.equalsIgnoreCase(usuarios[i].login)) {
				usuarioExistente = true;
				usuarioAtual = i;
				break;
			}
			i++;
		} while(i<quantUsuarios);
		return usuarioExistente;
	}
	
	public static void criaSenha() {
		String novaSenha = sc.nextLine();
		dadoVazio(novaSenha);
		usuarios[quantUsuarios].senha = novaSenha;
	}
	
	public static void criaNome() {
		String novoNome = sc.nextLine();
		dadoVazio(novoNome);
			usuarios[quantUsuarios].nome = novoNome;
	}
	
	public static void dadoVazio(String dado) throws DadoVazioException{
		if(dado.isBlank()) {
			throw new DadoVazioException();
		}
	}
	
	public static void entrar(){
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
					if (senha.equals(usuarios[usuarioAtual].senha)) {
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

	public static void menuDoUsuario() {
		System.out.println("\n" + usuarios[usuarioAtual].nome + ", Bem-vindo(a) à Ada+! \nMENU: \n 1 - Postar. \n 2 - Imprimir timeline. \n 3 - Sair. \n");
		int opcao = sc.nextInt();
		sc.nextLine();
		switch(opcao) {
			case 1:
				usuarios[usuarioAtual].novoPost();
				break;
			case 2: 
				usuarios[usuarioAtual].verTimeline();
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
