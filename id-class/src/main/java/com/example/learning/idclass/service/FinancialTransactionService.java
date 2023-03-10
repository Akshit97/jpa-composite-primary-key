package com.example.learning.idclass.service;

import com.example.learning.idclass.model.Company;
import com.example.learning.idclass.model.FinancialTransaction;
import com.example.learning.idclass.model.FinancialTransactionId;
import com.example.learning.idclass.repository.CompanyRepository;
import com.example.learning.idclass.repository.FinancialTransactionRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class FinancialTransactionService {

    private FinancialTransactionRepository financialTransactionRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public FinancialTransactionService(FinancialTransactionRepository financialTransactionRepository, CompanyRepository companyRepository) {
        this.financialTransactionRepository = financialTransactionRepository;
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    void test() {
        crud();
    }


    public void crud() {
        //Create Company
        Company company = new Company("New Company");
        companyRepository.save(company);

        //CREATE
        log.info("CREATE STARTED");
        FinancialTransaction financialTransaction1 = new FinancialTransaction(company, 100, "Debit");
        financialTransaction1 = financialTransactionRepository.save(financialTransaction1);
        log.info("CREATE COMPLETED");

        //READ
        log.info("READ STARTED");
        FinancialTransactionId financialTransactionId = new FinancialTransactionId(financialTransaction1.getFinancial_transaction_seq(), financialTransaction1.getCompany().getCompany_seq());
        Optional<FinancialTransaction> optionalUser = financialTransactionRepository.findById(financialTransactionId);
        FinancialTransaction financialTransaction = optionalUser.get();
        log.info("READ COMPLETED");

        //Query
        log.info("QUERY STARTED");
        FinancialTransaction financialTransaction2 = financialTransactionRepository.getFinancialTransactionByFinancialTransactionSequence(1L);
        log.info("QUERY COMPLETED");

        //UPDATE
        log.info("UPDATE STARTED");
        financialTransaction.setMoney(200);
        financialTransactionRepository.save(financialTransaction);
        log.info("UPDATE COMPLETED");

        //DELETE
        log.info("DELETE STARTED");
        financialTransactionRepository.delete(financialTransaction);
        log.info("DELETE COMPLETED");
    }
}
