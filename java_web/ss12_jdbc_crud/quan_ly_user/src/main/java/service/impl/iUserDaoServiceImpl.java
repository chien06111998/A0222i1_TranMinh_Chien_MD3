package service.impl;

import model.UserDao;
import reponsitory.iUserDaoReponsitory;
import reponsitory.impl.iUserDaoReponsitoryImpl;
import service.iUserDaoService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iUserDaoServiceImpl implements iUserDaoService {
    private iUserDaoReponsitory userDaoReponsitory = new iUserDaoReponsitoryImpl();


    @Override
    public Map<String, String> insertUser(UserDao user) {
        Map<String, String> map = new HashMap<>();
        if ("".equals(user.getEmail())) {
            map.put("email", "Email khong duoc de trong");
        }
        if (map.isEmpty()) {
            try {
                userDaoReponsitory.insertUser(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public UserDao selectUser(int id) {
        return userDaoReponsitory.selectUser(id);
    }

    @Override
    public List<UserDao> selectAllUsers() {
        return userDaoReponsitory.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userDaoReponsitory.deleteUser(id);
    }

    @Override
    public boolean updateUser(UserDao user) throws SQLException {
        return userDaoReponsitory.updateUser(user);
    }

//    @Override
//    public UserDao findById(int id) {
//        return userDaoReponsitory.findById(id);
//    }
}
