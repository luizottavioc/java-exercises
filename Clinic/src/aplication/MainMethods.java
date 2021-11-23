package aplication;

import entityEmployee.Doctor;
import entityEmployee.Secretary;

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
	
	
	public boolean existLogDoc (Doctor[] doctors, String log, String password) {
		for(int i=0; i<doctors.length; i++) {
			if(doctors[i] != null) {
				if(doctors[i].getLogin().equals(log)) {
					if(doctors[i].getSenha().equals(password)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean existJustLogDoc (Doctor[] doctors, String log) {
		boolean result=false;
		for(int i=0; i<doctors.length; i++) {
			if(doctors[i] != null) {
				if(doctors[i].getLogin() == log) {
					result=true;
				}
			}
		}
		return result;
	}
	
	public boolean existLogSec (Secretary[] secretary, String log, String password) {
		for(int i=0; i<secretary.length; i++) {
			if(secretary[i] != null) {
				if(secretary[i].getLogin().equals(log)) {
					if(secretary[i].getSenha().equals(password)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean existJustLogSec (Secretary[] secretary, String log) {
		boolean result=false;
		for(int i=0; i<secretary.length; i++) {
			if(secretary[i] != null) {
				if(secretary[i].getLogin() == log) {
					result=true;
				}
			}
		}
		return result;
	}
}
