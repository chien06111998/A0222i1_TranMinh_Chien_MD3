package reponsitory.impl;

import model.Customer;
import model.CustomerType;
import reponsitory.BaseReponsitory;
import reponsitory.iCustomerReponcitory;
import reponsitory.iCustomerTypeRepocitory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class customerTypeRepocitoryImpl implements iCustomerTypeRepocitory {
//private static final String INSERT_CUSTOMER_TYPE_SQL = "insert into loai_khach (ma_loai_khach, ten_loai_khach) values (?,?);";
//    private static final String SELECT_ALL_CUSTOMER_TYPE = "select * from loai_khach";
//    private static final String SELECT_CUSTOMER_TYPE_BY_ID = "select ma_loai_khach,ten_loai_khach from loai_khach where ma_hk =?";
//    private static final String DELETE_CUSTOMER_TYPE_SQL = "delete from loai_khach where ma_loai_khach = ?;";
//    private static final String UPDATE_CUSTOMER_TYPE_SQL = "update loai_khach set ten_loai_khach =? where ma_loai_khach = ?;";
//
//
//    @Override
//    public void add(CustomerType customerType) {
//        Connection connection = BaseReponsitory.getConnectDB();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_TYPE_SQL);
//            preparedStatement.setInt(1, customerType.getIdCustomerType());
//            preparedStatement.setString(2, customerType.getNameCustomerType());
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    @Override
//    public CustomerType selectCustomer(int id) {
//        CustomerType customerType = null;
//        Connection connection = BaseReponsitory.getConnectDB();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE_BY_ID);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                String nameCustomerType = resultSet.getString("ten_loai_khach");
//                customerType = new CustomerType(id, nameCustomerType);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return customerType;
//    }
//
//    @Override
//    public List<CustomerType> selectAll() {
//        List<CustomerType> customerTypeList = new ArrayList<>();
//        Connection connection = BaseReponsitory.getConnectDB();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int idCustomerType = resultSet.getInt("ma_loai_khach");
//                String nameCustomerType = resultSet.getString("ten_loai_khach");
//                CustomerType customerType = new CustomerType(idCustomerType, nameCustomerType);
//                customerTypeList.add(customerType);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return customerTypeList;
//    }
//
//    @Override
//    public boolean delete(int id) throws SQLException {
//        boolean check;
//        try (Connection connection = BaseReponsitory.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_TYPE_SQL)) {
//            preparedStatement.setInt(1,id);
//            check = preparedStatement.executeUpdate() > 0;
//        }
//        return check;
//    }
//
//    @Override
//    public boolean update(CustomerType customerType) throws SQLException {
//        boolean check;
//        try (Connection connection = BaseReponsitory.getConnectDB();
//             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_TYPE_SQL)){
//            preparedStatement.setString(1,customerType.getNameCustomerType());
//            preparedStatement.setInt(2,customerType.getIdCustomerType());
//            check = preparedStatement.executeUpdate() > 0;
//        }
//        return check;
//    }
}
