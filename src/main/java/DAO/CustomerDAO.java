package DAO;

import Entity.Customer;

public interface CustomerDAO {
    public void insert(Customer customer);
    public void delete(Customer customer);
    public void update(Customer customer);
    public Customer getCustomer(int hash);
}
