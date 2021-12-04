package aplication;

import javax.swing.JOptionPane;

import appointment.Appointment;
import entitys.Doctor;
import entitys.Secretary;
import entitys.Pacient;

public class Main {

	public static void main(String[] args) {
		int log=0, ntype=0, ltype=0, logVerificador=0, men=0, op=0, numAtribuicao=0, numPac=0, opSair=0, tryconfer=0;
		double valor=0;
		String login="", senha="", type="", nome="", admissao="", nasc="", crm="", espc="", dataNasc="", cpfPac="", dataCons="";
		boolean pacCadas=false, logDisp=false;
		MainMethods meth = new MainMethods();
		Doctor[] doctors = new Doctor[10];
		Secretary[] secretary = new Secretary[2];
		Pacient[] pacients = new Pacient[30];
		Appointment[] consultas = new Appointment[30];
		
		JOptionPane.showMessageDialog(null, "Seja bem vindo ao sitema de consultório médico!\n\n"
				+ " • Limites do sistema:\n"
				+ " - Inscrição de 10 médicos\n"
				+ " - Inscrição de 2 secretários\n"
				+ " - Inscrição de 30 pacientes\n"
				+ " - Realização de 30 consultas", "Tela de boas vindas", JOptionPane.PLAIN_MESSAGE);
		
		do {
			logVerificador = 0;
			try {
				log = Integer.parseInt(JOptionPane.showInputDialog(null, "Realize o seu login! \n"
						+ "1. Login\n"
						+ "2. Inscrever\n"
						+ "3. Sair", "Tela de login", JOptionPane.PLAIN_MESSAGE));
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
				log=0;
			}
			switch (log) {
			case 0:
				System.out.println("entrou");
				break;
			case 1:
				tryconfer = 0;
				while(tryconfer != 1) {
					try {
						ltype = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o tipo de usuário: (1-Médico / 2-Secretário) ", "Tipo de login", JOptionPane.PLAIN_MESSAGE));
						tryconfer = 1;
					}catch(Exception e) {
						ltype=0;
						JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
						tryconfer = 0;
					}
				}
				if(ltype == 1 ) {
					if(meth.contagemArrayDoc(doctors) == 0) {
						JOptionPane.showMessageDialog(null, "Ainda não existem médicos cadastrados no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
						break;
					} else {
						logVerificador = 0;
						while(logVerificador != -1) {
							try {
								login = JOptionPane.showInputDialog(null, "Login: ", "Login", JOptionPane.PLAIN_MESSAGE);
								senha = JOptionPane.showInputDialog(null, "Senha: ", "Login", JOptionPane.PLAIN_MESSAGE);
							}catch(Exception e){
								login="";
								senha="";
								JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
							if(login != "" && senha != "" && meth.existLogDoc(doctors, login, senha)) {
								logVerificador = -1;
								JOptionPane.showMessageDialog(null, "Login executado com sucesso!", "Login bem sucedido", JOptionPane.INFORMATION_MESSAGE);
							}else {
								try {
									int prosseguir = Integer.parseInt(JOptionPane.showInputDialog(null, "Login ou senha erradas!\n"
											+ "- Digite 1 para voltar para o início \n"
											+ "- Digite outro caractere com excessão de '1' para \n"
											+ "tentar o login novamente","Login mal sucedido", JOptionPane.ERROR_MESSAGE));
									if(prosseguir == 1) {
										break;
									}
								}catch(Exception e) {}
							}	
						}
						break;
					}
				} else if(ltype == 2) {
					if(meth.contagemArraySec(secretary) == 0) {
						JOptionPane.showMessageDialog(null, "Ainda não existem secretários cadastrados no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
						break;
					}else {
						logVerificador = 0;
						while(logVerificador != -1) {
							login = JOptionPane.showInputDialog(null, "Login: ", "Login", JOptionPane.PLAIN_MESSAGE);
							senha = JOptionPane.showInputDialog(null, "Senha: ", "senha", JOptionPane.PLAIN_MESSAGE);
							if(login != "" && senha != "" && meth.existLogSec(secretary, login, senha)) {
								logVerificador = -1;
								JOptionPane.showMessageDialog(null, "Login executado com sucesso!", "Login bem sucedido", JOptionPane.INFORMATION_MESSAGE);
							}else {
								try {
									int prosseguir = Integer.parseInt(JOptionPane.showInputDialog(null, "Login ou senha erradas!\n"
											+ "- Digite 1 para voltar para o início \n"
											+ "- Digite outro caractere com excessão de '1' para \n"
											+ "tentar o login novamente","Login mal sucedido", JOptionPane.ERROR_MESSAGE));
									if(prosseguir == 1) {
										break;
									}
								}catch(Exception e) {}
							}	
						}
						break;
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Você não inseriu um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
				}
			case 2:
				try {
					ntype = Integer.parseInt(JOptionPane.showInputDialog(null, "Tipo de usuário: (1-Médico / 2-Secretário) ", "Cadastro", JOptionPane.PLAIN_MESSAGE));
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Você não inseriu um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
					ntype = 0;
				}
				if(ntype != 0 && (ntype == 1 || ntype == 2)) {
					nome = "";
					while (nome.equals("")) {
						nome = JOptionPane.showInputDialog(null, "Nome: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
						if(nome.equals("")) {
							JOptionPane.showMessageDialog(null, "Você não inseriu um valor para o nome!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					nasc="";
					while(nasc.equals("")) {
						nasc = JOptionPane.showInputDialog(null, "Data de Nascimento: (dd/mm/aa)", "Cadastro", JOptionPane.PLAIN_MESSAGE);
						if(nasc.equals("")) {
							JOptionPane.showMessageDialog(null, "Você não inseriu um valor para a data de nascimento!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					admissao = "";
					while(admissao.equals("")) {
						admissao = JOptionPane.showInputDialog(null, "Data de Admissão: (dd/mm/aa)", "Cadastro", JOptionPane.PLAIN_MESSAGE);
						if(admissao.equals("")) {
							JOptionPane.showMessageDialog(null, "Você não inseriu um valor para a data de admissão!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					if(ntype == 1) {
						crm = "";
						while(crm.equals("")) {
							crm = JOptionPane.showInputDialog(null, "CRM: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
							if(crm.equals("")) {
								JOptionPane.showMessageDialog(null, "Você não inseriu um valor para o crm!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}
						espc="";
						while(espc.equals("")) {
							espc = JOptionPane.showInputDialog(null, "Especialidade: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
							if(espc.equals("")) {
								JOptionPane.showMessageDialog(null, "Você não inseriu um valor para a especialidade!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}
						logDisp = false;
						while(logDisp == false) {
							login = JOptionPane.showInputDialog(null, "Login: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
							logDisp = !meth.existJustLogDoc(doctors, login); 
							if(!logDisp || login.equals("")) {
								logDisp = false;
								JOptionPane.showMessageDialog(null, "Este login não está disponível para cadastro, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}	
						senha="";
						while(senha.equals("")) {
							senha = JOptionPane.showInputDialog(null, "Senha: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
							if(senha.equals("")) {
								JOptionPane.showMessageDialog(null, "Você não inseriu um valor para a senha!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}
						
						Doctor d = new Doctor(login, senha, nome, admissao, nasc, crm, espc);
						doctors[meth.contagemArrayDoc(doctors)] = d;
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
					}else if(ntype == 2){
						logDisp = false;
						while(logDisp == false) {
							login = JOptionPane.showInputDialog(null, "Login: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
							logDisp = !meth.existJustLogSec(secretary, login); 
							if(!logDisp || login.equals("")) {
								logDisp = false;
								JOptionPane.showMessageDialog(null, "Este login não está disponível para cadastro, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}	
						senha="";
						while(senha.equals("")) {
							senha = JOptionPane.showInputDialog(null, "Senha: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
							if(senha.equals("")) {
								JOptionPane.showMessageDialog(null, "Você não inseriu um valor para a senha!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}
						Secretary s = new Secretary(login, senha, nome, admissao, nasc);
						secretary[meth.contagemArraySec(secretary)] = s;
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
					}
				}else {
					if(ntype > 0) {
						JOptionPane.showMessageDialog(null, "Você não inseriu um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				break;
			case 3:
				log = -1;
				JOptionPane.showMessageDialog(null, "Saindo...", "Exit", JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				if(log>3 || log<-1) {
					JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				break;
			}//Fim do switch do login
			
			if(logVerificador == -1) {
				//Inicio da execução dos processos de fato
				do {
					op=0;
					
					if(ltype == 1) {
						tryconfer = 0;
						while(tryconfer != 2) {
							try {
								op = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha sua opção:\n"
										+ "1- Realizar atendimento\n"
										+ "2- Verificar sua agenda\n"
										+ "3- Sair", "Menu de opções", JOptionPane.PLAIN_MESSAGE));
								tryconfer = 2;
							}catch(Exception e) {
								tryconfer = 0;
								JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
								op = 0;
							}
						}
						
						switch(op) {
						case 1:
							if(meth.existConsToDoc(consultas, login)) {
								tryconfer = 0;
								while(tryconfer != 3) {
									try {
										numAtribuicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique o número da consulta que irá realizar:\n\n"
												+ meth.returnAgendaDoc(consultas, login), "Realizar atendimento!", JOptionPane.PLAIN_MESSAGE));
										if(numAtribuicao > meth.qtdConsToDoc(consultas, login) || numAtribuicao <= 0) {
											JOptionPane.showMessageDialog(null, "Número de consulta inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
											tryconfer = 3;
										}else {
											meth.removerCons(consultas, numAtribuicao, login);
											meth.realocarCons(consultas);
											JOptionPane.showMessageDialog(null, "Consulta removida do sistema!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
											tryconfer = 3;
										}
									}catch(Exception e) {
										JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
										tryconfer = 0;
									}
								}
							}else{
								JOptionPane.showMessageDialog(null, "Não existem consultas marcadas para o médico '"+doctors[meth.getNumDoc(doctors, login)].getNome()+"' no sistema!", "Erro", JOptionPane.PLAIN_MESSAGE);
							}
							
							break;
						case 2:
							if(meth.existConsToDoc(consultas, login)) {
								JOptionPane.showMessageDialog(null, meth.returnAgendaDoc(consultas, login), "Verificação de agenda", JOptionPane.PLAIN_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Não existem consultas marcadas para o médico '"+doctors[meth.getNumDoc(doctors, login)].getNome()+"' no sistema!", "Erro", JOptionPane.PLAIN_MESSAGE);
							}
							break;
						case 3:
							try {
								opSair = Integer.parseInt(JOptionPane.showInputDialog(null, "Como você deseja sair?\n"
										+ "1 - Voltar para o login/cadastro\n"
										+ "2 - Sair do sistema\n"
										+ "3 - Voltar para o menu de opções", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE));
							}catch(Exception e) {
								JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
								opSair = 3;
							}
							
							if(opSair == 1) {
								men = -1;
							}else if(opSair == 2) {
								men = -1;
								log = -1;
								JOptionPane.showMessageDialog(null, "Saindo...", "Exit", JOptionPane.INFORMATION_MESSAGE);
							}else if(opSair != 3){
								JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
							
							break;
						default:
							if(op>3 || op<0){
								JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
							break;
						
						}
					}else if(ltype==2){
						tryconfer = 0;
						while(tryconfer != 4) {
							try {
								op = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha sua opção:\n"
										+ "1- Agendar consulta\n"
										+ "2- Verificar agenda\n"
										+ "3- Verificar médicos cadastrados\n"
										+ "4- Sair", "Menu de opções", JOptionPane.PLAIN_MESSAGE));
								tryconfer = 4;
							}catch(Exception e) {
								tryconfer = 0;
								JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
								op = 0;
							}
						}
						
						switch(op) {
						case 1:
							if(meth.contagemArrayDoc(doctors) > 0) {
								cpfPac="";
								while(cpfPac.equals("")){
									cpfPac = JOptionPane.showInputDialog(null, "Informe o cpf do clinte para a consulta: ", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
									if(cpfPac.equals("")) {
										JOptionPane.showMessageDialog(null, "Você não inseriu um cpf!", "Erro", JOptionPane.ERROR_MESSAGE);
									}
								}
								
								if(!(meth.existPacCpf(pacients, cpfPac)) || pacients.length == 0) {
									JOptionPane.showMessageDialog(null, "Não existe nenhum paciente cadastrado no sistema com esse cpf, "
											+ "portanto você o cadastrará agora!", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
									
									nome = "";
									while(nome.equals("")) {
										nome = JOptionPane.showInputDialog(null, "Indique o nome do paciente para a consulta:", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
										if(nome.equals("")) {
											JOptionPane.showMessageDialog(null, "Você não inseriu um nome!", "Erro", JOptionPane.ERROR_MESSAGE);
										}
									}
									
									dataNasc = "";
									while(dataNasc.equals("")) {
										dataNasc = JOptionPane.showInputDialog(null, "Indique a data de nascimento do paciente para a consulta:", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
										if(dataNasc.equals("")) {
											JOptionPane.showMessageDialog(null, "Você não inseriu uma data de nascimento!", "Erro", JOptionPane.ERROR_MESSAGE);
										}
									}
									
									Pacient p = new Pacient(nome, cpfPac, dataNasc);
									pacients[meth.contagemArrayPac(pacients)] = p;
									pacCadas = true;
									numPac = meth.contagemArrayPac(pacients)-1;
									JOptionPane.showMessageDialog(null, "Paciente cadastrado!", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "Esse cliente já está cadastrado no sistema! Portanto, não será necessário informar"
											+ " novamente seus dados", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
								}
								
								dataCons = "";
								while(dataCons.equals("")) {
									dataCons = JOptionPane.showInputDialog(null, "Indique a data que a consulta será realizada:", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
									if(dataCons.equals("")) {
										JOptionPane.showMessageDialog(null, "Você não inseriu uma data para a consulta!", "Erro", JOptionPane.ERROR_MESSAGE);
									}
								}
								
								tryconfer = 0;
								while(tryconfer != 5) {
									try {
										numAtribuicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique o médico que irá realizar a consulta:\n\n"
												+ meth.returnAllDoc(doctors), "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE));
										tryconfer = 5;
										if(numAtribuicao > meth.contagemArrayDoc(doctors) || numAtribuicao <= 0) {
											JOptionPane.showMessageDialog(null, "Identificador de médico inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
											tryconfer = 0;
										}
									}catch(Exception e) {
										JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
										tryconfer = 0;
									}
								}
								
								tryconfer = 0;
								while(tryconfer != 6) {
									try {
										valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Indique o valor dessa consulta: ", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE));
										tryconfer = 6;
										if(valor < 0) {
											JOptionPane.showMessageDialog(null, "Valor de consulta inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
											tryconfer = 0;
										}
									}catch(Exception e) {
										JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
										tryconfer = 0;
									}
								}
								
								if(!pacCadas) {
									numPac = meth.getNumPac(pacients, cpfPac);
								}
								try {
									Appointment apt = new Appointment(doctors[numAtribuicao-1], secretary[meth.getNumSec(secretary, login)], dataCons, pacients[numPac], valor);
									consultas[meth.contagemArrayCons(consultas)] = apt;
									JOptionPane.showMessageDialog(null, "Consulta Agendada no sistema!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
								} catch(Exception e) {
									JOptionPane.showMessageDialog(null, "Erro ao agendar consulta no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
								}
								
							}else if(meth.contagemArrayDoc(doctors) == 0){
								JOptionPane.showMessageDialog(null, "Não existem médicos cadastrados no sistema para isso!", "Erro", JOptionPane.ERROR_MESSAGE);
								break;
							}
							break;
						case 2:
							if(meth.contagemArrayCons(consultas)>0) {
								JOptionPane.showMessageDialog(null, meth.returnAgenda(consultas), "Agenda", JOptionPane.PLAIN_MESSAGE);
							}else if(meth.contagemArrayCons(consultas)==0){
								JOptionPane.showMessageDialog(null, "Não existem consultas agendadas para os próximos dias!", "Agenda", JOptionPane.PLAIN_MESSAGE);
							}
							
							break;
						case 3:
							if(meth.contagemArrayDoc(doctors)>0) {
								JOptionPane.showMessageDialog(null, meth.returnAllDoc(doctors), "Médicos", JOptionPane.PLAIN_MESSAGE);
							}else if(meth.contagemArrayDoc(doctors)==0){
								JOptionPane.showMessageDialog(null, "Ainda não existem médicos cadastrados no sistema!", "Médicos", JOptionPane.ERROR_MESSAGE);
							}
							break;
						case 4:
							try {
								opSair = Integer.parseInt(JOptionPane.showInputDialog(null, "Como você deseja sair?\n"
										+ "1 - Voltar para o login/cadastro\n"
										+ "2 - Sair do sistema\n"
										+ "3 - Voltar para o menu de opções", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE));
							}catch(Exception e) {
								JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
								opSair = 3;
							}
							
							if(opSair == 1) {
								men = -1;
							}else if(opSair == 2) {
								men = -1;
								log = -1;
								JOptionPane.showMessageDialog(null, "Saindo...", "Exit", JOptionPane.INFORMATION_MESSAGE);
							}else if(opSair != 3){
								JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
							
							break;
						default:
							if(op>4 || op<0){
								JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
							break;
						}
					}else {
						JOptionPane.showInputDialog(null, "Erro!","ERRO", JOptionPane.ERROR_MESSAGE);
					}
					
				} while(men != -1);
				men = 0;
			}
			
		} while(log != -1);
		
		

	}

}
