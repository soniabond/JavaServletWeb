package app.repository;

import app.entity.Mentor;
import app.entity.User;
import app.entity.UserAuthority;
import app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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

    public User findUserByEmail(String mail){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from User where mail=:mail");
        query.setParameter("mail", mail);
        User user= (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public void updateUser(User user){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }


    public List<Mentor> findAllMentors(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("select m from Mentor m", Mentor.class).getResultList();
    }

    public void deleteUserById(int id){
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
