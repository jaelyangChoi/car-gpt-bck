package com.example.cargpt.customer.controller;


import com.example.cargpt.customer.domain.Customer;
import com.example.cargpt.customer.domain.CustomerInfo;
import com.example.cargpt.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /** todo : json으로 던져주기
     * 전체 고객 리스트 조회
     * @param
     * @return json
     */
    @GetMapping
    public List<Customer> CustomerList() {
        log.debug("@GetMapping(\"/customers\")");
        List<Customer> customers = customerService.findCustomers();
        log.debug("customers size : {}", customers.size());

        return customers;
    }

    /**
     * 고객 정보 조회
     * @param csmrMgmtNo
     * @return
     */
    @GetMapping("/{csmrMgmtNo}")
    public CustomerInfo CustomerInfo(@PathVariable String csmrMgmtNo) {
        log.debug("@GetMapping(\"/customers/{csmrMgmtNo}\")");
        CustomerInfo customer = customerService.findOne(csmrMgmtNo).get();
        log.debug("customer : {}", customer.toString());

        return customer;
    }


    /**
     * 고객 등록
     * @param form
     * @return
     */
    /*
    @PostMapping("/new")
    public String create(@ModelAttribute CustomerForm form, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        customer.setName(form.getName());

        customerService.join(customer);
        redirectAttributes.addAttribute("csmrMgmtNo", customer.getCsmrMgmtNo());
        redirectAttributes.addAttribute("status", true); //남은 속성값은 쿼리파라미터 형식으로 들어감
        return "redirect:/customers/{csmrMgmtNo}"; //redirectAttribute의 값을 넣어줌. url 인코딩 문제 해결.
    }
    */
}

