package reponcitory;

import model.Main;

import java.sql.SQLException;
import java.util.List;

public interface iMainReponcitory {
    public void add(Main main) throws SQLException;

    public Main select(String id);

    public List<Main> selectAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(Main main) throws SQLException;

    List<Main> search(String giaTien, String tang, String idLoaiMatBang);
}
