package onetomanymapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Test {

	public static void main(String[] args) {

		List<Flat> flist1 = new ArrayList<Flat>();

		Apartment apartment = new Apartment("1A", "Santhi Nilayam", 8, "East", 2, false, flist1);

		Flat f1 = new Flat("1A-102", "Kranthi", 2, "East", 1, false, apartment);
		Flat f2 = new Flat("1A-202", "Rishank", 1, "East", 2, true, apartment);
		Flat f3 = new Flat("1A-104", "Sri Vidya", 1, "south", 1, false, apartment);

		flist1.add(f1);
		flist1.add(f2);
		flist1.add(f3);

		List<Flat> flist2 = new ArrayList<Flat>();

		Apartment apartment1 = new Apartment("2A", "Adithya", 12, "west", 2, false, flist2);

		Flat f4 = new Flat("2A-101", "Narendar", 1, "west", 1, true, apartment1);
		Flat f5 = new Flat("2A-102", "Krithi", 2, "east", 1, false, apartment1);
		Flat f6 = new Flat("2A-103", "Sandhya", 2, "north", 1, false, apartment1);

		flist2.add(f4);
		flist2.add(f5);
		flist2.add(f6);

		Configuration config = new Configuration().configure().addAnnotatedClass(Flat.class)
				.addAnnotatedClass(Apartment.class);

		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(apartment);
		session.save(apartment1);
		session.save(f1);
		session.save(f2);
		session.save(f3);
		session.save(f4);
		session.save(f5);
		session.save(f6);

		tx.commit();
		Session session2 = sf.openSession();

		Transaction tx2 = session2.beginTransaction();

		// Print all the availbale flats in the apartment along with apartment details
		Query innerjoin = session2.createQuery(
				"select f from Flat f inner join Apartment a on f.apartment.apartment_id = a.apartment_id where f.isAvailable = true");

		List<Flat> list = innerjoin.list();

		for (Flat object : list) {
			System.out.println(object);
		}

		tx2.commit();

	}

}
