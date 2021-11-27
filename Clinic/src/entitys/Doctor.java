package entitys;

public class Doctor extends Employee {
	private String especialidade;
	private String crm;
	
	public Doctor (String login, String senha, String nome, String admissao, String nasc, String crm, String especialidade){
		super(login, senha, nome, admissao, nasc);
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	
}
