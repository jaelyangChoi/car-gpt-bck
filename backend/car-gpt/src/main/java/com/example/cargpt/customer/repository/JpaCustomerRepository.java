package com.example.cargpt.customer.repository;

import com.example.cargpt.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<Customer, String>, CustomerRepository {
}
