package application;

import java.util.Scanner;
import dao.*;
import model.*;

public class Principal {
	
	public static int menu() {
		int option = -1;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("GERENCIADOR DE USUARIOS");
			System.out.println("1 - Inserir");
			System.out.println("2 - Listar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Deletar");
			System.out.println("0 - Sair");
			option = sc.nextInt();
		} while(option < 0 || option > 4);
		sc.close();
		return option;
	}
	
	public static void inserir(UsuarioDAO userDao) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Codigo: ");
		int codigo = sc.nextInt();
		System.out.print("Login: ");
		String login = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		System.out.print("Sexo: ");
		char sexo = sc.nextLine().charAt(0);
		Usuario usuario = new Usuario(codigo, login, senha, sexo);
		if(userDao.insertUsuario(usuario)) {
			System.out.println("Novo usuario inserido com sucesso! " + usuario.toString());
		} 
		sc.close();
	}
	
	public static void listar(UsuarioDAO userDao) {
		Usuario[] usuarios = userDao.getUsuarios();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
	}
	
	public static void atualizar(UsuarioDAO userDao) {
		int option;
		Scanner sc = new Scanner(System.in);		
		System.out.println("Digite o codigo do usuario a ser atualizado: ");
		Usuario usuario = userDao.getUsuariosById(sc.nextInt());
		System.out.println("O que deseja atualizar?");
		do {
			System.out.println("1 - Login\n2 - Senha\n3 - Sexo\nOPCAO: ");
			option = sc.nextInt();
		} while(option < 1 || option > 3);
		/*switch(option) {
			case 1:
				System
		}*/
	}
	
	
	public static void main(String args[]) {
		
		DAO dao = new DAO();
		UsuarioDAO userDao = new UsuarioDAO();
		dao.conectar();
		int option = menu();
		switch(option) {
			case 1:
				inserir(userDao);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				break;
			default:
				break;
		}
	}
}
