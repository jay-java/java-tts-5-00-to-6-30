package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SessionFactory sf = new Configuration().configure("demo/hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
//		User u = new User(2,"python", "delhi");
//		session.save(u);
//		
//		User u = session.get(User.class, 1);
//		System.out.println(u);
		
		User u = new User(2,"python", "abcd");
		session.update(u);
		tx.commit();
		session.close();
		sf.close();
	}
}
