package reponcitory.impl;

import model.Second;
import reponcitory.BaseReponcitory;
import reponcitory.iSeconReponcitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class seconRepocitoryImpl implements iSeconReponcitory {
    private static final String SELECT_ALL = "select * from type_mb;";

    @Override
    public List selectAll() {
        List<Second>secondList =new ArrayList<>();
        Connection connection = BaseReponcitory.getConnectDB();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt("id");
                String name = resultSet.getString("name");
                Second second = new Second(id, name);
                secondList.add(second);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return secondList;
    }
}
