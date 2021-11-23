package appointment;

import entityEmployee.Doctor;
import entityEmployee.Secretary;

public class Appointment {
	private Doctor medico;
	private Secretary secretaria;
	private String data, nomePac, idadePac;
	private double valor;
	
	public Appointment(Doctor medico, Secretary secretaria, String data, String nomePac, String idadePac, double valor) {
		this.medico = medico;
		this.secretaria = secretaria;
		this.data = data;
		this.nomePac = nomePac;
		this.idadePac = idadePac;
		this.valor = valor;
	}

	public Doctor getMedico() {
		return medico;
	}

	public void setMedico(Doctor medico) {
		this.medico = medico;
	}

	public Secretary getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretary secretaria) {
		this.secretaria = secretaria;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNomePac() {
		return nomePac;
	}

	public void setNomePac(String nomePac) {
		this.nomePac = nomePac;
	}

	public String getIdadePac() {
		return idadePac;
	}

	public void setIdadePac(String idadePac) {
		this.idadePac = idadePac;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
