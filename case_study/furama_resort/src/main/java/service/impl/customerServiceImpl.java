package service.impl;

import model.Customer;
import reponsitory.BaseReponsitory;
import reponsitory.iCustomerReponcitory;
import reponsitory.impl.customerReponcitoryImpl;
import service.iCustomerService;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class customerServiceImpl implements iCustomerService {
    private iCustomerReponcitory customerReponcitory = new customerReponcitoryImpl();

    @Override
    public Map<String, String> add(Customer customer) {
        Map<String, String> map = new HashMap<>();
//        if ("".equals(user.getEmail())) {
//            map.put("email", "Email khong duoc de trong");
//        }
        if (map.isEmpty()) {
            try {
                customerReponcitory.add(customer);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerReponcitory.select(id);
    }

    @Override
    public List<Customer> selectAll() {
        return customerReponcitory.selectAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return customerReponcitory.delete(id);
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return customerReponcitory.update(customer);
    }

    @Override
    public List<Customer> search(String id, String name, String customerType) {
        return customerReponcitory.search(id, name, customerType);
    }
}
