package example2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Main {

	public static void main(String[] args) {

		Student std1 = new Student(1, "Bharathi", "Female", 40, "2243588678");
		Student std2 = new Student(2, "Sandeep", "Male", 46, "5576899345");
		Student std3 = new Student(3, "Sujit", "Male", 85, "8856140934");
		Student std4 = new Student(4, "Sushma", "Female", 45, "7705615260");
		Student std5 = new Student(5, "Yamini", "Female", 52, "9008908125");
		Student std6 = new Student(6, "Navya", "Female", 22, "9989957789");
		Student std7 = new Student(7, "Raju", "Male", 38, "1123577896");
		Student std8 = new Student(8, "Naresh", "Male", 62, "5534566789");

		Configuration config = new Configuration().configure().
				addAnnotatedClass(Student.class);

		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().
				applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(std1);
		session.save(std2);
		session.save(std3);
		session.save(std4);
		session.save(std5);
		session.save(std6);
		session.save(std7);
		session.save(std8);

		// update student phone number by id
		Student s = (Student) session.load(Student.class, 4);
		s.setPhone_number("5564533649");
		session.saveOrUpdate(s);

		// update student name by id
		Student a = (Student) session.load(Student.class, 2);
		a.setName("Kishan");
		session.saveOrUpdate(a);

		// select all students who scored between 30 to 50(both inclusive)
		Query selectWithAnd = session.createQuery("from Student where marks>='30' and marks<='50'");
		List<Student> listOfStudents = selectWithAnd.list();
		for (Student std : listOfStudents) {

			System.out.println(std);
			// add 10 marks to each student
			std.setMarks(std.getMarks() + 10);
			session.saveOrUpdate(std);

			// check updation
			Student updatedStudent = (Student) session.load(Student.class, std.getId());
			System.out.println(updatedStudent);
		}

		tx.commit();

	}

}
