package com.hasansahin.gallerist.repository;

import com.hasansahin.gallerist.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
