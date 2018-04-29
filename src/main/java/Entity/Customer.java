package Entity;

import DAO.CustomerDAO;
import DAOimpl.CustomerDAOimpl;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phone_number;

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    int password;

    public Customer(){}

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

