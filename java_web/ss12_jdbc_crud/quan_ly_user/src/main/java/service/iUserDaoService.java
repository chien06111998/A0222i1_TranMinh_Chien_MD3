package service;

import model.UserDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface iUserDaoService {
    public Map<String, String> insertUser(UserDao user);

    public UserDao selectUser(int id);

    public List<UserDao> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(UserDao user) throws SQLException;

//    UserDao findById(int id);
}
