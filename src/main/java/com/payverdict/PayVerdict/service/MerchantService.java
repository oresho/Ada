package com.payverdict.PayVerdict.service;

import com.payverdict.PayVerdict.model.request.MerchantRegistrationDto;
import com.payverdict.PayVerdict.model.response.MerchantResponse;

public interface MerchantService {
    MerchantResponse create(MerchantRegistrationDto merchantRegistrationDto);
}
