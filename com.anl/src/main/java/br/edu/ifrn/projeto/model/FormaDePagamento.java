package br.edu.ifrn.projeto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table ( name = "formadepagamento" )
public class FormaDePagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "id_forma_pagamento" )
	private int idFormaPagamento;
	
	@Column( name = "tipo_pagamento", nullable = false )
	private String tipoPagamento;
	
	@Column( name = "descricao", nullable = false )
	private  String descricao;
	
	@ManyToOne
	@JoinColumn( name = "id_situacao" )
	private Situacao situacao;
	
	@ManyToMany( mappedBy = "formaspagamento", cascade = CascadeType.PERSIST )
	private Set<Pedido> pedidos = new HashSet<>();
	
	
	public int getIdFormaPagamento() {
		return idFormaPagamento;
	}
	
	public void setIdFormaPagamento(int idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}
	
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Situacao getSituacao() {
		return situacao;
	}
	
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
	
	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFormaPagamento;
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
		FormaDePagamento other = (FormaDePagamento) obj;
		if (idFormaPagamento != other.idFormaPagamento)
			return false;
		return true;
	}
}
