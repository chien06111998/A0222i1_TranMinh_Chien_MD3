package reponsitory.impl;

import model.Contract;
import model.Customer;
import reponsitory.BaseReponsitory;
import reponsitory.iContractRepocitory;
import service.iContractService;
import service.impl.contractServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class contractRepocitoryImpl implements iContractRepocitory {
    private static final String INSERT_CONTRACT_SQL = "insert into hop_dong (ma_hop_dong, ngay_bat_dau, ngay_ket_thuc, tien_dat_coc, tong_tien, ma_kh) values (?,?,?,?,?,?);";
    private static final String SELECT_ALL_CONTRACT = "select * from hop_dong";
    private final String SEARCH="call searchHD(?,?);";
    private static final String SELECT_CONTRACT_BY_ID = "select ma_hop_dong, ngay_bat_dau, ngay_ket_thuc, tien_dat_coc, tong_tien, ma_kh from hop_dong where ma_hop_dong =?";
    private static final String DELETE_CONTRACT_SQL = "delete from hop_dong where ma_hop_dong = ?;";
    private static final String UPDATE_CONRTACT_SQL = "update hop_dong set ngay_bat_dau = ?, ngay_ket_thuc = ?, tien_dat_coc = ?, tong_tien = ?, ma_kh = ? where ma_hop_dong = ?;";

    @Override
    public void add(Contract contract) throws SQLException {
        Connection connection = BaseReponsitory.getConnectDB();
        PreparedStatement preparedStatement =connection.prepareStatement(INSERT_CONTRACT_SQL);
        preparedStatement.setString(1,contract.getId());
        preparedStatement.setDate(2, Date.valueOf(contract.getStartDate()));
        preparedStatement.setDate(3, Date.valueOf(contract.getEndDate()));
        preparedStatement.setDouble(4,contract.getDeposit());
        preparedStatement.setDouble(5,contract.getTotalMoney());
        preparedStatement.setInt(6,contract.getIdCustomer());
        preparedStatement.executeUpdate();
    }

    @Override
    public Contract select(String id) {
        Contract contract = null;
        Connection connection = BaseReponsitory.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);
            preparedStatement.setString(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String startDate = resultSet.getString("ngay_bat_dau");
                String endDate = resultSet.getString("ngay_ket_thuc");
                double deposit = resultSet.getDouble("tien_dat_coc");
                double totalMoney = resultSet.getDouble("tong_tien");
                int idCustomer = resultSet.getInt("ma_kh");
                contract = new Contract(id, startDate, endDate, deposit, totalMoney, idCustomer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contract;
    }

    @Override
    public List<Contract> selectAll() {
        List<Contract>contractList =new ArrayList<>();
        Connection connection = BaseReponsitory.getConnectDB();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("ma_hop_dong");
                String startDate = resultSet.getString("ngay_bat_dau");
                String endDate = resultSet.getString("ngay_ket_thuc");
                double deposit = resultSet.getDouble("tien_dat_coc");
                double totalMoney = resultSet.getDouble("tong_tien");
                int idCustomer = resultSet.getInt("ma_kh");
                Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, idCustomer);
                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean check;
        try (Connection connection = BaseReponsitory.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_SQL)) {
            preparedStatement.setString(1,id);
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }

    @Override
    public boolean update(Contract contract) throws SQLException {
        boolean check;
        try (Connection connection = BaseReponsitory.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONRTACT_SQL)){
            preparedStatement.setDate(1, Date.valueOf(contract.getStartDate()));
            preparedStatement.setDate(2, Date.valueOf(contract.getEndDate()));
            preparedStatement.setDouble(3,contract.getDeposit());
            preparedStatement.setDouble(4,contract.getTotalMoney());
            preparedStatement.setInt(5,contract.getIdCustomer());
            preparedStatement.setString(6,contract.getId());
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }

    @Override
    public List<Contract> search(String idContract, String idCustomer) {
        List<Contract> contractList =new ArrayList<>();
        Connection connection = BaseReponsitory.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1, idContract);
            callableStatement.setString(2, idCustomer);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("ma_hop_dong");
                String startDate = resultSet.getString("ngay_bat_dau");
                String endDate = resultSet.getString("ngay_ket_thuc");
                double deposit = resultSet.getDouble("tien_dat_coc");
                double totalMoney = resultSet.getDouble("tong_tien");
                int idCustomer1 = resultSet.getInt("ma_kh");
                Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, idCustomer1);
                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }
}
