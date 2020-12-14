package app.repository;

import app.entity.Mentor;
import app.entity.ProgrammingLang;
import app.entity.User;
import app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProgrammingLangsRepository {
    public void save (ProgrammingLang programmingLang){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(programmingLang);
        session.getTransaction().commit();
        session.close();
    }

    public ProgrammingLang findLangById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from ProgrammingLang where id=:id");
        query.setParameter("id", id);
        ProgrammingLang user= (ProgrammingLang) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public void updateLang(ProgrammingLang lang){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(lang);
        session.getTransaction().commit();
        session.close();
    }

    public ProgrammingLang findLangByName(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from ProgrammingLang where name=:name");
        query.setParameter("name", name);
        ProgrammingLang user= (ProgrammingLang) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }
    public List<ProgrammingLang> findAllLangs(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("select l from ProgrammingLang l", ProgrammingLang.class).getResultList();
    }

    public void deleteProgrammingLangById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from ProgrammingLang where id=:id");
        query.setParameter("id", id);
        ProgrammingLang programmingLang = (ProgrammingLang) query.uniqueResult();
        session.delete(programmingLang);
        session.getTransaction().commit();
        session.close();
    }
}
