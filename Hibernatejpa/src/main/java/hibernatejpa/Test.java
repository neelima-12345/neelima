package hibernatejpa;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		LocalDate joining_date = LocalDate.of(2010, 11, 19);

		Employee_details e1 = new Employee_details(101, "Jithendra", "abc@gmail.com", "Developer", 25000,
				LocalDate.of(2020, 11, 24));
		Employee_details e2 = new Employee_details(102, "Gagan", "def@gmail.com", "Senior Developer", 55000,
				LocalDate.of(2019, 4, 1));
		Employee_details e3 = new Employee_details(103, "Sushma", "hgf@gmail.com", "Tester", 35000, joining_date);

		Configuration config = new Configuration().configure().addAnnotatedClass(Employee_details.class);

		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(e1);
		session.save(e2);
		session.save(e3);

		tx.commit();

	}

}
