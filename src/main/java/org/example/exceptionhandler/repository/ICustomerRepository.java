package org.example.exceptionhandler.repository;

import org.example.exceptionhandler.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    //Vì JpaRepository hỗ trợ thêm phân trang, tốt hơn crudRepository



}
