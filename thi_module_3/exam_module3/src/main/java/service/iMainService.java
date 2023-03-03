package service;

import model.Main;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface iMainService {
    public Map<String, String> add(Main main);

    public Main select(String id);

    public List<Main> selectAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(Main main) throws SQLException;

    List<Main> search(String giaTien, String tang, String idLoaiMatBang);
}
