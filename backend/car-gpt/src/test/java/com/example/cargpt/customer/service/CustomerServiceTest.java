package com.example.cargpt.customer.service;

import com.example.cargpt.customer.domain.Customer;
import com.example.cargpt.customer.repository.MemoryCustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerServiceTest {
    /* 테스트는 독립적으로 수행되어야 한다. */
    private CustomerService CustomerService;
    private MemoryCustomerRepository CustomerRepository;

    @BeforeEach
    void beforeEach(){
        CustomerRepository = new MemoryCustomerRepository();
        CustomerService = new CustomerService(CustomerRepository);
    }
    @AfterEach
    void afterEach(){
        CustomerRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Customer customer = new Customer();
        customer.setCsmrMgmtNo("11112222");

        //when
        String CsmrMgmtNo = CustomerService.join(customer);

        //then
        Customer foundCustomer = CustomerService.findOne(CsmrMgmtNo).get();
        assertThat(foundCustomer.getCsmrMgmtNo()).isEqualTo(customer.getCsmrMgmtNo());
    }

}