package aplicacao;

import javax.swing.JOptionPane;

public class QuizCorrection {

	public static void main(String[] args) {
		int op = 0;
		
		char[] resposta = new char[10];
		Prova prova = new Prova();
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao programa de inserção gabarito e verificação de notas!", 
				"TELA DE BOAS VINDAS", JOptionPane.PLAIN_MESSAGE);
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(null,"Que ação você deseja realizar?\n\n"
					+ "1. Inserir gabarito\n"
					+ "2. Verificar gabarito\n"
					+ "3. Inserir respostas do aluno\n"
					+ "0. Sair","MENU DE OPÇÕES", JOptionPane.QUESTION_MESSAGE));
			switch(op) {
				case 1:
					String gabQst;
					char[] gabarito = new char[10];
					for(int i=0; i<gabarito.length; i++) {
						gabQst = JOptionPane.showInputDialog(null,"Digite o gabrito da "+(i+1)+"ª questão","DEFINIÇÃO DO GABARITO", JOptionPane.QUESTION_MESSAGE);
						gabQst = gabQst.toUpperCase();
						if(gabQst.equals("A") || gabQst.equals("B") || gabQst.equals("C") || gabQst.equals("D")) {
							gabarito[i] = gabQst.charAt(0);
						}else {
							gabQst = JOptionPane.showInputDialog(null,"Você digitou um valor de alternativa inválida para a "+(i+1)+"ª questão!\n"
									+ "Digite novamente o valor: ","INPUT DE RESPOSTA", JOptionPane.QUESTION_MESSAGE);
							gabQst = gabQst.toUpperCase();
							gabarito[i] = gabQst.charAt(0);
						}
						
					}
					prova.setGabarito(gabarito);
					JOptionPane.showMessageDialog(null,"Gabarito setado:\n"
							+prova.imprimirGab(),"GABARITO", JOptionPane.QUESTION_MESSAGE);
					break;
				case 2:
					if(!prova.existGab()) {
						JOptionPane.showMessageDialog(null,"Você ainda não definiu seu gabarito!","ERRO", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null,"Gabarito setado:\n"
							+prova.imprimirGab(),"GABARITO", JOptionPane.QUESTION_MESSAGE);
					}
					break;
				case 3:
					if(prova.existGab()) {
						String respQst;
						char[] resp = new char[10];
						for(int i=0; i<resp.length; i++) {
							respQst = JOptionPane.showInputDialog(null,"Digite a resposta da "+(i+1)+"ª questão do aluno","INPUT DE RESPOSTA", JOptionPane.QUESTION_MESSAGE);
							respQst = respQst.toUpperCase();
							
							if(respQst.equals("A") || respQst.equals("B")  || respQst.equals("C")  || respQst.equals("D") ) {
								resp[i] = respQst.charAt(0);
							}else {
								respQst = JOptionPane.showInputDialog(null,"Você digitou um valor de alternativa inválida para a "+(i+1)+"ª questão!\n"
										+ "Digite novamente o valor: ","INPUT DE RESPOSTA", JOptionPane.QUESTION_MESSAGE);
								respQst = respQst.toUpperCase();
								resp[i] = respQst.charAt(0);
							}
							
						}
						prova.setResposta(resp);
						JOptionPane.showMessageDialog(null,"As respostas do aluno foram setadas!","GABARITO DAS RESPOSTAS", JOptionPane.QUESTION_MESSAGE);
						prova.gerarPontuacao(resp, prova.getGabarito());
						JOptionPane.showMessageDialog(null,"Resultados do aluno:\n"
								+ "- Gabarito: "+prova.imprimirGab()+"\n"
								+ "- Respostas: "+prova.imprimirResp()+"\n"
								+ "- Questões acertadas: "+prova.getAcertadas()+"\n"
								+ "- Pontuação: "+prova.getPontuacao(),"TELA DE RESULTADOS", JOptionPane.QUESTION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,"Você ainda não definiu seu gabarito!","ERRO", JOptionPane.ERROR_MESSAGE);
					}
					break;
				case 0:
					JOptionPane.showMessageDialog(null,"Saindo...","TELA DE DESPEDIDA", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(null,"Valor inválido!","ERRO", JOptionPane.ERROR_MESSAGE);
					break;
			}
		} while (op != 0);
	}
}
