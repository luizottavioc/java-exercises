package aplicacao;

import javax.swing.JOptionPane;

public class PairWithFOR {

	public static void main(String[] args) {
		int val1 =0, val2=0, dif=0, cont=0;
		String valores = "";
		JOptionPane.showMessageDialog(null,"Bem vindo ao Programa que te informará todos os números pares presentes entre dois números! ");
		JOptionPane.showMessageDialog(null,"- Você só pode inputar números inteiros!\n- Você só receberá o resultado se os valores inputados\n tiverem no máximo 100 números inteiros de distância!");
		val1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o primeiro número: "));
		val2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o segundo número: "));
		dif = val2 - val1;
		if(dif>100) {
			JOptionPane.showMessageDialog(null,"A diferença entre os números é maior do que 100!");
			System.exit(0);
		}else if(dif<0) {
			JOptionPane.showMessageDialog(null,"Input negativo de dados!");
			System.exit(0);
		}else if(dif==0) {
			JOptionPane.showMessageDialog(null,"Os números informados são iguais!");
			System.exit(0);
		}
		else {
			for(int i=val1; i<=val2; i++) {
				 if(i % 2 == 0) {
					 cont += 1;
					 if(valores == "") {
						 valores = String.valueOf(i);
					 }else if(cont == 20){
						 valores = valores+",\n"+String.valueOf(i);
					 }else if(cont == 40){
						 valores = valores+",\n"+String.valueOf(i);
					 }else {
						 valores = valores+", "+String.valueOf(i);
					 }
				 }
			}
			JOptionPane.showMessageDialog(null,"Os números pares presentes entre "+val1+" e "+val2+" são:\n"+valores);
		}
	}
}
