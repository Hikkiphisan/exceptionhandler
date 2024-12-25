package org.example.exceptionhandler.service;

import org.example.exceptionhandler.exception.DuplicateEmailException;
import org.example.exceptionhandler.model.Customer;

import java.util.List;
import java.util.Optional;


public interface IGenerateService<T> {
    List<T> findAll();

    void save(T t) throws DuplicateEmailException;

    Optional<T> findById(Long id);

    void remove(Long id);
}