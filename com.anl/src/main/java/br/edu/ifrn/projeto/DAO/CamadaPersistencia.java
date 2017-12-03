package br.edu.ifrn.projeto.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifrn.projeto.model.Situacao;
import br.edu.ifrn.projeto.model.Usuario;

public class CamadaPersistencia {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.anl.PU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//declarando os DAO
		SituacaoDAO situacaodao = new SituacaoDAO(em);
		UsuarioDAO usuariodao = new UsuarioDAO(em);
		
		//criando um usuário
		Usuario usuario = new Usuario();
		
		usuario.setNomeCompletoCliente("Raimundo Nonato Ribeiro de Aguiar");
		usuario.setCpfCliente("111.222.333-44");
		usuario.setRgCliente("11.222.333");
		usuario.setTipoCliente("F");
		usuario.setNomeCliente("Nonato");
		usuario.setSobrenomeCliente("Aguiar");
		usuario.setSenhaCliente("123");
		
		//Salvando Usuario
		
		usuariodao.adicionar(usuario);
	
		Situacao situacao = new Situacao();
		
		situacao.setTipoSituacao("A");
		situacao.setDescricao("Empresa ativa");
		
		situacaodao.adicionar(situacao);
		
		em.getTransaction().commit();
	}
}
