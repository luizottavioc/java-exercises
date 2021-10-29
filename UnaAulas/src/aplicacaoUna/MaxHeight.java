package aplicacaoUna;

import javax.swing.JOptionPane;

public class MaxHeight {

	public static void main(String[] args) {
		double altura[] = new double[10], maiorAlt=0;
		String nome[] = new String[10];
		int idAlt=0,cont=0;
		JOptionPane.showMessageDialog(null,"Bem vindo ao programa que lê a altura de 10 pessoas e informa a maior e menor entre elas!", "TELA DE BOAS VINDAS", JOptionPane.PLAIN_MESSAGE);
		for(int i=0; i<3; i++) {
			cont = i+1;
			nome[i] = JOptionPane.showInputDialog(null,"Informe o nome da "+cont+"ª pessoa: ", "INFORMAÇÃO DO USUÁRIO", JOptionPane.PLAIN_MESSAGE);
			altura[i] = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe a altura dessa "+cont+"ª pessoa: ", "INFORMAÇÃO DO USUÁRIO", JOptionPane.PLAIN_MESSAGE));
			if(altura[i]>maiorAlt) {
				idAlt = i;
			}
		}
		JOptionPane.showMessageDialog(null,"Registro da maior altura:\n- Nome: "+nome[idAlt]+"\n- Altura: "+altura[idAlt]);
	}

}
