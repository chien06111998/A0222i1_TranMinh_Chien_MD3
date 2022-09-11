package reponsitory;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface iCustomerReponcitory {
    public void add(Customer customer) throws SQLException;

    public Customer select(int id);

    public List<Customer> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(Customer customer) throws SQLException;
}
