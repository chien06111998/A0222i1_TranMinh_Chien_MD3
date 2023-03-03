package service.impl;

import model.Second;
import reponcitory.iSeconReponcitory;
import reponcitory.impl.seconRepocitoryImpl;
import service.iSeconService;

import java.util.List;

public class seconServiceImpl implements iSeconService {
    private iSeconReponcitory seconReponcitory = new seconRepocitoryImpl();

    @Override
    public List<Second> selectAll() {
        return null;
    }
}
