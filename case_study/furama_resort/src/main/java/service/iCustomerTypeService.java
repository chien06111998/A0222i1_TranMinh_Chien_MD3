package service;

import model.Customer;
import model.CustomerType;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface iCustomerTypeService {
    public Map<String, String> add(CustomerType customer);

    public CustomerType selectCustomer(int id);

    public List<CustomerType> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(CustomerType customer) throws SQLException;
}
