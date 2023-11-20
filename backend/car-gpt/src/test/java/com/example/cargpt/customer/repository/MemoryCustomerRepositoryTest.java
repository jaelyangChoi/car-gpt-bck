package com.example.cargpt.customer.repository;

import com.example.cargpt.customer.domain.CustomerInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryCustomerRepositoryTest {
    MemoryCustomerInfoRepository repository = new MemoryCustomerInfoRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        CustomerInfo customer = new CustomerInfo();
        customer.setCsmrMgmtNo("11111111");
        customer.setSexCd("1");
        customer.setCsmrTymdNo("930701");


        repository.save(customer);

        CustomerInfo result = repository.findByCsmrMgmtNo(customer.getCsmrMgmtNo()).get();
        assertThat(customer).isEqualTo(result);
    }


    @Test
    public void 고객관리번호로_고객상세정보조회(){
        //given
        CustomerInfo customer1 = new CustomerInfo();
        customer1.setCsmrMgmtNo("11111112");
        customer1.setSexCd("1");
        customer1.setCsmrTymdNo("930701");
        repository.save(customer1);

        CustomerInfo customer2 = new CustomerInfo();
        customer2.setCsmrMgmtNo("11111113");
        customer2.setSexCd("0");
        customer2.setCsmrTymdNo("930702");
        repository.save(customer2);

        //when
        CustomerInfo result = repository.findByCsmrMgmtNo("11111112").get();

        //then
        assertThat(result).isEqualTo(customer1);
    }
}