package ExecuteProgram;

import DAO.CustomerDAO;
import Entity.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;

public class ControllerRegistration {

    @FXML
    TextField NameField;
    @FXML
    TextField EmailField;
    @FXML
    TextField PasswordField;
    @FXML
    Button Sign_Up_Button;
    @FXML
    TextField Phone_Number_Field;
    @FXML
    Label Notification_Error_Label;

    ApplicationContext context = ExecuteProgram.context;

    public void initialize(){
        Sign_Up_Button.setOnAction(event->{
            String Name = NameField.getText();
            String Email = EmailField.getText();
            String password = PasswordField.getText();
            String phoneNumber = Phone_Number_Field.getText();
            if (Name!="" && Email!="" && password!="" && phoneNumber!=""){
                int HashPassword = (Email+password).hashCode();
                CustomerDAO customerDAO = (CustomerDAO) context.getBean("CustomerDAOimpl");
                Customer customer = (Customer) ExecuteProgram.context.getBean("Customer");
                    customer.setName(Name);
                    customer.setEmail(Email);
                    customer.setPassword(HashPassword);
                    customer.setPhone_number(phoneNumber);
                customerDAO.insert(customer);
            }else{ Notification_Error_Label.setText("Please, fill all fields");}
        });
    }
}
