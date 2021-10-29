package oracleExercises;

import java.util.Scanner;

public class convertLitro {

	public static void main(String[] args) {
		int qtdGal=0;
		double qtdLit=0.0;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Bem vindo ao sistema que converterá a quantidade de aguá em galões para litros!");
		System.out.print("Digite a sua quantidade de galões: ");
		qtdGal = s.nextInt();
		
		qtdLit = qtdGal*3.785;
		
		System.out.println(qtdGal+" galões são equivalentes a "+qtdLit+" litros!");
		
		s.close();

	}

}
