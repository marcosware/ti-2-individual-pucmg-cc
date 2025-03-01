package application;

import java.util.Scanner;
import dao.*;
import model.*;

public class Principal {
	public static Scanner sc = new Scanner(System.in);
	
	public static int menu() {
		int option = -1;
		do {
			System.out.println("GERENCIADOR DE USUARIOS");
			System.out.println("1 - Inserir");
			System.out.println("2 - Listar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Deletar");
			System.out.println("0 - Sair");
			System.out.print("OPÇÃO: ");
			option = sc.nextInt();
		} while(option < 0 || option > 4);
		return option;
	}
	
	public static void inserir(UsuarioDAO userDao) {
		System.out.print("Codigo: ");
		int codigo = sc.nextInt();
		System.out.print("Login: ");
		sc.nextLine();
		String login = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		System.out.print("Sexo: ");
		char sexo = sc.nextLine().charAt(0);
		Usuario usuario = new Usuario(codigo, login, senha, sexo);
		if(userDao.insertUsuario(usuario)) {
			System.out.println("Novo usuario inserido com sucesso! " + usuario.toString());
		} 
	}
	
	public static void listar(UsuarioDAO userDao) {
		Usuario[] usuarios = userDao.getUsuarios();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
	}
	
	public static void atualizar(UsuarioDAO userDao) {
		int option;		
		System.out.print("Digite o codigo do usuario a ser atualizado: ");
		Usuario usuario = userDao.getUsuarioById(sc.nextInt());
		System.out.println("O que deseja atualizar?");
		do {
			System.out.print("1 - Login\n2 - Senha\n3 - Sexo\nOPÇÃO: ");
			option = sc.nextInt();
			sc.nextLine();
		} while(option < 1 || option > 3);
		switch(option) {
			case 1:
				System.out.print("Digite o novo login: ");
				usuario.setLogin(sc.nextLine());
				break;
			case 2:
				System.out.print("Digite a nova senha: ");
				usuario.setSenha(sc.nextLine());
				break;
			case 3:
				System.out.print("Digite o novo sexo: " );
				usuario.setSexo(sc.nextLine().charAt(0));
				break;
		}
		userDao.updateUsuario(usuario);
	}
	
	public static void deletar(UsuarioDAO userDao) {
		System.out.print("Digite o codigo do usuario a ser deletado: ");
		Usuario usuario = userDao.getUsuarioById(sc.nextInt());
		userDao.deleteUsuario(usuario.getCodigo());
	}
	
	
	public static void main(String args[]) {
		DAO dao = new DAO();
		UsuarioDAO userDao = new UsuarioDAO();
		dao.conectar();
		int option = -1;
		do {
			option = menu();
			switch(option) {
				case 1:
					inserir(userDao);
					break;
				case 2:
					listar(userDao);
					break;
				case 3:
					atualizar(userDao);
					break;
				case 4:
					deletar(userDao);
					break;
				case 0:
					System.out.println("\nEncerrando...");
					break;
			}
		} while(option != 0);
		sc.close();
	}
}
