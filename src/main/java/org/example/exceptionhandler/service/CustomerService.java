package org.example.exceptionhandler.service;

import org.example.exceptionhandler.exception.DuplicateEmailException;
import org.example.exceptionhandler.model.Customer;
import org.example.exceptionhandler.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CustomerService implements ICustomerService  {


    @Autowired
     private ICustomerRepository iCustomerRepository;



    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            iCustomerRepository.save(customer);

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }


    @Override
    public Optional findById(Long id) {
        return iCustomerRepository.findById(id);

    }

    @Override
    public void remove(Long id) {
       iCustomerRepository.deleteById(id);
    }
}
