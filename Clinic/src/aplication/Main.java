package aplication;

import javax.swing.JOptionPane;
import entityEmployee.Doctor;
import entityEmployee.Secretary;
import appointment.Appointment;

public class Main {

	public static void main(String[] args) {
		int log=0, ntype=0, ltype=0, logVerificador=0;
		String login="", senha="", type="", nome="", admissao="", nasc="", crm="", espc="";
		MainMethods meth = new MainMethods();
		Doctor[] doctors = new Doctor[10];
		Secretary[] secretary = new Secretary[2];
		Appointment[] consultas = new Appointment[30];
		
		JOptionPane.showMessageDialog(null, "Seja bem vindo ao sitema de consultório médico!\n"
				+ "Limites do sistema:\n"
				+ "- Inscrição de 10 médicos\n"
				+ "- Inscrição de 2 secretários\n"
				+ "- Realização de 30 consultas");
		
		do {
			log = Integer.parseInt(JOptionPane.showInputDialog(null, "Realize o seu login! \n"
					+ "1. Login\n"
					+ "2. Inscrever"));
			switch (log) {
			case 1:
				ltype = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o tipo de usuário: (1-Médico - 2-Secretário) "));
				if(ltype == 1 ) {
					if(meth.contagemArrayDoc(doctors) == 0) {
						JOptionPane.showMessageDialog(null, "Ainda não existem médicos cadastrados no sistema!");
						break;
					}else {
						while(logVerificador != -1) {
							login = JOptionPane.showInputDialog(null, "Login: ");
							senha = JOptionPane.showInputDialog(null, "Senha: ");
							if(meth.existLogDoc(doctors, login, senha)) {
								logVerificador = -1;
								log = -1;
							}else {
								int prosseguir = Integer.parseInt(JOptionPane.showInputDialog(null, "Login ou senha erradas!\n"
										+ "- Deseja voltar? digite 1\n"
										+ "- Deseja prosseguir? digite qualquer número com excessão do número 1"));
								if(prosseguir == 1) {
									break;
								}
							}	
						}
						break;
					}
				}else if(ltype == 2) {
					if(meth.contagemArraySec(secretary) == 0) {
						JOptionPane.showMessageDialog(null, "Ainda não existem secretários cadastrados no sistema!");
						break;
					}else {
						
					}
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Você não inseriu um valor válido!");
				}
				break;
			case 2:
				ntype = Integer.parseInt(JOptionPane.showInputDialog(null, "Tipo de usuário: (1-Médico - 2-Secretário) "));
				nome = JOptionPane.showInputDialog(null, "Nome: ");
				nasc = JOptionPane.showInputDialog(null, "Data de Nascimento: (dd/mm/aa)");
				admissao = JOptionPane.showInputDialog(null, "Data de Admissão: (dd/mm/aa)");
				if(ntype == 1) {
					crm = JOptionPane.showInputDialog(null, "CRM: ");
					espc = JOptionPane.showInputDialog(null, "Especialidade: ");
					login = JOptionPane.showInputDialog(null, "Login: ");
					senha = JOptionPane.showInputDialog(null, "Senha: ");
					
					Doctor d = new Doctor(login, senha, nome, admissao, nasc, crm, espc);
					doctors[meth.contagemArrayDoc(doctors)] = d;
				}else {
					login = JOptionPane.showInputDialog(null, "Login: ");
					senha = JOptionPane.showInputDialog(null, "Senha: ");
					
					Secretary s = new Secretary(login, senha, nome, admissao, nasc);
					secretary[meth.contagemArraySec(secretary)] = s;
				}
				
				break;
			default:
				break;
			}
		} while(log != -1);

	}

}
