package DAOimpl;

import DAO.CustomerDAO;
import Entity.Customer;
import ExecuteProgram.ExecuteProgram;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;

import java.util.*;

public class CustomerDAOimpl<T> implements CustomerDAO {

    ApplicationContext context = ExecuteProgram.context;


    public void insert(Customer customer) {
        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Customer customer) {
        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Customer customer) {
        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }

    public Customer getCustomer(int hash) {
        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
       try {
            Query query = session.createQuery("from Customer where password =:hash");
            query.setParameter("hash",hash);
            Customer customer= (Customer) query.list().get(0);
            return customer;
       }catch (Exception e){}
       session.getTransaction().commit();
       session.close();
       System.out.println(session.isOpen());
       return (Customer)context.getBean("Customer");
    }
}
