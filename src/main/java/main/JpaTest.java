package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Department;
import domain.Preference;
import domain.Region;
import domain.Sport;
import domain.Town;
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
			User user2 = new User();
			Sport sport1 = new Sport();
			Sport sport2 = new Sport();
			Sport sport3 = new Sport();
			Town town1 = new Town();
			Town town2 = new Town();
			Town town3 = new Town();
			Town town4 = new Town();
			Preference pref1 = new Preference();
			Preference pref2 = new Preference();
			Preference pref3 = new Preference();
			Region region1 = new Region();
			Region region2 = new Region();
			Department dep1 = new Department();
			Department dep2 = new Department();
			Department dep3 = new Department();
			Department dep4 = new Department();
			
			dep1.setName("Finistère");
			dep2.setName("Morbihan");
			dep3.setName("Seine-saint-Denis");
			dep4.setName("Hauts-de-Seine");
			dep1.setRegion(region1);
			dep2.setRegion(region1);
			dep3.setRegion(region2);
			dep4.setRegion(region2);
			region1.setName("Bretagne");
			region2.setName("Ile de France");
			region1.addDep(dep1);
			region1.addDep(dep2);
			region2.addDep(dep3);
			region2.addDep(dep4);
			pref1.setName("voile confirmé");
			pref2.setName("voile débutant");
			pref3.setName("très raide");
			pref1.setMaxWindStrenght(10);
			pref2.setMaxWindStrenght(2);
			pref1.setMinWindStrenght(5);
			pref2.setMinWindStrenght(0);
			pref1.setRain(true);
			pref2.setRain(false);
			pref1.setSun(false);
			pref2.setSun(true);
			pref1.setUser(user1);
			pref2.setUser(user1);
			pref3.setUser(user2);
			town1.setName("Quimper");
			town2.setName("Saint-Cloud");
			town3.setName("Vannes");
			town4.setName("Villetaneuse");
			town1.setDepartment(dep1);
			town2.setDepartment(dep4);
			town3.setDepartment(dep2);
			town4.setDepartment(dep3);
			dep1.addTown(town1);
			dep2.addTown(town3);
			dep3.addTown(town4);
			dep4.addTown(town2);
			sport2.setName("Voile");
			sport2.setDescription("marin d'eau douce");
			sport3.setName("Escalade");
			sport3.setDescription("toujours plus haut");
			sport1.setName("Tennis");
			sport1.setDescription("Raquettes et balles jaunes");
			sport1.addTown(town4);
			sport2.addTown(town1);
			sport2.addTown(town3);
			sport1.addTown(town1);
			sport1.addTown(town2);
			sport1.addTown(town3);
			sport3.addTown(town2);
			user1.setFirstName("Toto");
			user1.addSport(sport1);
			user1.addSport(sport2);
			user1.setName("Tutu");
			user1.setEmail("toto@email.fr");
			user1.setPassword("monpass");
			user1.setLogin("monlogin");
			user1.addTown(town1);
			user1.addTown(town2);
			user1.addPreference(pref1);
			user1.addPreference(pref2);
			user2.setFirstName("Robert");
			user2.addSport(sport1);
			user2.addSport(sport3);
			user2.setName("Dupond");
			user2.setEmail("RoDup@gmail.com");
			user2.setPassword("verysecret");
			user2.setLogin("memoire");
			user2.addTown(town2);
			user2.addTown(town3);
			user2.addTown(town4);
			user2.addPreference(pref3);

			manager.persist(user1);
			manager.persist(user2);
			manager.persist(sport1);
			manager.persist(sport2);
			manager.persist(sport3);
			manager.persist(town1);
			manager.persist(town2);
			manager.persist(pref1);
			manager.persist(pref2);
			manager.persist(pref3);
			manager.persist(town3);
			manager.persist(town4);
			manager.persist(region1);
			manager.persist(region2);
			manager.persist(dep1);
			manager.persist(dep2);
			manager.persist(dep3);
			manager.persist(dep4);

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
