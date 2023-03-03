package service;

import model.MatBang;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface iMatBangSr {
    public Map<String, String> add(MatBang matBang);

    public MatBang select(String id);

    public List<MatBang> selectAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(MatBang matBang) throws SQLException;

    List<MatBang> search(String giaTien, String tang, String idLoaiMatBang);
}
