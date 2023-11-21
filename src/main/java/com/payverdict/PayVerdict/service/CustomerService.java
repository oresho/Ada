package com.payverdict.PayVerdict.service;

import com.payverdict.PayVerdict.model.request.CustomerRegistrationDto;
import com.payverdict.PayVerdict.model.response.CustomerResponse;

public interface CustomerService {
    CustomerResponse create(CustomerRegistrationDto customerRegistrationDto);
}
