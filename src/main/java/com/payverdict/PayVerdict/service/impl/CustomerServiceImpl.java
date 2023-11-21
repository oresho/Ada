package com.payverdict.PayVerdict.service.impl;

import com.payverdict.PayVerdict.model.entity.Customer;
import com.payverdict.PayVerdict.model.request.CustomerRegistrationDto;
import com.payverdict.PayVerdict.model.response.CustomerResponse;
import com.payverdict.PayVerdict.repository.CustomerRepository;
import com.payverdict.PayVerdict.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public CustomerResponse create(CustomerRegistrationDto customerRegistrationDto) {
        Customer savedCustomer = customerRepository.save(mapToCustomer(customerRegistrationDto));
        return mapToCustomerResponse(savedCustomer);
    }

    private Customer mapToCustomer(CustomerRegistrationDto customerRegistrationDto){
        Customer customer = new Customer();
        customer.setFullName(customerRegistrationDto.getFirstname()+" "+ customerRegistrationDto.getLastname());
        customer.setEmail(customerRegistrationDto.getEmail());
        customer.setPhoneNo(customerRegistrationDto.getPhoneNo());
        customer.setPasswordHash(passwordEncoder.encode(customerRegistrationDto.getPassword()));
        return customer;
    }

    private CustomerResponse mapToCustomerResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setFullname(customer.getFullName());
        return customerResponse;
    }
}
