package reponsitory.impl;

import model.Customer;
import reponsitory.BaseReponsitory;
import reponsitory.iCustomerReponcitory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class customerReponcitoryImpl implements iCustomerReponcitory {
    private static final String INSERT_CUSTOMER_SQL = "insert into khach_hang (ma_hk, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, ma_loai_khach, dia_chi) values (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_CUSTOMER = "select * from khach_hang";
    private final String SEARCH="call search(?,?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select ma_hk,ho_ten,ngay_sinh,gioi_tinh, so_cmnd, so_dien_thoai, email, ma_loai_khach, dia_chi from khach_hang where ma_hk =?";
    private static final String DELETE_CUSTOMER_SQL = "delete from khach_hang where ma_hk = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update khach_hang set ho_ten = ?, ngay_sinh = ?, gioi_tinh = ?, so_cmnd = ?, so_dien_thoai = ?, email = ?, ma_loai_khach = ?, dia_chi =? where ma_hk = ?;";
    @Override
    public void add(Customer customer) throws SQLException {
        Connection connection = BaseReponsitory.getConnectDB();
        PreparedStatement preparedStatement =connection.prepareStatement(INSERT_CUSTOMER_SQL);
        preparedStatement.setInt(1,customer.getId());
        preparedStatement.setString(2,customer.getName());
        preparedStatement.setDate(3, Date.valueOf(customer.getBirthday()));
        preparedStatement.setString(4,customer.getGender());
        preparedStatement.setString(5,customer.getIdCard());
        preparedStatement.setString(6,customer.getPhoneNumber());
        preparedStatement.setString(7,customer.getEmail());
        preparedStatement.setInt(8,customer.getCustomerTypeID());
        preparedStatement.setString(9,customer.getAddress());
        preparedStatement.executeUpdate();
    }

    @Override
    public Customer select(int id) {
        Customer customer = null;
        Connection connection = BaseReponsitory.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String gender = resultSet.getString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                int customerTypeID = resultSet.getInt("ma_loai_khach");
                String address = resultSet.getString("dia_chi");
                customer = new Customer(id, name, birthday, gender, idCard, phoneNumber, email, customerTypeID, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> selectAll() {
        List<Customer>customerList =new ArrayList<>();
        Connection connection = BaseReponsitory.getConnectDB();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ma_hk");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String gender = resultSet.getString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                int customerTypeID = resultSet.getInt("ma_loai_khach");
                String address = resultSet.getString("dia_chi");
                Customer customer = new Customer(id, name, birthday, gender, idCard, phoneNumber, email, customerTypeID, address);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean check;
        try (Connection connection = BaseReponsitory.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            preparedStatement.setInt(1,id);
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        boolean check;
        try (Connection connection = BaseReponsitory.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)){
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setDate(2, Date.valueOf(customer.getBirthday()));
            preparedStatement.setString(3,customer.getGender());
            preparedStatement.setString(4,customer.getIdCard());
            preparedStatement.setString(5,customer.getPhoneNumber());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setInt(7,customer.getCustomerTypeID());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.setInt(9,customer.getId());
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }

    @Override
    public List<Customer> search(String id, String name, String customerType) {
        List<Customer> customerList =new ArrayList<>();
        Connection connection = BaseReponsitory.getConnectDB();
        try {
            CallableStatement callableStatement =connection.prepareCall(SEARCH);
            callableStatement.setString(1, name);
            callableStatement.setString(2, customerType);
            callableStatement.setString(3, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("ma_hk");
                String nameCustomer = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String gender = resultSet.getString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                int customerTypeID = resultSet.getInt("ma_loai_khach");
                String address = resultSet.getString("dia_chi");
                Customer customer = new Customer(idCustomer, nameCustomer, birthday, gender, idCard, phoneNumber, email, customerTypeID, address);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
