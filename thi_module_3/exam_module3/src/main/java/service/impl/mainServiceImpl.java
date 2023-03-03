package service.impl;

import model.Main;
import reponcitory.iMainReponcitory;
import reponcitory.impl.mainRepocitoryImpl;
import service.iMainService;
import ultis.validation;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mainServiceImpl implements iMainService {
    private iMainReponcitory mainReponcitory = new mainRepocitoryImpl();

    @Override
    public Map<String, String> add(Main main) {
        Map<String, String> map = new HashMap<>();
//        Validation:
//        id:
//        if (!validation.checkIdExists(main.getId())) {
//            map.put("idExists", "Id already exist.");
//        }
//        if ("".equals(main.getId())) {
//            map.put("id", "Id contract cannot be empty.");
//        } else if (!validation.checkId(main.getId())) {
//            map.put("id", "Email invalidate(HD-xx).");
//        }
//        if (main.getArea() < 20) {
//            map.put("area","Area > 20.");
//        }
//        if (main.getPrice() < 1000000) {
//            map.put("price","Area > 1000000.");
//        }
//        if (main.getSoTang() < 0) {
//            map.put("soTang","So Tang > 0.");
//        }
////        validate date
//        if (validation.checkDate(main.getStartDate(), main.getEndDate())) {
//            map.put("date", "Payment date is greater than 6 month rental date.");
//        }



        if (map.isEmpty()) {
            try {
                mainReponcitory.add(main);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public Main select(String id) {
        return mainReponcitory.select(id);
    }

    @Override
    public List<Main> selectAll() {
        return mainReponcitory.selectAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return mainReponcitory.delete(id);
    }

    @Override
    public boolean update(Main main) throws SQLException {
        return mainReponcitory.update(main);
    }

    @Override
    public List<Main> search(String giaTien, String tang, String idLoaiMatBang) {
        return mainReponcitory.search(giaTien, tang, idLoaiMatBang);
    }
}
