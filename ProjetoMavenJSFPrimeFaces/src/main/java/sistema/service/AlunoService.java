package sistema.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sistema.modelos.Aluno;


public class AlunoService {

	private EntityManagerFactory emf;
	
	public AlunoService()
	{
	      emf = Persistence.createEntityManagerFactory("ProjetoMavenJSFPrimeFaces");
	}
	
	public void salvar(Aluno aluno)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(aluno);
		em.getTransaction().commit();	
	    em.close();
		
	}
	
	public void remover(Aluno aluno){
		System.out.println("REMOVE2");
		
		EntityManager em = emf.createEntityManager();
		
		Aluno a1 = em.find(Aluno.class, aluno.getMatricula());

		if (a1 != null) {
			em.remove(a1);
			System.out.println("Sucesso");
		} else {
			System.out.println("Não cadastrado");
		}
	
		em.getTransaction().begin();
		em.getTransaction().commit();
	
		em.close();
	}
	
	public void editar(Aluno aluno)
	{
		EntityManager em = emf.createEntityManager();
		
		Aluno l1 = em.find(Aluno.class, aluno.getMatricula());
		
		if (l1 != null) {
			l1.setNome(aluno.getNome());
			l1.setNome(aluno.getCurso());

			l1 = em.find(Aluno.class, 2l);
		} else {
			System.out.println("Não cadastrado");
		}
		
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List <Aluno> getAlunos()
	{
		
		List <Aluno >alunos;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Aluno a");
		alunos = q.getResultList();
		em.close();
		
		return alunos;
		
	}
	
	
}
