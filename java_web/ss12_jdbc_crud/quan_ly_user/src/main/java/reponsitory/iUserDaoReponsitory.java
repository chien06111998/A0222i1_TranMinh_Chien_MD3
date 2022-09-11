package reponsitory;

import model.UserDao;

import java.sql.SQLException;
import java.util.List;

public interface iUserDaoReponsitory {
    public void insertUser(UserDao user) throws SQLException;

    public UserDao selectUser(int id);

    public List<UserDao> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(UserDao user) throws SQLException;

}
