package service.impl;

import common.validation;
import model.Contract;
import model.Customer;
import reponsitory.iContractRepocitory;
import reponsitory.impl.contractRepocitoryImpl;
import service.iContractService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class contractServiceImpl implements iContractService {
    private iContractRepocitory contractRepocitory = new contractRepocitoryImpl();

    @Override
    public Map<String, String> add(Contract contract) {
        Map<String, String> map = new HashMap<>();

        if ("".equals(contract.getId())) {
            map.put("id", "Id contract cannot be empty.");
        } else if (!validation.checkIdContract(contract.getId())) {
            map.put("id", "Email invalidate(HD-xxxx).");
        }
        if (contract.getDeposit() < 0) {
            map.put("deposit","Deposit must be a positive integer");
        }
        if (contract.getTotalMoney() < 0) {
            map.put("totalMoney","Total money must be a positive integer");
        }

        if (map.isEmpty()) {
            try {
                contractRepocitory.add(contract);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public Contract selectContract(String id) {
        return contractRepocitory.select(id);
    }

    @Override
    public List<Contract> selectAll() {
        return contractRepocitory.selectAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return contractRepocitory.delete(id);
    }

    @Override
    public boolean update(Contract contract) throws SQLException {
        return contractRepocitory.update(contract);
    }

    @Override
    public List<Contract> search(String idContract, String idCustome) {
        return contractRepocitory.search(idContract, idCustome);
    }
}
