package com.example.learning.idclass.repository;

import com.example.learning.idclass.model.FinancialTransaction;
import com.example.learning.idclass.model.FinancialTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<FinancialTransaction, FinancialTransactionId> {
}
