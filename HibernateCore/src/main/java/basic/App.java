package basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("project started");
		SessionFactory sf = new Configuration().configure("basic/hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User(1, "java", "ahmedabad");
		session.save(u);
		
		tx.commit();
		session.close();
		sf.close();
	}
}
