package reponcitory.impl;

import model.MatBang;
import reponcitory.BaseReponcitory;
import reponcitory.iMatBangRp;
import utils.validation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class matBangRpImpl implements iMatBangRp {
    private static final String INSERT_SQL = "insert into mat_bang (ma_mb, id_trang_thai, dien_tich, so_tang, id_loai_mb, mo_ta, gia_tien, ngay_thue,ngay_tra) values (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL = "select * from mat_bang";
    private final String SEARCH = "call search(?,?,?);";
    private static final String SELECT_BY_ID = "select ma_mb, id_trang_thai, dien_tich, so_tang, id_loai_mb, mo_ta, gia_tien, ngay_thue,ngay_tra from mat_bang where ma_mb =?";
    private static final String DELETE_SQL = "delete from mat_bang where ma_mb = ?;";
    private static final String UPDATE_SQL = "update mat_bang set id_trang_thai = ?, dien_tich = ?, so_tang = ?, id_loai_mb = ?, mo_ta = ?, gia_tien = ?, ngay_thue = ?,ngay_tra = ? where ma_mb = ?;";

    @Override
    public void add(MatBang matBang) throws SQLException {
        Connection connection = BaseReponcitory.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
        preparedStatement.setString(1, matBang.getId());
        preparedStatement.setInt(2, matBang.getIdNote());
        preparedStatement.setInt(3, matBang.getArea());
        preparedStatement.setInt(4, matBang.getSoTang());
        preparedStatement.setInt(5, matBang.getIdType());
        preparedStatement.setString(6, matBang.getNote());
        preparedStatement.setInt(7, matBang.getPrice());
        preparedStatement.setDate(8, Date.valueOf(matBang.getStartDate()));
        preparedStatement.setDate(9, Date.valueOf(matBang.getEndDate()));
        preparedStatement.executeUpdate();
    }

    @Override
    public MatBang select(String id) {
        MatBang matBang = null;
        Connection connection = BaseReponcitory.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setString(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_trang_thai = Integer.parseInt(resultSet.getString("id_trang_thai"));
                int dien_tich = Integer.parseInt(resultSet.getString("dien_tich"));
                int so_tang = Integer.parseInt(resultSet.getString("so_tang"));
                int id_loai_mb = Integer.parseInt(resultSet.getString("id_loai_mb"));
                String mo_ta = resultSet.getString("mo_ta");
                int gia_tien = Integer.parseInt(resultSet.getString("gia_tien"));
                String ngay_thue = resultSet.getString("ngay_thue");
                String ngay_tra = resultSet.getString("ngay_tra");
                 matBang = new MatBang(id, id_trang_thai, dien_tich, so_tang, id_loai_mb, mo_ta, gia_tien, ngay_thue, ngay_tra);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBang;
    }

    @Override
    public List<MatBang> selectAll() {
        List<MatBang> matBangList = new ArrayList<>();
        Connection connection = BaseReponcitory.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("ma_mb");
                int id_trang_thai = Integer.parseInt(resultSet.getString("id_trang_thai"));
                int dien_tich = Integer.parseInt(resultSet.getString("dien_tich"));
                int so_tang = Integer.parseInt(resultSet.getString("so_tang"));
                int id_loai_mb = Integer.parseInt(resultSet.getString("id_loai_mb"));
                String mo_ta = resultSet.getString("mo_ta");
                int gia_tien = Integer.parseInt(resultSet.getString("gia_tien"));
//                String ngay_thue = resultSet.getString("ngay_thue");
//                ngay_thue = String.valueOf(validation.formatDate(ngay_thue));
//                String ngay_tra = resultSet.getString("ngay_tra");
//                ngay_tra = String.valueOf(validation.formatDate(ngay_tra));
                String ngay_thue = resultSet.getString("ngay_thue");
                String ngay_tra = resultSet.getString("ngay_tra");
                MatBang matBang = new MatBang(id, id_trang_thai, dien_tich, so_tang, id_loai_mb, mo_ta, gia_tien, ngay_thue, ngay_tra);
                matBangList.add(matBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean check;
        try (Connection connection = BaseReponcitory.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setString(1,id);
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }

    @Override
    public boolean update(MatBang matBang) throws SQLException {
        boolean check;
        try (Connection connection = BaseReponcitory.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setInt(1, matBang.getIdNote());
            preparedStatement.setInt(2, matBang.getArea());
            preparedStatement.setInt(3, matBang.getSoTang());
            preparedStatement.setInt(4, matBang.getIdType());
            preparedStatement.setString(5, matBang.getNote());
            preparedStatement.setInt(6, matBang.getPrice());
            preparedStatement.setDate(7, Date.valueOf(matBang.getStartDate()));
            preparedStatement.setDate(8, Date.valueOf(matBang.getEndDate()));
            preparedStatement.setString(9, matBang.getId());
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }

    @Override
    public List<MatBang> search(String giaTien, String tang, String idLoaiMatBang) {
        List<MatBang> matBangList = new ArrayList<>();
        Connection connection = BaseReponcitory.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1, giaTien);
            callableStatement.setString(2, tang);
            callableStatement.setString(3, idLoaiMatBang);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("ma_mb");
                int id_trang_thai = Integer.parseInt(resultSet.getString("id_trang_thai"));
                int dien_tich = Integer.parseInt(resultSet.getString("dien_tich"));
                int so_tang = Integer.parseInt(resultSet.getString("so_tang"));
                int id_loai_mb = Integer.parseInt(resultSet.getString("id_loai_mb"));
                String mo_ta = resultSet.getString("mo_ta");
                int gia_tien = Integer.parseInt(resultSet.getString("gia_tien"));
                String ngay_thue = resultSet.getString("ngay_thue");
                String ngay_tra = resultSet.getString("ngay_tra");
                MatBang matBang = new MatBang(id, id_trang_thai, dien_tich, so_tang, id_loai_mb, mo_ta, gia_tien, ngay_thue, ngay_tra);
                matBangList.add(matBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangList;
    }
}
