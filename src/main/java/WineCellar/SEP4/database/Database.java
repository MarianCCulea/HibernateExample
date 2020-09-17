package WineCellar.SEP4.database;

import WineCellar.SEP4.resource.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {
    private static SessionFactory factory;
    private static Database instance;

    public Database() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public synchronized static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }


    public List<Item> getAllItems(){
        Session session=factory.openSession();
        Transaction tx = null;
        List items=new ArrayList();
        try {
            tx= session.beginTransaction();

            items = session.createQuery("FROM Item").list();
            for (Iterator iterator = items.iterator(); iterator.hasNext();){
                Item item = (Item) iterator.next();
                System.out.print("Name: " + item.getName());
                System.out.print("      ");
                System.out.print("Category" + item.getCategory());
                System.out.print("      ");
                System.out.println("Price: " + item.getPrice());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return items;
    }


}