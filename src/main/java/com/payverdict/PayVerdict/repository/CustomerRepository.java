package com.payverdict.PayVerdict.repository;

import com.payverdict.PayVerdict.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
