package com.example.cargpt.customer.repository;

import com.example.cargpt.customer.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryCustomerRepositoryTest {
    MemoryCustomerRepository repository = new MemoryCustomerRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Customer customer = new Customer();
        customer.setCsmrMgmtNo("11111111");
        customer.setSexCd("1");
        customer.setCsmrTymdNo("930701");


        repository.save(customer);

        Customer result = repository.findByCsmrMgmtNo(customer.getCsmrMgmtNo()).get();
        assertThat(customer).isEqualTo(result);
    }

    @Test
    public void findByCsmrMgmtNo(){
        Customer customer1 = new Customer();
        customer1.setCsmrMgmtNo("11111112");
        customer1.setSexCd("1");
        customer1.setCsmrTymdNo("930701");
        repository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setCsmrMgmtNo("11111113");
        customer2.setSexCd("0");
        customer2.setCsmrTymdNo("930702");
        repository.save(customer2);

        Customer result = repository.findByCsmrMgmtNo("11111112").get();

        assertThat(result).isEqualTo(customer1);
    }
}