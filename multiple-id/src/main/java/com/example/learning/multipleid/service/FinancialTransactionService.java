package com.example.learning.multipleid.service;

import com.example.learning.multipleid.model.Company;
import com.example.learning.multipleid.model.FinancialTransaction;
import com.example.learning.multipleid.repository.CompanyRepository;
import com.example.learning.multipleid.repository.FinancialTransactionRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FinancialTransactionService {

    @Autowired
    private SessionFactory sessionFactory;

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
        FinancialTransaction financialTransaction1 = new FinancialTransaction(100, "Debit");
        financialTransaction1.setCompany(company);
        financialTransactionRepository.save(financialTransaction1);
        log.info("CREATE COMPLETED");

        //READ
        log.info("READ STARTED");
        FinancialTransaction financialTransaction = financialTransactionRepository.get(1L, company);
        log.info("READ COMPLETED");

        //UPDATE
        log.info("UPDATE STARTED");
        financialTransaction.setMoney(200);
        financialTransactionRepository.update(financialTransaction);
        log.info("UPDATE COMPLETED");


        //DELETE
        log.info("DELETE STARTED");
        financialTransactionRepository.delete(financialTransaction1);
        log.info("DELETE COMPLETED");
    }
}
