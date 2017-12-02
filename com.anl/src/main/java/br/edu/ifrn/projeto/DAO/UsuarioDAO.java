package br.edu.ifrn.projeto.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.edu.ifrn.projeto.model.Usuario;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public UsuarioDAO() {}
	
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adicionar(Usuario novousuario) {
		manager.persist(novousuario);
	}
	
	public Usuario pesquisarPorId(int id) {
		return manager.find(Usuario.class, id);
	}
	
	public void remover(Usuario usuario) {
		usuario = pesquisarPorId(usuario.getIdCliente());
		manager.remove(usuario);
	}
	
	public List<Usuario> pesquisar (String nome){
		TypedQuery<Usuario> consulta =
				manager.createQuery("from Usuario where nome like :nome_completo", Usuario.class);
		consulta.setParameter("nome", nome + "%");
		return consulta.getResultList();
	}

}
