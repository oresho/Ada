package com.payverdict.PayVerdict.service.impl;

import com.payverdict.PayVerdict.model.request.MerchantRegistrationDto;
import com.payverdict.PayVerdict.model.response.MerchantResponse;
import com.payverdict.PayVerdict.repository.MerchantRepository;
import com.payverdict.PayVerdict.service.MerchantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;
    @Override
    public MerchantResponse create(MerchantRegistrationDto merchantRegistrationDto) {
        return null;
    }
}
