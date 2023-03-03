package service.impl;

import model.MatBang;
import reponcitory.iMatBangRp;
import reponcitory.impl.matBangRpImpl;
import service.iMatBangSr;
import utils.validation;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class matBangSvImpl implements iMatBangSr {
    private iMatBangRp matBangRp = new matBangRpImpl();
    @Override
    public Map<String, String> add(MatBang matBang) {
        Map<String, String> map = new HashMap<>();
//        Validation:
//        id:
        if (!validation.checkIdExists(matBang.getId())) {
            map.put("idExists", "Id already exist.");
        }
        if ("".equals(matBang.getId())) {
            map.put("id", "Id contract cannot be empty.");
        } else if (!validation.checkId(matBang.getId())) {
            map.put("id", "Email invalidate(HD-xx).");
        }
        if (matBang.getArea() < 20) {
            map.put("area","Area > 20.");
        }
        if (matBang.getPrice() < 1000000) {
            map.put("price","Area > 1000000.");
        }
        if (matBang.getSoTang() < 0) {
            map.put("soTang","So Tang > 0.");
        }
//        validate date
        if (validation.checkDate(matBang.getStartDate(), matBang.getEndDate())) {
            map.put("date", "Payment date is greater than 6 month rental date.");
        }


        if (map.isEmpty()) {
            try {
                matBangRp.add(matBang);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public MatBang select(String id) {
        return matBangRp.select(id);
    }

    @Override
    public List<MatBang> selectAll() {
        return matBangRp.selectAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return matBangRp.delete(id);
    }

    @Override
    public boolean update(MatBang matBang) throws SQLException {
        return matBangRp.update(matBang);
    }

    @Override
    public List<MatBang> search(String giaTien, String tang, String idLoaiMatBang) {
        return matBangRp.search(giaTien, tang, idLoaiMatBang);
    }
}
