package com.payverdict.PayVerdict.repository;

import com.payverdict.PayVerdict.model.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
