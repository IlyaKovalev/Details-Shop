package DAOimpl;

import DAO.Shopping_listDAO;
import Entity.Shopping_list;
import ExecuteProgram.ExecuteProgram;
import org.hibernate.Session;

public class Shopping_listDAOimpl implements Shopping_listDAO {

    @Override
    public void insert(Shopping_list shopping_list) {
        Session session = ExecuteProgram.session.openSession();
        session.beginTransaction();
        session.save(shopping_list);
        session.getTransaction().commit();
        session.close();
    }
}
