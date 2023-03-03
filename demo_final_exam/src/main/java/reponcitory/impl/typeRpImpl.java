package reponcitory.impl;

import model.MatBang;
import model.Type;
import reponcitory.BaseReponcitory;
import reponcitory.iType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class typeRpImpl implements iType {
    private static final String SELECT_ALL = "select * from type_mb;";

    @Override
    public List<Type> selectAll() {
        List<Type>typeList =new ArrayList<>();
        Connection connection = BaseReponcitory.getConnectDB();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt("id");
                String name = resultSet.getString("name");
                Type type = new Type(id, name);
                typeList.add(type);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeList;
    }
}
