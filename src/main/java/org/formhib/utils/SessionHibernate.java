package org.formhib.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.Date;

public class SessionHibernate {

    public static final ThreadLocal<Session> threadSession = new ThreadLocal<>();
    public static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    static {
        try{
            System.out.println(new Date() + "initialisation de la session");
            Configuration configuration = new Configuration().configure();
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);
        } catch ( Throwable e) {

            e.printStackTrace();
        }
    }

    public static Session currentSession(){

        Session session = (Session) threadSession.get();

        if (session == null){
            System.out.println("je n'ai pas de session active");
            System.out.println("j'ouvre nouvelle session");

            session= sessionFactory.openSession();
            System.out.println("j'injecte session dans thread en cours");
            threadSession.set(session);
        }

        System.out.println("j'ai bien recup ma session");
        return session;
    }

    public static void closeSession(){
        Session session= threadSession.get();
        if(session != null ) session.close();

        threadSession.set(null);
        System.out.println("j'ai bien fermé la session");
    }

}
