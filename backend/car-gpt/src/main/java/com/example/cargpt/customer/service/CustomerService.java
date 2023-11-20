package com.example.cargpt.customer.service;

import com.example.cargpt.customer.domain.Customer;
import com.example.cargpt.customer.repository.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.cargpt.customer.domain.CustomerInfo;
import com.example.cargpt.customer.repository.CustomerInfoRepository;

import java.util.List;
import java.util.Optional;

@Transactional //JPA를 쓰려면 Transaction이 있어야 함 (데이터 저장, 변경할 때 필요)
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerInfoRepository customerInfoRepository;

    public CustomerService(CustomerRepository customerRepository, CustomerInfoRepository customerInfoRepository) {
        this.customerRepository = customerRepository;
        this.customerInfoRepository = customerInfoRepository;
    }

    /**
     * 전체 고객 리스트 조회
     *
     * @return
     */
    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }

    /**
     * 고객 정보 조회
     *
     * @param csmrMgmtNo
     * @return
     */
    public Optional<CustomerInfo> findOne(String csmrMgmtNo) {
        return customerInfoRepository.findByCsmrMgmtNo(csmrMgmtNo);
    }


    /**
     * 고객 등록
     *
     * @param customer
     * @return
     */
    public String join(CustomerInfo customer) {
        validateDuplicateMember(customer); //같은 이름이 있는 중복 회원x
        customerInfoRepository.save(customer);
        return customer.getCsmrMgmtNo();
    }

    /**
     * 고객 등록 유효성 검증
     *
     * @param customer
     */
    private void validateDuplicateMember(CustomerInfo customer) {
        customerInfoRepository.findByCsmrMgmtNo(customer.getCsmrMgmtNo())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 고객관리번호입니다.");
                });
    }
}
