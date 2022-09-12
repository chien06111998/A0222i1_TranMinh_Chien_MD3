package reponsitory;

import model.Customer;
import model.CustomerType;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface iCustomerTypeRepocitory {
    public void add(CustomerType customerType);

    public CustomerType selectCustomer(int id);

    public List<CustomerType> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(CustomerType customerType) throws SQLException;
}
