package WineCellar.SEP4.database;

import WineCellar.SEP4.resource.Item;
import WineCellar.SEP4.resource.Orders;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Database {
    private static SessionFactory factory;
    private static Database instance;

    public Database() {
        try {


            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Item.class);
            configuration.addAnnotatedClass(Orders.class);


           factory = configuration.configure().buildSessionFactory();
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
        List<String> categories=new ArrayList<>();
        try {
            tx= session.beginTransaction();

            items = session.createQuery("SELECT i.category FROM Item i").list();
            for (Iterator iterator = items.iterator(); iterator.hasNext();){
                String categ = (String) iterator.next();
                categories.add(categ);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }


    public List<Orders> getAllOrders(){
        Session session=factory.openSession();
        Transaction tx = null;
        List querylist;
        List<Orders> orders=new ArrayList<>();
        try {
            tx= session.beginTransaction();
            querylist = session.createQuery("FROM Orders").list();
            for (Iterator iterator = querylist.iterator(); iterator.hasNext();){
                Orders order = (Orders) iterator.next();
                orders.add(order);
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

    public Set<Item> getOrderItems(int order_id)
    {
        Session session=factory.openSession();
        Transaction tx = null;
        List orders=new ArrayList();
        Orders or=null;

        try {
            tx= session.beginTransaction();
            orders = session.createQuery("from Orders where Orders.order_id=:order_id").setParameter("order_id",order_id).list();
            for (Iterator iterator = orders.iterator(); iterator.hasNext();){
                or = (Orders) iterator.next();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            //e.printStackTrace(); Log in loc de print
        } finally {
            session.close();
        }
        return or.getItems();
    }

    public Orders getOrderById(int order_id)
    {
        Session session=factory.openSession();
        Transaction tx = null;
        List orders;
        List items=new ArrayList();
        Orders or=null;

        try {
            tx= session.beginTransaction();
            orders = session.createQuery("from Orders o where o.order_id=:order_id").setParameter("order_id",order_id).list();
            or=(Orders)orders.get(0);

            items=session.createQuery("select i.item_id,i.name,i.category,i.price,i.description,i.url,i.quantity,i.quantitytype,i.nrofitems \n" +
                    "from orderhasitems oi join Item i on oi.item_id=i.item_id where oi.order_id=:order_id").setParameter("order_id",order_id).list();
            for (Iterator iterator = items.iterator(); iterator.hasNext();){
                or.getItems().add( (Item) iterator.next());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return or;
    }


    public String addOrder(Orders orders) {
        Session session=factory.openSession();
        Transaction tx = null;
        try {
            tx= session.beginTransaction();
            session.persist(orders);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();//log
            return "Something went Wrong";
        } finally {
            session.close();
            return "Done";
        }
    }

    public String updateOrder(Orders orders) {
        Session session=factory.openSession();
        Transaction tx = null;
        try {
            tx= session.beginTransaction();
            session.update(orders);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            //log
            e.printStackTrace();
            return "Something went Wrong";
        } finally {
            session.close();
            return "Done";
        }
    }

    public String deleteOrder(Orders orders) {
        Session session=factory.openSession();
        Transaction tx = null;
        try {
            tx= session.beginTransaction();
            session.delete(orders);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            //log
            e.printStackTrace();
            return "Something went Wrong";
        } finally {
            session.close();
            return "Done";
        }
    }
}