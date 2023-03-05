package com.example.learning.multipleid.service;

import com.example.learning.multipleid.model.Company;
import com.example.learning.multipleid.model.FinancialTransaction;
import com.example.learning.multipleid.repository.CompanyRepository;
import com.example.learning.multipleid.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {

    @Autowired
    private SessionFactory sessionFactory;

    private UserRepository userRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
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
        userRepository.save(financialTransaction1);
        log.info("CREATE COMPLETED");

        //READ
        log.info("READ STARTED");
        FinancialTransaction financialTransaction = userRepository.get(1L, company);
        log.info("READ COMPLETED");

        //UPDATE
        log.info("UPDATE STARTED");
        financialTransaction.setMoney(200);
        userRepository.update(financialTransaction);
        log.info("UPDATE COMPLETED");


        //DELETE
        log.info("DELETE STARTED");
        userRepository.delete(financialTransaction1);
        log.info("DELETE COMPLETED");
    }
}
