package com.example.cargpt.customer.repository;

import com.example.cargpt.customer.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
}
