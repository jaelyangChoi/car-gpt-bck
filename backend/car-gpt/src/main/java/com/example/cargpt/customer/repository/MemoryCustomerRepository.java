package com.example.cargpt.customer.repository;

import com.example.cargpt.customer.domain.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryCustomerRepository implements CustomerRepository{
    private static Map<String, Customer> store = new HashMap<>();

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(store.values());
    }
}
