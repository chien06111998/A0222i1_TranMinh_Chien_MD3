package service.impl;

import model.customer;
import reponsitory.iCustomerRepository;
import reponsitory.impl.customerRepositoryImpl;
import service.iCustomerService;

import java.util.List;

public class customerServiceImpl implements iCustomerService {
    private iCustomerRepository customerRepository = new customerRepositoryImpl();

    @Override
    public List<customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public customer update(int id, customer customer) {
        return customerRepository.update(id, customer);
    }

    @Override
    public boolean add(customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }


    @Override
    public List<customer> click() {
        return null;
    }
}
