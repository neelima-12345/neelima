package jpaexample;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		LocalDate joining_date = LocalDate.of(2010, 11, 19);

		Student s1 = new Student("Neelima", "abc@gmail.com", "Java", LocalDate.of(2021, 11, 19));
		Student s2 = new Student("Bharath", "abc@gmail.com", "Python", LocalDate.of(2022, 1, 2));
		Student s3 = new Student("Raghav", "def@gmail.com", "Dotnet", joining_date);

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);

		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(s1);
		session.save(s2);
		session.save(s3);

		tx.commit();
		sf.close();

	}

}
