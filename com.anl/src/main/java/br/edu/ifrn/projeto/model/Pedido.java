package br.edu.ifrn.projeto.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table ( name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private int idPedido;
	
	@Column ( name = "numero_pedido", nullable = false )
	private String numeroPedido;
	
	@Column ( name = "quantidade", nullable = false)
	private String quantidade;
	
	@Column ( name = "data", nullable = false)
	private Date data;
	
	@Column ( name = "hora", nullable = false)
	private Time hora;
	
	@OneToOne
	@JoinColumn ( name = "id_situacao_pedido" )
	private SituacaoPedido situacaopedido;
	
	@ManyToMany
	@JoinTable(name="produto_has_pedido",
	joinColumns = @JoinColumn (name = "pedido_id"),
	inverseJoinColumns = @JoinColumn(name= "produto_id"))
	private Set<Produto> produtos = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name= "pedido_has_formapagamento",
	joinColumns = @JoinColumn (name = "pedido_id"),
	inverseJoinColumns = @JoinColumn (name="formapagamento_id"))
	private Set<FormaDePagamento> formaspagamento = new HashSet<>();
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getNumeropedido() {
		return numeroPedido;
	}

	public void setNumero_pedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public SituacaoPedido getSituacaopedido() {
		return situacaopedido;
	}

	public void setSituacaopedido(SituacaoPedido situacaopedido) {
		this.situacaopedido = situacaopedido;
	}
	

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Set<FormaDePagamento> getFormaspagamento() {
		return formaspagamento;
	}

	public void setFormaspagamento(Set<FormaDePagamento> formaspagamento) {
		this.formaspagamento = formaspagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPedido;
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
		Pedido other = (Pedido) obj;
		if (idPedido != other.idPedido)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + idPedido + ", numero_pedido=" + numeroPedido + ", quantidade=" + quantidade
				+ ", data=" + data + ", hora=" + hora + "]";
	}
}
