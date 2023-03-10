package com.example.learning.idclass.repository;

import com.example.learning.idclass.model.FinancialTransaction;
import com.example.learning.idclass.model.FinancialTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, FinancialTransactionId> {

    @Query("SELECT ft FROM FINANCIAL_TRANSACTION ft where ft.financial_transaction_seq=:financial_transaction_seq")
    FinancialTransaction getFinancialTransactionByFinancialTransactionSequence(Long financial_transaction_seq);
}
