package service.impl;

import model.MatBang;
import model.Note;
import reponcitory.iType;
import reponcitory.impl.noteRpImpl;
import service.iTypeSr;

import java.util.List;

public class noteSvImpl implements iTypeSr {
    private iType type = new noteRpImpl();
    @Override
    public List<Note> selectAll() {
        return type.selectAll();
    }
}
