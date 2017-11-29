package br.edu.ifrn.projeto.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
