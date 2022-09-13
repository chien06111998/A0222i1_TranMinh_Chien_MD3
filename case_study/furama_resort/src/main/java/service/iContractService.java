package service;

import model.Contract;
import model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface iContractService {
    public Map<String, String> add(Contract contract);

    public Contract selectContract(String id);

    public List<Contract> selectAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(Contract contract) throws SQLException;

    List<Contract> search(String idContract, String idCustome);
}
