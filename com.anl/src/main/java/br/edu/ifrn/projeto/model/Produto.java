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
@Table ( name = "produto" )
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private int idProduto;
	
	@Column ( name = "nome_produto", length = 70, nullable = false )
	private String nomeProduto;
	
	@Column ( name = "preco", nullable = false )
	private Double preco;
	
	@Column ( name = "descricao", length = 100, nullable = false )
	private String descricao;
	
	@ManyToOne
	@JoinColumn ( name = "id_situacao", nullable = false )
	private Situacao situacao;
	
	@ManyToMany (mappedBy = "produtos", cascade = CascadeType.PERSIST)
	private Set<Pedido> pedidos = new HashSet<>();
	
	public Produto () {
		
	}
	
	public Produto (int idProduto, String nomeProduto, Double preco, String descricao, Situacao situacao) {
		this.idProduto   = idProduto;
		this.nomeProduto = nomeProduto;
		this.preco       = preco;
		this.descricao   = descricao;
		this.situacao    = situacao;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public Double getpreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDecricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Situacao getSitucao() {
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
		result = prime * result + idProduto;
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
		Produto other = (Produto) obj;
		if (idProduto != other.idProduto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + ", preco=" + preco + ", descricao="
				+ descricao + ", situacao=" + situacao + "]";
	}
}
