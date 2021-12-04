package aplication;

import entitys.Doctor;
import entitys.Secretary;
import entitys.Pacient;
import appointment.Appointment;

public class MainMethods {
	
	
	public int contagemArrayDoc(Doctor[] array) {
		int counter = 0;
		for (int i = 0; i < array.length; i ++)
		    if (array[i] != null)
		        counter ++;
		return counter;
	}
	
	public int contagemArraySec(Secretary[] array) {
		int counter = 0;
		for (int i = 0; i < array.length; i ++)
		    if (array[i] != null)
		        counter ++;
		return counter;
	}
	
	public int contagemArrayPac(Pacient[] array) {
		int counter = 0;
		for (int i = 0; i < array.length; i ++)
		    if (array[i] != null)
		        counter ++;
		return counter;
	}
	
	public int contagemArrayCons(Appointment[] array) {
		int counter = 0;
		for (int i = 0; i < array.length; i ++)
		    if (array[i] != null)
		        counter ++;
		return counter;
	}
	
	public boolean existLogDoc (Doctor[] doctors, String log, String password) {
		for(int i=0; i<contagemArrayDoc(doctors); i++) {
			if(doctors[i] != null && doctors[i].getLogin().equals(log) && doctors[i].getSenha().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existJustLogDoc (Doctor[] doctors, String log) {
		for(int i=0; i<contagemArrayDoc(doctors); i++) {
			if(doctors[i] != null && doctors[i].getLogin().equals(log)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existLogSec (Secretary[] secretary, String log, String password) {
		for(int i=0; i<contagemArraySec(secretary); i++) {
			if(secretary[i] != null && secretary[i].getLogin().equals(log) && secretary[i].getSenha().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existJustLogSec (Secretary[] secretary, String log) {
		for(int i=0; i<contagemArraySec(secretary); i++) {
			if(secretary[i] != null && secretary[i].getLogin().equals(log)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existPacCpf (Pacient[] pacients, String cpf) {
		for(int i=0; i<contagemArrayPac(pacients); i++) {
			if(pacients[i] != null && pacients[i].getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
	
	public int getNumDoc(Doctor[] doctors, String log) {
		int number = -1;
		for (int i = 0; i<contagemArrayDoc(doctors); i ++) {
		    if (doctors[i].getLogin() != null && doctors[i].getLogin().equals(log)) {
		        number = i;
		    }
		}
		return number;
	}
	
	public int getNumSec(Secretary[] secretarys, String log) {
		int number = -1;
		if(existJustLogSec(secretarys, log)) {
			for (int i = 0; i<contagemArraySec(secretarys); i ++) {
			    if (secretarys[i].getLogin() != null && secretarys[i].getLogin().equals(log)) {
			        number = i;
			    }
			}
		}
		return number;
	}
	
	public int getNumPac (Pacient[] pacients, String cpf) {
		int number = -1;
		for (int i = 0; i <contagemArrayPac(pacients); i ++) {
		    if (pacients[i].getCpf() != null && pacients[i].getCpf() == cpf) {
		        number = i;
		    }
		}
		return number;
	}
	
	
	public String returnAllDoc (Doctor[] doctors){
		String resultado = "";
		if(contagemArrayDoc(doctors) > 0) {
			for(int i = 0; i<contagemArrayDoc(doctors); i++) {
				if(doctors[i] != null) {
					resultado += "Dados do "+(i+1)+"º Médico: \n"
							+ "1. Nome: "+doctors[i].getNome()+"\n"
							+ "2. Especialidade: "+doctors[i].getEspecialidade()+"\n"
							+ "3. Data de admissão: "+doctors[i].getAdmissao()+"\n\n";
				}
			} 
		}else {
			resultado = "Não existem médicos!";
		}
		return resultado;
	}
	
	public String returnAgenda(Appointment[] array) {
		String result = "";
		for (int i = 0; i<contagemArrayCons(array); i++) {
			if(array[i] != null) {
				result += "Dados da "+(i+1)+"ª consulta: \n"
						+ "- Data: "+array[i].getData()+"\n"
						+ "- Médico: "+array[i].getMedico().getNome()+"\n"
						+ "- Paciente: "+array[i].getPacient().getNome()+"\n\n";
			}
		}
		return result;
	}
	
	public String returnAgendaDoc(Appointment[] consultas, String login) {
		int j=1;
		String result = "Consultas marcadas para o médico "+login+": \n\n";
		for (int i = 0; i<contagemArrayCons(consultas); i++) {
			if(consultas[i].getMedico().getLogin().equals(login)) {
				result += "Dados da "+j+"ª consulta: \n"
						+ "- Data: "+consultas[i].getData()+"\n"
						+ "- Paciente: "+consultas[i].getPacient().getNome()+"\n"
						+ "- Valor: "+consultas[i].getValor()+"\n"
						+ "- Consulta marcada por: "+consultas[i].getSecretaria().getNome()+"\n\n";
				j++;
			}
		}
		return result;
	}
	
	public boolean existConsToDoc(Appointment[] consultas, String logDoctor) {
		for (int i = 0; i<contagemArrayCons(consultas); i++) {
			if(consultas[i].getMedico().getLogin() == logDoctor) {
				return true;
			}
		}
		return false;
	}
	
	public boolean removerCons(Appointment[] consultas, int nCons, String logDoc) {
		int nConsDoc = 0;
		for(int i=0; i<contagemArrayCons(consultas); i++) {
			if(consultas[i].getMedico().getLogin().equals(logDoc)) {
				nConsDoc++;
				if(nCons == nConsDoc) {
					//Se a consulta foi realizada pelo médico, a data da consulta receberá o valor "realizada"
					consultas[i].setData("REALIZADA");
				}
			}
		}
		if(nConsDoc == 0) {
			return false;
		}
		return true;
	}
	
	public boolean realocarCons(Appointment[] consultas) {
		//Retirará do vetor a consulta que tiver a data setada como "realizada"
		for(int i=0; i<consultas.length-1; i++) {
			if(consultas[i] != null && consultas[i].getData() == "REALIZADA") {
				consultas[i] = consultas[i+1];
				for(int j = i+1; j<consultas.length-1; j++) {
					consultas[j] = consultas[j+1];
				}
				if(consultas[consultas.length-1] == consultas[consultas.length-2]) {
					consultas[consultas.length-1] = null;
				}
			}
		}
		return true;
	}
}
