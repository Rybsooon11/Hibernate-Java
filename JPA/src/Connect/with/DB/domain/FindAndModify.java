package Connect.with.DB.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAndModify {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 
		 //Employee employee = entityManager.find(Employee.class, 1L);
		 //System.out.println("First name: "+ employee.getFirstName());
		 //System.out.println("Second name: "+ employee.getLastName());
		 //System.out.println("Salary: "+ employee.getSalary());
		 
		 entityManager.getTransaction().commit();
		 
		 entityManager.close();
		 entityManagerFactory.close();
	}

}
