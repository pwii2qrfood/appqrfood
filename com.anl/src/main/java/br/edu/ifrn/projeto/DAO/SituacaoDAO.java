package br.edu.ifrn.projeto.DAO;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.edu.ifrn.projeto.model.Situacao;

public class SituacaoDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public SituacaoDAO() {
		
	}
	
	public SituacaoDAO (EntityManager manager) {
		this.manager = manager;
	}
	
	public void adicionar(Situacao novasituacao) {
		manager.persist(novasituacao);		
	}
	
	public void alterar(Situacao editasituacao) {
		editasituacao = pesquisarPorID(editasituacao.getIdSituacao());
		manager.merge(editasituacao);
	}
	
	public Situacao pesquisarPorID(int idSituacao) {
		return manager.find(Situacao.class, idSituacao);
	}
	
	public List<Situacao> pesquisarTodos() {
				
		TypedQuery<Situacao> listasituacao = manager.createQuery("from situacao", Situacao.class);
		
		listasituacao.setParameter("tipo_situacao", "%");
		
		return listasituacao.getResultList();
	}
	
	public List<Situacao> pesquisarportipo(Charset tipoSituacao){
		
		TypedQuery<Situacao> resultado = manager.createQuery("from situacao where tipo_situacao :tipo_situacao", Situacao.class);
		
		resultado.setParameter("tipo_situacao",tipoSituacao);
	
		return resultado.getResultList();
	}
	
	public void excluir(Situacao situacao) {
		situacao = pesquisarPorID(situacao.getIdSituacao());
		manager.remove(situacao);
	}
}
