package WineCellar.SEP4;

import WineCellar.SEP4.resource.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class Sep4Application {
	public static void main(String[] args) {

		SpringApplication.run(Sep4Application.class, args);

	}
}
