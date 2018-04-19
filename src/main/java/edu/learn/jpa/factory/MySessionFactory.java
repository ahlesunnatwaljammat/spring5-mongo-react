package edu.learn.jpa.factory;

import edu.learn.jpa.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public enum MySessionFactory {
    INSTANCE;

    private static ArrayList<Class> entities = new ArrayList<>();

    static {
        entities.add(User.class);
    }

    public SessionFactory getSessionFactory(){
        // A MySessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("/hiber.h2.cfg.xml") // configures settings from hiber.mysql.cfg.xml
                .build();
        SessionFactory sessionFactory = null;
        try {
            MetadataSources metadataSources = new MetadataSources( registry );
            entities.forEach(metadataSources::addAnnotatedClass);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the MySessionFactory, but we had trouble building the MySessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            e.printStackTrace();
        }

        return sessionFactory;
    }
}
