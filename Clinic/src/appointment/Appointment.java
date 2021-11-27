package appointment;

import entitys.*;

public class Appointment {
	private Doctor medico;
	private Secretary secretaria;
	private String data;
	private Pacient pacient;
	private double valor;
	
	public Appointment(Doctor medico, Secretary secretaria, String data, Pacient pacient, double valor) {
		this.medico = medico;
		this.secretaria = secretaria;
		this.data = data;
		this.pacient = pacient;
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

	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	
}
