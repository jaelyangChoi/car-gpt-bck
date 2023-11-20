package com.example.cargpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.cargpt.customer.repository.*;
import com.example.cargpt.customer.service.*;

@Configuration
public class SpringConfig {
    //spring data jpa가 생성한 빈을 주입받는다.
    private final CustomerRepository customerRepository;
    private final CustomerInfoRepository customerInfoRepository;

    @Autowired
    public SpringConfig(CustomerRepository customerRepository, CustomerInfoRepository customerInfoRepository) {
        this.customerRepository = customerRepository;
        this.customerInfoRepository = customerInfoRepository;
    }


    @Bean
    public CustomerService customerService() {
        return new CustomerService(customerRepository, customerInfoRepository);//container에 등록되어 있는 빈을 주입
    }


    /* MemoryRepository 테스트용
    @Bean
    public CustomerRepository customerRepository() {
        return new MemoryCustomerRepository();
    }
    */

}
