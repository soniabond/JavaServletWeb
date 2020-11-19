package app.repository;

import app.entity.User;
import app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserRepository{
    public void saveUser (User user){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User findUserById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from User where id=:id");
        query.setParameter("id", id);
        User user= (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }
    public void update(User user){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteHeroes(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from User where id=:id");
        query.setParameter("id", id);
        User user= (User) query.uniqueResult();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
