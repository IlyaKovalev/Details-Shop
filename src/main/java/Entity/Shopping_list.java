package Entity;

import Entity.*;
import javafx.scene.control.ListCell;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Shopping_list")
public class Shopping_list {

    @Id
    @Column(name = "id")
    private int id;

    @Autowired
    @OneToOne
    @JoinColumn(name = "CustomerEmail")
    private Customer customer;

    @Autowired
    @OneToOne
    @JoinColumn(name = "detailID")
    private Detail detailID;

    @Column(name = "count")
    Integer count;

    public Shopping_list(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerEmail) {
        customer = customerEmail;
    }

    public Detail getDetailID() {
        return detailID;
    }

    public void setDetailID(Detail detailID) {
        this.detailID = detailID;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
