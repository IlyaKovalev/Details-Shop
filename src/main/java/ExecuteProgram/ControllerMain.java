package ExecuteProgram;

import DAO.CustomerDAO;
import Entity.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class ControllerMain {

    @FXML PasswordField PasswordField;
    @FXML TextField EmailField;
    @FXML Button LoginButton;
    @FXML Button Sign_Up_Button;
    @FXML Label Error_Notification_Label;

    public static int hash;

    ApplicationContext context = ExecuteProgram.context;

    public void initialize(){

        LoginButton.setOnAction(event->{
            String Email = EmailField.getText();
            String password = PasswordField.getText();
            if (Email=="" || password==""){
                EmailField.clear();
                EmailField.setText("Fill fields!");
            }else{
                CustomerDAO customerDAO = (CustomerDAO)context.getBean("CustomerDAOimpl");
                hash=(Email+password).hashCode();
                Customer customer = customerDAO.getCustomer(hash);
                if (customer==null){
                    Error_Notification_Label.setText("Email or password entered incorrectly");
                }else{
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Workwindow.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                        ExecuteProgram.stage.close();
                    } catch (IOException e) { e.printStackTrace();}

                }
            }
        });

        Sign_Up_Button.setOnAction(actionEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Registration.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Detail Shop - Registration form");
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void Login() {

    }
}
