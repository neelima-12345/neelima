package onetoOneRealtion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Test {
	
	public static void main(String[] args) {

		Capital capital = new Capital("Delhi", 32941000, false, "1483sq.kms");
		Capital capital1 = new Capital("beijing", 21766000, false, "16,410.5 sq.kms");
		Capital capital2 = new Capital("Tokyo", 37194000, true, "2,194 sq.kms");
		Capital capital3 = new Capital("Brasilia", 4728000, true, " 5,802 sq.kms");
		Capital capital4 = new Capital("Jakarta", 11075000, true, "  661.5 sq.kms");
		Capital capital5 = new Capital("Cairo", 22183000, false, " 453 sq.kms");
		Capital capital6 = new Capital("Riyadh", 9058394, false, "1,973 sq.kms");
		Capital capital7 = new Capital("Berlin", 3571000, false, " 891.8 sq.kms");
		Capital capital8 = new Capital(" Bangkok", 10539000, true, "1,568.7 sq.kms ");
		Capital capital9 = new Capital("Moscow", 12680000, true, " 2,511 sq.kms");
		Capital capital10 = new Capital("Islamabad", 1232000, true, " 906.5 sq.kms");
		Capital capital11 = new Capital("Kabul", 6760500, false, " 1,023 sq.kms");
		Capital capital12 = new Capital("Seoul", 9988000, false, " 605.2 sq.kms");

		Country country = new Country("India", 1415681359, "Ganga", "Rice", true);
		Country country1 = new Country("China", 1453932069, "Yangtze", "Rice", true);
		Country country2 = new Country("Japan", 125459537, "Shinano", "Rice", true);
		Country country3 = new Country("Brazil", 216527662, "Amazon", "Soybean", true);
		Country country4 = new Country("Indonesia", 281121689, "Kapuas", "Palm oil", true);
		Country country5 = new Country("Egypt", 107407211, "Nile", "Wheat", true);
		Country country6 = new Country("Saudi Arabia", 36238583, " Wadi al-Rummah", "watermelon", true);
		Country country7 = new Country("Germany", 84488027, "Danube", "Barley", true);
		Country country8 = new Country("Thailand", 70259783, "Chao Phraya", "Cassava", true);
		Country country9 = new Country("Russia", 146098876, "Lena", "Potatoes", true);
		Country country10 = new Country("Butan", 793928, "Drangme Chhu", "Soya Beans", false);
		Country country11 = new Country("Zimbabwe", 15430850, "Zambezi", "Corn", false);
		Country country12 = new Country("Canada", 38611350, "Yukon", "Corn", true);
		Country country13 = new Country("Sweden", 10264641, "Gota alv—Klaralven", "Cereals", true);
		Country country14 = new Country("Nepal", 30579216, "Koshi", "Tobacco", false);

		capital.setCountry(country);
		capital1.setCountry(country1);
		capital2.setCountry(country2);
		capital3.setCountry(country3);
		capital4.setCountry(country4);
		capital5.setCountry(country5);
		capital6.setCountry(country6);
		capital7.setCountry(country7);
		capital8.setCountry(country8);
		capital9.setCountry(country9);

		country.setCapital(capital);
		country1.setCapital(capital1);
		country2.setCapital(capital2);
		country3.setCapital(capital3);
		country4.setCapital(capital4);
		country5.setCapital(capital5);
		country6.setCapital(capital6);
		country7.setCapital(capital7);
		country8.setCapital(capital8);
		country9.setCapital(capital9);

		Configuration con = new Configuration().configure().addAnnotatedClass(Capital.class)
				.addAnnotatedClass(Country.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sf = con.buildSessionFactory(reg.build());
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(capital);
		session.save(country);
		session.save(capital1);
		session.save(country1);
		session.save(capital2);
		session.save(country2);
		session.save(capital3);
		session.save(country3);
		session.save(capital4);
		session.save(country4);
		session.save(capital5);
		session.save(country5);
		session.save(capital6);
		session.save(country6);
		session.save(capital7);
		session.save(country7);
		session.save(capital8);
		session.save(country8);
		session.save(capital9);
		session.save(country9);
		session.save(capital10);
		session.save(country10);
		session.save(capital11);
		session.save(country11);
		session.save(capital12);
		session.save(country12);
		session.save(country13);
		session.save(country14);

		tx.commit();
		session.close();

		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();

		// Print all the country details along with capital details which are having
		// seashore(inner Join)

		Query selectwithwhereQuery = session2.createQuery(
				"select co from Country co inner join Capital ca on ca.capital_name = co.capital.capital_name "
						+ "where co.isseashore='1' and ca.isseashore='1'");

		List<Country> isseashoreActive = selectwithwhereQuery.list();

		for (Country object : isseashoreActive) {
			System.out.println(object);
		}

		// Print all the country and capital details where only the countries contains
		// sea shore
		// but not the capital contains seashore(left join)

		Query selectwithwhereQuery2 = session2.createQuery(
				"select co from Country co left join Capital ca on ca.capital_name = co.capital.capital_name "
						+ "where co.isseashore='1' and ca.isseashore='0'");

		List<Country> table = selectwithwhereQuery2.list();

		for (Country object : table) {
			System.out.println(object);
		}

		tx2.commit();

	}

}
