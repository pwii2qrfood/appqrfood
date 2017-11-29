package br.edu.ifrn.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Telefone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private int idTelefone;
	
	@Column ( name = "numero", length = 9, nullable = false )
	private String numero;
	
	@JoinColumn ( name = "id_usuario" )
	@Column ( nullable = false)
	@ManyToOne
	private Usuario usuario;
	
	@JoinColumn ( name = "id_funcionario" )
	@Column ( nullable = false )
	@ManyToOne
	private Funcionario funcionario;
	
	
	public Telefone (){
		
	}
	
	public Telefone( int idTelefone, String numero, Usuario usuario, Funcionario funcionario) {
		this.idTelefone  = idTelefone;
		this.numero      = numero;
		this.usuario     = usuario;
		this.funcionario = funcionario;
	}
	
	public int getIdTelefone() {
		return idTelefone;
	}
	
	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Usuario getUsuario(Usuario usuario) {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Funcionario getFuncionario(Funcionario funcionario) {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTelefone;
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
		Telefone other = (Telefone) obj;
		if (idTelefone != other.idTelefone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", numero=" + numero + ", usuario=" + usuario + ", funcionario="
				+ funcionario + "]";
	}
}
