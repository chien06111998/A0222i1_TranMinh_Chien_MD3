package reponsitory;

import model.Contract;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface iContractRepocitory {
    public void add(Contract contract) throws SQLException;

    public Contract select(String id);

    public List<Contract> selectAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(Contract contract) throws SQLException;

    List<Contract> search(String idContract, String idCustomer);
}
