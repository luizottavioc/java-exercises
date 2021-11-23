package entityEmployee;

public abstract class Employee {
	protected String login;
	protected String senha;
	protected String nome;
	protected String admissao;
	protected String nasc;
	
	public Employee(String login, String senha, String nome, String admissao, String nasc) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.admissao = admissao;
		this.nasc = nasc;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAdmissao() {
		return admissao;
	}

	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}

	public String getNasc() {
		return nasc;
	}

	public void setNasc(String nasc) {
		this.nasc = nasc;
	}
	
	
	
}

