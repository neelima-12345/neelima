package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Main {

	public static void main(String[] args) {

		List<Employee> employee = new ArrayList<Employee>();

		Designation d1 = new Designation("M111", "Manager", "Non Technical", employee);

		Employee e1 = new Employee(1, "Edward Russell", "male", 100000, 6, d1);
		Employee e2 = new Employee(2, "Sri Latha", "female", 90000, 7, d1);

		employee.add(e1);
		employee.add(e2);

		List<Employee> employee2 = new ArrayList<Employee>();

		Designation d2 = new Designation("P9900", "Payrole Analyst", "Finance", employee2);

		Employee e3 = new Employee(3, "Neelima Chowdary", "female", 25000, 1.5, d2);
		Employee e4 = new Employee(4, "John Robert", "male", 34000, 2, d2);

		employee2.add(e3);
		employee2.add(e4);

		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Designation.class);

		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(d1);
		session.save(d2);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);

		tx.commit();
		Session session2 = sf.openSession();

		Transaction tx2 = session2.beginTransaction();

		Query selectall = session2.createQuery(
				"select e from Employee e inner join Designation d on e.designation.des_id = d.des_id where salary < 100000");

		List<Employee> e = selectall.list();
		for (Employee object : e) {
			System.out.println(object);
		}
		tx2.commit();

	}

}
