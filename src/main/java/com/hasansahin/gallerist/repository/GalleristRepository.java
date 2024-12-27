package com.hasansahin.gallerist.repository;

import com.hasansahin.gallerist.model.Gallerist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleristRepository extends JpaRepository<Gallerist,Long> {
}
