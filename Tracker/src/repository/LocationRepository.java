package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import filter.Filter;
import model.Location;
import util.HibernateUtil;

public class LocationRepository {
	
	public void saveLocation(Location location) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the location object
            session.save(location);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	public List<String> getPlates(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select distinct plate from Location", String.class).list();
        }
	}
	
	public List<Location> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Location", Location.class).list();
        }
    }
	
    public List<Location> getLocations(Filter filter) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT l FROM Location l WHERE " + filter.getQuery(), Location.class).list();
        }
    }
}
