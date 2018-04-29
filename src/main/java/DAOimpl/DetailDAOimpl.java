package DAOimpl;

import DAO.DetailDAO;
import Entity.Detail;
import ExecuteProgram.ExecuteProgram;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DetailDAOimpl implements DetailDAO {



     public synchronized void save(Detail detail) {
        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
        session.save(detail);
        System.out.println("success");
        session.getTransaction().commit();
        session.close();
     }

    public List<Detail> select(String query) {
        List<Detail> details;
        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
        Query query1 = session.createQuery(query);
        details = query1.list();
        session.getTransaction().commit();
        session.close();
        return details;
    }

    @Override
    public List<Detail> getAll() {
        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Detail");
        List<Detail> details = query.list();
        session.getTransaction().commit();
        session.close();
        return details;
    }

    @Override
    public void update(Detail detail) {
        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
        session.update(detail);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Detail getDetail(int id) {

        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Detail where id=:id");
        query.setParameter("id",id);
        session.getTransaction().commit();
        session.close();
        return (Detail) query.list().get(0);
    }
}
