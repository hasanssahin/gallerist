package com.hasansahin.gallerist.repository;

import com.hasansahin.gallerist.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
