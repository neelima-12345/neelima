package hibernateonetoone;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class Test {
	public static void main(String[] args) {

		Laptop laptop1 = new Laptop(1, "Dell", "XPS15", LocalDate.of(2024, 10, 2));
		Laptop laptop2 = new Laptop(2, "Lenovo", "ThinkPad X12", LocalDate.of(2027, 7, 7));
		Laptop laptop3 = new Laptop(3, "MSI", "GS66 Stealth", LocalDate.of(2018, 10, 12));
		Laptop laptop4 = new Laptop(4, "Samsung", " Book 360", LocalDate.of(2030, 2, 2));
		Laptop laptop5 = new Laptop(5, "Apple", "Macbook Air", LocalDate.of(2025, 4, 5));
		Laptop laptop6 = new Laptop(6, "HP", "Spectre x360 13.5", LocalDate.of(2016, 4, 22));
		Laptop laptop7 = new Laptop(7, "Acer", "ConceptD 7 Ezel", LocalDate.of(2023, 12, 1));
		Laptop laptop8 = new Laptop(8, "Fujitsu", "UH-X 4ZR1K06212", LocalDate.of(2018, 2, 21));
		Laptop laptop9 = new Laptop(9, "LG", "gram 17", LocalDate.of(2022, 12, 12));
		Laptop laptop10 = new Laptop(10, "Microsoft", "Surface Pro 8", LocalDate.of(2027, 1, 18));
		Laptop laptop11 = new Laptop(11, "Dell", " XPS17", LocalDate.of(2017, 8, 16));
		Laptop laptop12 = new Laptop(12, "Asus", "ZenBook Pro 16X", LocalDate.of(2015, 7, 10));
		Laptop laptop13 = new Laptop(13, "Razer", "Book 14", LocalDate.of(2024, 12, 22));

		LocalDate emp_joining_date = LocalDate.of(2010, 11, 19);

		Employee employee1 = new Employee(1, "Rajendra Kumar", 90000, LocalDate.of(2012, 5, 2));
		Employee employee2 = new Employee(2, "Sandeep DUll", 40000, LocalDate.of(2019, 1, 1));
		Employee employee3 = new Employee(3, "Neelima Chowdary", 90000, LocalDate.of(2015, 12, 1));
		Employee employee4 = new Employee(4, "Shiv Kumar", 25000, LocalDate.of(2022, 11, 11));
		Employee employee5 = new Employee(5, "Pooja Kapoor", 70000, LocalDate.of(2019, 10, 11));
		Employee employee6 = new Employee(6, "Brinda Mehta", 85000, LocalDate.of(2012, 1, 5));
		Employee employee7 = new Employee(7, "John Robert", 30000, LocalDate.of(2021, 2, 12));
		Employee employee8 = new Employee(8, "Sri Harsha", 60000, LocalDate.of(2017, 9, 21));
		Employee employee9 = new Employee(9, "Hari Kiran", 50000, LocalDate.of(2014, 9, 11));
		Employee employee10 = new Employee(10, "Sri Divya", 50000, LocalDate.of(2019, 10, 1));
		Employee employee11 = new Employee(11, "Thomas Edward", 85000, LocalDate.of(2016, 2, 3));
		Employee employee12 = new Employee(12, "Swetha Kapoor", 30000, LocalDate.of(2022, 5, 1));
		Employee employee13 = new Employee(13, "Mohan Krishna", 50000, LocalDate.of(2018, 4, 23));
		Employee employee14 = new Employee(14, "Smrithi Kour", 95000, LocalDate.of(2010, 3, 2));
		Employee employee15 = new Employee(15, "Tony Edward", 20000, emp_joining_date);

		laptop1.setEmployee(employee10);
		laptop2.setEmployee(employee9);
		laptop3.setEmployee(employee8);
		laptop4.setEmployee(employee13);
		laptop5.setEmployee(employee15);
		laptop6.setEmployee(employee6);
		laptop7.setEmployee(employee5);
		laptop8.setEmployee(employee3);
		laptop9.setEmployee(employee2);
		laptop10.setEmployee(employee1);

		employee1.setLaptop(laptop10);
		employee2.setLaptop(laptop9);
		employee3.setLaptop(laptop8);
		employee5.setLaptop(laptop7);
		employee6.setLaptop(laptop6);
		employee8.setLaptop(laptop3);
		employee9.setLaptop(laptop2);
		employee10.setLaptop(laptop1);

		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Laptop.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sf = con.buildSessionFactory(reg.build());
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(laptop1);
		session.save(laptop2);
		session.save(laptop3);
		session.save(laptop4);
		session.save(laptop5);
		session.save(laptop6);
		session.save(laptop7);
		session.save(laptop8);
		session.save(laptop9);
		session.save(laptop10);
		session.save(laptop11);
		session.save(laptop12);
		session.save(laptop13);
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);
		session.save(employee5);
		session.save(employee6);
		session.save(employee7);
		session.save(employee8);
		session.save(employee9);
		session.save(employee10);
		session.save(employee11);
		session.save(employee12);
		session.save(employee13);
		session.save(employee14);
		session.save(employee15);
		tx.commit();
		session.close();

		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();

		// Print all the laptop company names & the count of employees who are using
		// them.

		Query selectwithjoin = session2
				.createQuery("select la from Employee e inner join  Laptop la on la.employee.emp_id = e.emp_id ");

		List<Laptop> l = selectwithjoin.list();

		for (Laptop object : l) {
			System.out.println(object);
		}

		// Print all the employees along with laptops(left join).

		Query allemployees = session2
				.createQuery(" select   e from Employee e left join Laptop la on  e.emp_id = la.employee.emp_id   ");

		List<Employee> e1 = allemployees.list();

		for (Employee object1 : e1) {
			System.out.println(object1);
		}
		Query allemployees1 = session2
				.createQuery(" select   la from Employee e left join Laptop la on  e.emp_id = la.employee.emp_id   ");

		List<Laptop> e2 = allemployees1.list();

		for (Laptop object1 : e2) {
			System.out.println(object1);
		}

		// Print the employees who has laptops and print all the laptop details(right
		// join)

		Query allLaptops = session2
				.createQuery("  select la from Laptop la right join Employee e on  e.emp_id = la.employee.emp_id  ");

		List<Laptop> lList = allLaptops.list();

		for (Laptop object2 : lList) {
			System.out.println(object2);
		}

		tx2.commit();

		session2.close();

	}
}
