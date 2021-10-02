package aplicacao;

import javax.swing.JOptionPane;

public class NumbersBetweenWithFOR {

	public static void main(String[] args) {
		int val1 =0, val2=0, dif=0, cont=0;
		String valores = ""; 
		JOptionPane.showMessageDialog(null,"Bem vindo ao programa que te informará todos os valores inteiros presentes entre dois números! ");
		JOptionPane.showMessageDialog(null,"- Você só pode inputar números inteiros!\n- Você só receberá o resultado se os valores inputados\n tiverem no máximo 100 números inteiros de distância!");
		val1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o limite inferior: "));
		val2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o limite superior: "));
		dif = val2 - val1;
		if(dif>100) {
			JOptionPane.showMessageDialog(null,"A diferença entre os limites é maior do que 100!");
			System.exit(0);
		}else if(dif<0) {
			JOptionPane.showMessageDialog(null,"Input negativo de dados!");
			System.exit(0);
		}else if(dif==0) {
			JOptionPane.showMessageDialog(null,"Os limites informados são iguais!");
			System.exit(0);
		}
		else {
			for(int i=val1; i<=val2; i++) {
			 cont += 1;
			 if(valores == "") {
				 valores = String.valueOf(i);
			 }else if(cont == 41){
				 valores = valores+",\n"+String.valueOf(i);
			 }else if(cont == 81){
				 valores = valores+",\n"+String.valueOf(i);
			 }else {
				 valores = valores+", "+String.valueOf(i);
			 }
		 }
			}
			JOptionPane.showMessageDialog(null,"Os números presentes entre "+val1+" e "+val2+" são:\n"+valores);
		}
	}


