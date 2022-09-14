package com.justony.countriesservice.repo;

import com.justony.countriesservice.dto.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Country, String> {
}
