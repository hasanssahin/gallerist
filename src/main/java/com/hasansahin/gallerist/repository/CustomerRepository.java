package com.hasansahin.gallerist.repository;

import com.hasansahin.gallerist.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
