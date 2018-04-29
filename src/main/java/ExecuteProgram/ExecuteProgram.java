package ExecuteProgram;

import DAO.DetailDAO;
import DAOimpl.DetailDAOimpl;
import Entity.Detail;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.HibernateUtil;

import java.util.Iterator;
import java.util.List;

public class ExecuteProgram extends Application {

    public static ApplicationContext context;

    public static final SessionFactory session = HibernateUtil.getSessionFactory();

    public static void main(String[] args){ launch(args);}

    public  static Stage stage;


    public void start(Stage stage) throws Exception {

        context = new ClassPathXmlApplicationContext(
                "Spring-Module.xml");
        
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/MainWindow.fxml"));
        Scene scene = new Scene(root);

        this.stage = stage;
        this.stage.setTitle("Detail Shop");
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.show();
    }
}
