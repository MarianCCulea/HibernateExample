package WineCellar.SEP4.database;

import WineCellar.SEP4.resource.Item;
import WineCellar.SEP4.resource.Order;
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


    public List<String> getAllCategories(){
        Session session=factory.openSession();
        Transaction tx = null;
        List items=new ArrayList();
        try {
            tx= session.beginTransaction();

            items = session.createQuery("SELECT category FROM Item").list();
            for (Iterator iterator = items.iterator(); iterator.hasNext();){
                String item = (String) iterator.next();
                System.out.print(item);
                System.out.print("      ");
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


    public List<Item> getAllOrders(){
        Session session=factory.openSession();
        Transaction tx = null;
        List orders=new ArrayList();
        try {
            tx= session.beginTransaction();

            orders = session.createQuery("FROM Order").list();
            for (Iterator iterator = orders.iterator(); iterator.hasNext();){
                Order order = (Order) iterator.next();
                System.out.print("Adress: " + order.getAdress());
                System.out.print("      ");
                System.out.print("Invoice Adress" + order.getInvoiceadress());
                System.out.print("      ");
                System.out.println("Total price: " + order.getTotalprice());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orders;
    }

    public List<Order> getOrderItems(int order_id)
    {
        Session session=factory.openSession();
        Transaction tx = null;
        List orders=new ArrayList();
        List items=new ArrayList();
        try {
            tx= session.beginTransaction();
            orders = session.createQuery("from Order where Order.order_id=:order_id").setParameter("order_id",order_id).list();
            for (Iterator iterator = orders.iterator(); iterator.hasNext();){
                Order order = (Order) iterator.next();

            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orders;
    }


    public void addOrder(Order o) {
        Session session=factory.openSession();
        Transaction tx = null;
        try {
            tx= session.beginTransaction();
            session.save(o);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}