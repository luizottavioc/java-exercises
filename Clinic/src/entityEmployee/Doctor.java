package entityEmployee;

public class Doctor extends Employee {
	private String especialidade;
	private String crm;
	
	public Doctor (String login, String senha, String nome, String admissao, String nasc, String crm, String especialidade){
		super(login, senha, nome, admissao, nasc);
		this.crm = crm;
		this.especialidade = especialidade;
	}
}
