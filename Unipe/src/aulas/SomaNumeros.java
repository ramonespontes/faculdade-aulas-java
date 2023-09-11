package aulas;

import java.util.Scanner;

public class SomaNumeros {

	public static void main(String[] args) {
		
		int num1, num2, resultado=0;
		
		Scanner x = new Scanner(System.in);

		System.out.println("Digite um número: ");

		num1 = x.nextInt();

		System.out.println("Digite um segundo número: ");

		num2 = x.nextInt();
		
		resultado = num1+num2;
		
		System.out.println("A soma é : " + resultado);

	}

}
