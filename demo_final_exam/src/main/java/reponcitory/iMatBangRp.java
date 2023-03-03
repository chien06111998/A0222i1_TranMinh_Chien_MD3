package reponcitory;

import model.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface iMatBangRp {
    public void add(MatBang matBang) throws SQLException;

    public MatBang select(String id);

    public List<MatBang> selectAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(MatBang matBang) throws SQLException;

//    public boolean update(MatBang matBang) throws SQLException;

    List<MatBang> search(String giaTien, String tang, String idLoaiMatBang);
}
