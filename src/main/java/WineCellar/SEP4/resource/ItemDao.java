package WineCellar.SEP4.resource;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ItemDao {
/*

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Item item) {
        getSession().save(item);
        return;
    }

    public void delete(Item item) {
        getSession().delete(item);
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Item> getAll() {
        return getSession().createQuery("from item").list();
    }

    public Item getByEmail(String name) {
        return (Item) getSession().createQuery(
                "from item where name = :name")
                .setParameter("name", name)
                .uniqueResult();
    }


    public void update(Item item) {
        getSession().update(item);
        return;
    }

 */
}
