package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Sport;
import domain.User;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Open a JPA work unit (EntityManager)
		 */
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		test.createUsers();

		/**
		 * Close the entityManager (JPA unit)
		 * 
		 */
		manager.close();
		factory.close();
		System.out.println("... done");
	}

	/**
	 * Create job datas
	 */
	private void createUsers() {

		/**
		 * Open a transaction
		 */
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			User user1 = new User();
			user1.setFirstName("Toto");
			Sport sport1 = new Sport();
			sport1.setName("Tennis");
			sport1.setDescription("Raquettes et balles jaunes");
			user1.addSport(sport1);
			user1.setName("Tutu");
			user1.setEmail("toto@email.fr");

			manager.persist(user1);
			manager.persist(sport1);

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		/**
		 * Close the transaction
		 */
		tx.commit();
	}
}
