package service.impl;

import model.MatBang;
import model.Type;
import reponcitory.iType;
import reponcitory.impl.typeRpImpl;
import service.iTypeSr;

import java.util.List;

public class typeSvImpl implements iTypeSr {
    private iType type = new typeRpImpl();
    @Override
    public List<Type> selectAll() {
        return type.selectAll();
    }
}
