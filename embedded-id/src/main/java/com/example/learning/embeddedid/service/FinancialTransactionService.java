package com.example.learning.embeddedid.service;

import com.example.learning.embeddedid.model.Company;
import com.example.learning.embeddedid.model.FinancialTransaction;
import com.example.learning.embeddedid.model.FinancialTransactionId;
import com.example.learning.embeddedid.repository.CompanyRepository;
import com.example.learning.embeddedid.repository.FinancialTransactionRepository;
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
        FinancialTransactionId financialTransactionId = new FinancialTransactionId(1L, null);


        //CREATE
        log.info("CREATE STARTED");
        FinancialTransaction financialTransaction1 = new FinancialTransaction(financialTransactionId, 100, "Debit");
        financialTransaction1.setCompany(company);
        financialTransactionRepository.save(financialTransaction1);
        log.info("CREATE COMPLETED");

        //READ
        log.info("READ STARTED");
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
