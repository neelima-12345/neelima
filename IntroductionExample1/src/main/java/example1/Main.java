package example1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Main {

	public static void main(String[] args) {

		City city1 = new City(1, "Mumbai", 101356, "India");
		City city2 = new City(2, "London", 546789, "UK");
		City city3 = new City(3, "Paris", 168878, "France");
		City city4 = new City(4, "Delhi", 102500, "India");
		City city5 = new City(5, "Bristol", 244356, "UK");
		City city6 = new City(6, "Hyderabad", 95356, "India");
		City city7 = new City(7, "Tokyo", 845356, "Japan");

		Configuration config = new Configuration().configure().addAnnotatedClass(City.class);

		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().
				applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(city1);
		session.save(city2);
		session.save(city3);
		session.save(city4);
		session.save(city5);
		session.save(city6);
		session.save(city7);

		// select single row from table by id
		City c = (City) session.get(City.class, 3);
		System.out.println(c);

		// select all the rows from table(complete table)
		Query query = session.createQuery("from City");
		List<City> clist = query.list();
		for (City city : clist) {
			System.out.println(city);
		}

		// select all the cities where the population is less than 300000(where
		// condition)
		Query selectwithwhereQuery = session.
				createQuery("from City where city_population<'300000'");
		List<City> papulationCities = selectwithwhereQuery.list();
		for (City city : papulationCities) {
			System.out.println(city);
		}

		// select all the cities in the country India where population is less than
		// 100000(where condition)
		Query selectWithAnd = session.
				createQuery("from City where country_name='india' and city_population<'100000'");
		List<City> indiaCityList = selectWithAnd.list();
		for (City city : indiaCityList) {
			System.out.println(city);
		}

		tx.commit();
		sf.close();

	}

}
