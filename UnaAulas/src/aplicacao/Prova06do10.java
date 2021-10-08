package aplicacoes;

import java.util.Scanner;

public class Prova06do10 {

	public static void main(String[] args) {
		//declaração dos vetores
		int count[] = new int[3];
		String interv[] = new String[3];
		//declaração das variáveis restantes
		int i=0;
		double temp=0.0, med=0.0, soma=0.0;
		String tempDesf="";
		Scanner s = new Scanner(System.in);
		//inicio do programa
		System.out.println("Seja bem vindo ao programa da prova de 06/10/2021!");
		System.out.println("\n--------------------------------------------------\n");
		do {
			i++;
			System.out.print("Digite o "+i+"º valor de temperatura em °C: ");
			//leitura e tratamento das temperaturas dentro do vetor
			tempDesf = s.nextLine();
			temp = Double.parseDouble(tempDesf.replace(',', '.'));
			soma += temp;
			//condições para definir o resultado
			if(temp<18) {
				if(interv[0] == null) {
					interv[0] = temp+"°C";
				}else {
					interv[0] += "; "+temp+"°C";
				}
				count[0]++;
			}else if(temp>=18 && temp<=30) {
				if(interv[1] == null) {
					interv[1] = temp+"°C";
				}else {
					interv[1] += "; "+temp;
				}
				count[1]++;
			}else if(temp>30) {
				if(interv[2] == null) {
					interv[2] = temp+"°C";
				}else {
					interv[2] += "; "+temp;
				}
				count[2]++;
			}
		}while(i < 10);
		//tratamento de dados se caso alguma condição não possuir preenchimento
		if(interv[0] == null) {
			interv[0] = "n/a";
		}
		if(interv[1] == null) {
			interv[1] = "n/a";
		}
		if(interv[2] == null) {
			interv[2] = "n/a";
		}
		//tratamento de dados para as convenções brasileiras
		interv[0].replace(',', '.');
		interv[1].replace(',', '.');
		interv[2].replace(',', '.');
		
		med = soma/10;
		//resultados
		System.out.println("\n--------------------------------------------------");
		System.out.println("\nResultados:");
		System.out.println("\n- Quantidade de temperaturas menores do que 18°C: "+count[0]+" ("+interv[0]+")");
		System.out.println("- Quantidade de temperaturas entre 18°C e 30C: "+count[1]+" ("+interv[1]+")");
		System.out.println("- Quantidade de temperaturas maiores do que 30°C: "+count[2]+" ("+interv[2]+")");
		//System.out.printf("- Média das temperaturas: %.2f°C\n",med);
		s.close();
	}

}
