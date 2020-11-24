package app.repository;

import app.entity.User;
import app.entity.UserAuthority;
import app.entity.enums.KnownAuthority;
import app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserAuthorityRepository {
    public void saveUserAuthority (UserAuthority userAuthority){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userAuthority);
        session.getTransaction().commit();
        session.close();
    }

    public UserAuthority findUserAuthorityById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from UserAuthority where id=:id");
        query.setParameter("id", id);
        UserAuthority userAuthority= (UserAuthority) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return userAuthority;
    }

    public UserAuthority findUserAuthorityByAuthority(KnownAuthority knownAuthority){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from UserAuthority where value=:knownAuthority");
        query.setParameter("knownAuthority", knownAuthority);
        UserAuthority userAuthority= (UserAuthority) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return userAuthority;
    }
    public void update(UserAuthority userAuthority){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(userAuthority);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUserById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from UserAuthority where id=:id");
        query.setParameter("id", id);
        UserAuthority user= (UserAuthority) query.uniqueResult();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
