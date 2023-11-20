package com.example.cargpt.customer.service;

import com.example.cargpt.customer.domain.CustomerInfo;
import com.example.cargpt.customer.repository.MemoryCustomerInfoRepository;
import com.example.cargpt.customer.repository.MemoryCustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerServiceTest {
    /* 테스트는 독립적으로 수행되어야 한다. */
    private CustomerService CustomerService;

    private MemoryCustomerRepository CustomerRepository;
    private MemoryCustomerInfoRepository CustomerInfoRepository;


    @BeforeEach
    void beforeEach(){
        CustomerInfoRepository = new MemoryCustomerInfoRepository();
        CustomerService = new CustomerService(CustomerRepository, CustomerInfoRepository);
    }
    @AfterEach
    void afterEach(){
        CustomerInfoRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        CustomerInfo customer = new CustomerInfo();
        customer.setCsmrMgmtNo("11112222");

        //when
        String CsmrMgmtNo = CustomerService.join(customer);

        //then
        CustomerInfo foundCustomer = CustomerService.findOne(CsmrMgmtNo).get();
        assertThat(foundCustomer.getCsmrMgmtNo()).isEqualTo(customer.getCsmrMgmtNo());
    }

}