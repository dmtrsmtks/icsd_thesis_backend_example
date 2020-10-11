package com.icsd.icsd15123.repository;

import com.icsd.icsd15123.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
