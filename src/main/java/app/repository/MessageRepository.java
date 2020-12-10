package app.repository;

import app.entity.Mentor;
import app.entity.Message;
import app.entity.User;
import app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MessageRepository {
    public void saveMessage (Message message) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(message);
        session.getTransaction().commit();
        session.close();
    }

    public User findMessageById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from Message where id=:id");
        query.setParameter("id", id);
        User user= (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }


    public void deleteMessageById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from Message where id=:id");
        query.setParameter("id", id);
        User user= (User) query.uniqueResult();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
