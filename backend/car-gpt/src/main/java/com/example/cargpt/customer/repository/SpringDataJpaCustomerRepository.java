package com.example.cargpt.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cargpt.customer.domain.Customer;

import java.util.Optional;

public interface SpringDataJpaCustomerRepository extends JpaRepository<Customer, String>, CustomerRepository {

    //MemberRepository에는 이미 똑같은 시그니처의 메서드가 선언되어 있으므로 생략 가능
    @Override
    Optional<Customer> findByCsmrMgmtNo(String csmrMgmtNo);
}