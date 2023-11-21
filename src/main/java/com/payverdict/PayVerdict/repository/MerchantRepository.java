package com.payverdict.PayVerdict.repository;

import com.payverdict.PayVerdict.model.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
