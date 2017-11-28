package br.edu.ifrn.projeto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private int idFuncionario;
	
	@Column ( name = "matricula", length = 5, nullable = false )
	private String matricula;
	
	@Column ( name = "nome_completo", length = 100, nullable = false )
	private String nomeCompleto;
	
	@Temporal ( TemporalType.DATE )
	@Column ( name = "data_admissao", nullable = false )
	private Date dataAdmissao;
	
	@Temporal ( TemporalType.DATE )
	@Column ( name = "data_demissao", nullable = true )
	private Date dataDemissao;
	
	@Column ( name = "cpf", length = 14, nullable = false )
	private String cpf;
	
	@Column ( name = "rg", length = 9, nullable = false )
	private String rg;
	
	@Column ( name = "name", length = 20, nullable = false )
	private String nome;
		
	@Column ( name = "sobrenome", length = 20, nullable = false )
	private String sobreNome;
	
	@JoinColumn ( name = "id_situacao")
	@ManyToOne
	private Situacao situacao;
	
	public Funcionario() {
		
	}
	
	public Funcionario(int idFuncionario, String matricula, String nomeCompleto, Date dataAdmissao, Date dataDemissao,
						String cpf, String rg, String nome, String sobreNome, Situacao situacao) {
		
		this.idFuncionario = idFuncionario;
		this.matricula     = matricula;
		this.nomeCompleto  = nomeCompleto;
		this.dataAdmissao  = dataAdmissao;
		this.dataDemissao  = dataDemissao;
		this.cpf           = cpf;
		this.rg            = rg;
		this.nome          = nome;
		this.sobreNome     = sobreNome;
		this.situacao      = situacao;
		
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	public Date getDataDmissao() {
		return dataDemissao;
	}
	
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public Situacao getSituacao() {
		return situacao;
	}
	
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFuncionario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (idFuncionario != other.idFuncionario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "funcionario [idFuncionario=" + idFuncionario + ", matricula=" + matricula + ", nomeCompleto="
				+ nomeCompleto + ", dataAdmissao=" + dataAdmissao + ", dataDemissao=" + dataDemissao + ", cpf=" + cpf
				+ ", rg=" + rg + ", nome=" + nome + ", sobreNome=" + sobreNome + ", situacao=" + situacao + "]";
	}
}
