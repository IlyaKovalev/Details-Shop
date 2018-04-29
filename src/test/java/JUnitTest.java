import DAO.CustomerDAO;
import DAO.DetailDAO;
import Entity.Customer;
import Entity.Detail;
import Entity.Shopping_list;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JUnitTest extends Assert {

    private final int hash = -1530912774;

    ApplicationContext context = new ClassPathXmlApplicationContext(
            "Spring-Module.xml");

    private final CustomerDAO customerDAO =(CustomerDAO)context.getBean("CustomerDAOimpl");
    private final DetailDAO detailDAO = (DetailDAO) context.getBean("DetailDAOimpl");
    private final DetailDAO detailDAO1 = (DetailDAO) context.getBean("DetailDAOimpl");
    private final Shopping_list shopping_list = (Shopping_list) context.getBean("list");

    @Test
    public void customerDAOTest(){
        Customer customer = customerDAO.getCustomer(hash);
        String Email = customer.getEmail();
        assertEquals("REX@mail.ru",Email);
    }

    @Test
    public void detailDAOTEST(){
        Detail detail = detailDAO.getDetail(1);
        assertEquals("Hammer",detail.getName());
    }

    @Test
    public void TestShoppingList(){
        assertEquals("LOL",shopping_list.getCustomer().getName());
    }

}
