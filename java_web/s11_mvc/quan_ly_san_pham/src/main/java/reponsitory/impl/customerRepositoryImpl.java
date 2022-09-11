package reponsitory.impl;

import model.customer;
import reponsitory.iCustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class customerRepositoryImpl implements iCustomerRepository {
    private static List<customer> customerList = new ArrayList<>();

    static {
        customerList.add(new customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerList.add(new customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customerList.add(new customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customerList.add(new customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customerList.add(new customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customerList.add(new customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<customer> findAll() {
        return customerList;
    }

    @Override
    public customer findById(int id) {
        return customerList.stream().filter(e -> e.getId() == id).findAny().get();
    }

    @Override
    public customer update(int id, customer customer) {
        return customerList.set(id, customer);
    }

    @Override
    public boolean add(customer customer) {
        return customerList.add(customer);
    }

    @Override
    public boolean delete(int id) {
        for(int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                customerList.remove(i);
                break;
            }
        }
        return true;
    }


    @Override
    public List<customer> click() {
        return null;
    }
}
