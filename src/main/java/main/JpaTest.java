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

		JpaTest test = new JpaTest(EntityManagerHelper.getEntityManager());

		/**
		 * Open a transaction
		 */
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		/**
		 * Create entities Employees and Departments (instanciate jobs objects +
		 * persistance O/R : create a recording in the DB)
		 */
		try {
			test.createUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		test.createUsers();

		/**
		 * Close the transaction
		 */
		tx.commit();

		/**
		 * Test queries with the implemented methods form JpaTest class
		 */
//		test.listEmployees();
//		test.listDepartments();
//		test.listEmployeesForDepartment(Long.decode("2"));
//		test.listEmployeesForDepartment(Long.decode("1"), Long.decode("3"));

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
		int numOfUsers = manager.createQuery("Select u From User u", User.class).getResultList().size();
		if (numOfUsers == 0) {

//			User user1 = new User();			
//			user1.setEmail("user@email.fr");
//			Sport sport1 = new Sport();
//			sport1.setName("Tennis");
//			user1.addSport(sport1);
			manager.persist(new User());
//			manager.persist(sport1);
			
//			manager.persist(new Employee("Jakab Gipsz", department1));
//			manager.persist(new Employee("Captain Nemo", department1));
//			manager.persist(new Employee("Tintin", department2));
//			manager.persist(new Employee("Milou", department2));
//			manager.persist(new Employee("Bill", department3));
//			manager.persist(new Employee("Bill", department1));
		}
	}

	/**
	 * Retrieve the list of all the employees
	 */
//	private void listEmployees() {
//		List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
//		System.out.println("Number of employees:" + resultList.size());
//		for (Employee next : resultList) {
//			System.out.println("next employee: " + next);
//		}
//	}

	/**
	 * Retrieve the list of all the departments
	 */
//	private void listDepartments() {
//		List<Department> dptList = manager.createQuery("Select * From Department d", Department.class).getResultList();
//		System.out.println("Number of departments :" + dptList.size());
//		for (Department dpt : dptList) {
//			System.out.println("Next department : " + dpt);
//		}
//	}

	/**
	 * Retrieve a list of the employees from a given department
	 * 
	 * @param id The id of the department
	 */
//	private void listEmployeesForDepartment(Long id) {
//		List<Employee> listEmployee = manager
//				.createQuery("SELECT e FROM Employee as e WHERE e.department.id = :id", Employee.class)
//				.setParameter("id", id)
//				.getResultList();
//		System.out.println("Number of employees:" + listEmployee.size());
//		for (Employee employee : listEmployee) {
//			System.out.println("Next employee : " + employee);
//		}
//	}

	/**
	 * Retrieve the list of employees who work in two departments TODO : REQUETE A
	 * REVOIR
	 * 
	 * @param id1
	 * @param id2
	 */
//	private void listEmployeesForDepartment(Long id1, Long id2) {
//		List<Employee> listEmployee = manager
//				.createQuery("SELECT e FROM Employee as e WHERE e.department.id = :id1 AND e.department.id = :id2",
//						Employee.class)
//				.setParameter("id1", id1).setParameter("id2", id2)
//				.getResultList();
//		System.out.println("Number of employees:" + listEmployee.size());
//		for (Employee employee : listEmployee) {
//			System.out.println("Next employee : " + employee);
//		}
//	}
}

