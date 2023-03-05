package com.example.learning.embeddedid.repository;

import com.example.learning.embeddedid.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
