package ti2;

import java.util.*;

class Sum {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		int valueA, valueB, result;
	
		System.out.print("Insira o primeiro valor: ");
		valueA = sc.nextInt();
		System.out.print("Insira o segundo valor: ");
		valueB = sc.nextInt();
		
		result = valueA + valueB;
		System.out.println("A soma de " + valueA +
		" mais "+ valueB + " é igual a " + result + ".");
	}
}
