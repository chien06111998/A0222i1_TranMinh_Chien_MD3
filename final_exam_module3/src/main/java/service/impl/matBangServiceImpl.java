package service.impl;
import model.MatBang;
import reponcitory.iMatBang;
import reponcitory.impl.matBangImpl;
import service.iMatBangService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class matBangServiceImpl implements iMatBangService {
    private iMatBang matBang = new matBangImpl();

    @Override
    public Map<String, String> add(MatBang matBang1) {
        Map<String, String> map = new HashMap<>();
        if (map.isEmpty()) {
            try {
                matBang.add(matBang1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public MatBang select(String id) {
        return matBang.select(id);
    }

    @Override
    public List<MatBang> selectAll() {
        return matBang.selectAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return matBang.delete(id);
    }

    @Override
    public boolean update(MatBang matBang1) throws SQLException {
        return matBang.update(matBang1);
    }

    @Override
    public List<MatBang> search(String giaTien, String tang, String idLoaiMatBang) {
        return matBang.search(giaTien, tang, idLoaiMatBang);
    }
}
