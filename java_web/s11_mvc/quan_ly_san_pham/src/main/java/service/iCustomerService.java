package service;

import model.customer;

import java.util.List;

public interface iCustomerService {
    List<customer> findAll();
    customer findById(int id);
    customer update(int id, customer customer);
    boolean add(customer customer);
    boolean delete(int id);
    List<customer> click();
}
