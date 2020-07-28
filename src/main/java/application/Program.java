package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import estudojpa.Pessoa;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa(null, "Enio", "enio.gn@gmail.com");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/*Criamos a classe com seus atributos dessa forma*/
		
		/*em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();*/
		
		/*dessa forma conseguimos localizar um dado pelo bd através do Id */
		Pessoa p = em.find(Pessoa.class, 1);
		
		/*podemos remover esse objeto que está em modo monitorado*/
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println(p);
		System.out.println("Pronto");
		em.close();
		emf.close();
	}

}
