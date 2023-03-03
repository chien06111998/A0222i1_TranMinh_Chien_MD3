package reponcitory;

import model.MatBang;
import model.Type;

import java.util.List;

public interface iType<E> {
    public List<E> selectAll();
}
