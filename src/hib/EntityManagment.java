package hib;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class EntityManagment {

	private static SessionFactory factory;

	public EntityManagment() {

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);

			// TODO Auto-generated constructor stub
		}
	}

	public int addUser(User user) {

		Session session = factory.openSession();
		org.hibernate.Transaction tx = null;
		int userID = 0;
		try {
			tx = session.beginTransaction();
			userID = (int) session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userID;
	}

	public void deleteUser(String us) {

	}

	public String userExist(User user) {
		String message = "";

		User user1 = null;
		Session session = factory.openSession();
		org.hibernate.Transaction tx = null;
		int userID = 0;
		try {
			tx = session.beginTransaction();
			
			 String hql="from User where username like :us";
		        Query query =session.createQuery(hql);
		        query.setParameter("us", user.getUsername());
			
	
			List l = (query).list() ;
					if (l.size()>0) {
						user1=(User) l.get(0);
					}
			
			tx.commit();
			if (user1 == null) {
				message = "USER FALSE";
			}
			else if(user1.getPassword().equals(user.getPassword()))
			{
				message="USER TRUE";
			}
			else{
				message = "PASSWORD FALSE";
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {

			return message;

		}
	}
}
