package aplicacao;

import javax.swing.JOptionPane;

public class ArrayVinculation {

	public static void main(String[] args) {
		double nota[] = new double[3];
		int idMaior = -1;
		int idMenor = -1;
		String nome[] = new String[3];
		String apv[] = new String[3];
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao sistema que vinculará\n"
				+ "as notas de prova com os \n"
				+ "nomes dos respectivos alunos \n"
				+ "através do uso de vetores!","TELA DE BOAS VINDAS", JOptionPane.PLAIN_MESSAGE);
		for(int i=0; i<nota.length; i++) {
			nome[i] = JOptionPane.showInputDialog(null, "Digite o nome do aluno: ","nome", JOptionPane.QUESTION_MESSAGE);
			nota[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite agora a nota do aluno "+nome[i]+": ", "Atribuição de Valores", JOptionPane.QUESTION_MESSAGE));
			
			if (i==0) {
				idMaior=i;
				idMenor=i;
			}else if(nota[i] > nota[i-1]) {
				idMaior=i;
			}else if(nota[i] < nota[i-1]) {
				idMenor=i;
			}
			
			
			if(nota[i]>=7) {
				apv[i] = "aprovado";
			} else {
				apv[i] = "reprovado";
			}
		}
		
		JOptionPane.showMessageDialog(null, "Resultados:\n\n"
				+ "- "+nome[0]+": "+nota[0]+" ("+apv[0]+")\n"
				+ "- "+nome[1]+": "+nota[1]+" ("+apv[1]+")\n"
				+ "- "+nome[2]+": "+nota[2]+" ("+apv[2]+")\n\n"
				+ "- Maior nota: "+nota[idMaior]+" ("+nome[idMaior]+")\n"
				+ "- Menor nota: "+nota[idMenor]+" ("+nome[idMenor]+")\n", 
				"Resultados Finais", JOptionPane.INFORMATION_MESSAGE);
	}

}
