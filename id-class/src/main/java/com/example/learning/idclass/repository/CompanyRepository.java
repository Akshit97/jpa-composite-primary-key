package com.example.learning.idclass.repository;

import com.example.learning.idclass.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
