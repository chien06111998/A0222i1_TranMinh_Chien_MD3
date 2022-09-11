package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface iCustomerService {
    public Map<String, String> add(Customer user);

    public Customer selectCustomer(int id);

    public List<Customer> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(Customer customer) throws SQLException;
}
