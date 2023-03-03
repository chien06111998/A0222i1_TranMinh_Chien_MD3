package reponcitory.impl;

import model.MatBang;
import model.Note;
import model.Type;
import reponcitory.BaseReponcitory;
import reponcitory.iType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class noteRpImpl implements iType {
    private static final String SELECT_ALL = "select * from note_mb;";
    @Override
    public List<Note> selectAll() {
        List<Note>noteList =new ArrayList<>();
        Connection connection = BaseReponcitory.getConnectDB();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt("id");
                String name = resultSet.getString("name");
                Note note = new Note(id, name);
                noteList.add(note);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return noteList;
    }
}
