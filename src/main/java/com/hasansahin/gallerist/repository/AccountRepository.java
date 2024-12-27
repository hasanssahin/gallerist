package com.hasansahin.gallerist.repository;

import com.hasansahin.gallerist.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
