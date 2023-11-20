package com.example.cargpt.customer.repository;

import com.example.cargpt.customer.domain.Customer;

import java.util.*;


public class MemoryCustomerRepository implements CustomerRepository {
    //일단 동시성 문제 배제
    private static Map<String, Customer> store = new HashMap<>();
//    private static long sequence = 0L;

    @Override
    public Customer save(Customer customer) {
//        customer.setCsmrMgmtNo(++sequence);
        store.put(customer.getCsmrMgmtNo(), customer);
        return customer;
    }

    @Override
    public Optional<Customer> findByCsmrMgmtNo(String csmrMgmtNo) {
        return Optional.ofNullable(store.get(csmrMgmtNo)); //Null일 가능성이 있으므로 Optional로 감싸서 반환
    }


    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(store.values());
    }

    // test 끝나고 store 지울 수 있도록
    public void clearStore() {
        store.clear();
    }
}
