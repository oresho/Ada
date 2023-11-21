package com.payverdict.PayVerdict.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantRegistrationDto {
    private String businessName;
    private String businessAddress;
    private String businessType;
    private String infoEmail;
    private String contactNo;
    private String logoUrl;
}
