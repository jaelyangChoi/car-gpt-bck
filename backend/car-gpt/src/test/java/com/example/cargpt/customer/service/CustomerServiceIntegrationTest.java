package com.example.cargpt.customer.service;

import com.example.cargpt.customer.domain.Customer;
import com.example.cargpt.customer.domain.CustomerInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class CustomerServiceIntegrationTest {
    @Autowired private CustomerService customerService;


    @Test
    void 고객전체조회(){
        /*
        //given
        Customer customer1 = new Customer();
        customer1.setCsmrMgmtNo("11112222");
        customer1.setSexCd("1");
        customer1.setCsmrTymdNo("930701");
        customer1.setExrsEeEeno("1186500");
        customer1.setIpeEeno("1186500");
        customer1.setChgrEeno("1186500");
        customerService.join(customer1);

        Customer customer2 = new Customer();
        customer2.setCsmrMgmtNo("11113333");
        customer2.setSexCd("0");
        customer2.setCsmrTymdNo("960701");
        customer2.setExrsEeEeno("E186500");
        customer2.setIpeEeno("E186500");
        customer2.setChgrEeno("E186500");
        customerService.join(customer2);
        */
        //when
        List<Customer> customers = customerService.findCustomers();

        //then
        customers.forEach(c->System.out.println(c.getCsmrMgmtNo() + "(" + c.getCsmrNm() + ")"));
        Assertions.assertThat(customers.size()).isEqualTo(1);
    }

    @Test
    void 고객관리번호로조회(){
        //given
        /*
        Customer customer1 = new Customer();
        customer1.setCsmrMgmtNo("11112222");
        customer1.setSexCd("1");
        customer1.setCsmrTymdNo("930701");
        customer1.setExrsEeEeno("1186500");
        customer1.setIpeEeno("1186500");
        customer1.setChgrEeno("1186500");
        String csmrMgmtNo1 = customerService.join(customer1);

        Customer customer2 = new Customer();
        customer2.setCsmrMgmtNo("11113333");
        customer2.setSexCd("0");
        customer2.setCsmrTymdNo("960701");
        customer2.setExrsEeEeno("E186500");
        customer2.setIpeEeno("E186500");
        customer2.setChgrEeno("E186500");
        String csmrMgmtNo2 = customerService.join(customer2);
        */
        String savedCsmrMgmtNo = "A202311190000001";
        //when
        CustomerInfo foundCustomer = customerService.findOne(savedCsmrMgmtNo).get();

        //then
        System.out.println(foundCustomer.getCsmrMgmtNo());
        Assertions.assertThat(foundCustomer.getCsmrMgmtNo()).isEqualTo(savedCsmrMgmtNo);
    }

}