package com.example.learning.embeddedid.repository;

import com.example.learning.embeddedid.model.FinancialTransaction;
import com.example.learning.embeddedid.model.FinancialTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<FinancialTransaction, FinancialTransactionId> {
}
