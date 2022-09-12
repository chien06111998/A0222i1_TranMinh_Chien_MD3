package service.impl;
import model.CustomerType;
import reponsitory.iCustomerTypeRepocitory;
import reponsitory.impl.customerTypeRepocitoryImpl;
import service.iCustomerTypeService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class customerTypeServiceImpl implements iCustomerTypeService {
    private iCustomerTypeRepocitory customerTypeRepocitory = new customerTypeRepocitoryImpl();

    @Override
    public Map<String, String> add(CustomerType customerType) {
        Map<String, String> map = new HashMap<>();
//        if ("".equals(user.getEmail())) {
//            map.put("email", "Email khong duoc de trong");
//        }
        if (map.isEmpty()) {
            customerTypeRepocitory.add(customerType);
        }
        return map;
    }

    @Override
    public CustomerType selectCustomer(int id) {
        return customerTypeRepocitory.selectCustomer(id);
    }

    @Override
    public List<CustomerType> selectAll() {
        return customerTypeRepocitory.selectAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return customerTypeRepocitory.delete(id);
    }

    @Override
    public boolean update(CustomerType customerType) throws SQLException {
        return customerTypeRepocitory.update(customerType);
    }
}
