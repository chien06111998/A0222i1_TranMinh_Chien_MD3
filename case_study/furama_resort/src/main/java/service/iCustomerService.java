package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface iCustomerService {
    public Map<String, String> add(Customer customer);

    public Customer selectCustomer(int id);

    public List<Customer> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(Customer customer) throws SQLException;

    List<Customer> search(String id, String name, String customerType);
}
