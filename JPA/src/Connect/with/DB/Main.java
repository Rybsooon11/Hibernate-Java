package Connect.with.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.jdbc.result.CachedResultSetMetaData;

import Connect.with.DB.domain.AutoDealer;
import Connect.with.DB.domain.Car;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		AutoDealer autodealer = new AutoDealer();
		autodealer.setLocalization("Opaka");
		autodealer.setName("MammaMia");
		autodealer.setPhoneNumber(983384938);
		autodealer.setStreet("Sunny");
		autodealer.setZipCode("38-203");

		Car car = new Car();
		car.setColour("red");
		car.setEngine("Diesel 2.0");
		car.setMark("Ford");
		car.setModel("Mustang");
		car.setPrice(14000);
		car.setYear(1998);
		car.setAutodealer(autodealer);

		Car car2 = new Car();
		car2.setColour("blue");
		car2.setEngine("Diesel 2.5");
		car2.setMark("Fiat");
		car2.setModel("Panda");
		car2.setPrice(8000);
		car2.setYear(2008);
		car2.setAutodealer(autodealer);

		entityManager.getTransaction().begin();
		entityManager.persist(car);
		entityManager.persist(car2);
		entityManager.persist(autodealer);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
