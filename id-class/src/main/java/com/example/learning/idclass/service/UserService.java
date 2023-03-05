package com.example.learning.idclass.service;

import com.example.learning.idclass.model.Company;
import com.example.learning.idclass.model.FinancialTransaction;
import com.example.learning.idclass.model.FinancialTransactionId;
import com.example.learning.idclass.repository.CompanyRepository;
import com.example.learning.idclass.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

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
        FinancialTransaction financialTransaction1 = new FinancialTransaction(company, 100, "Debit");
        financialTransaction1 = userRepository.save(financialTransaction1);
        log.info("CREATE COMPLETED");

        //READ
        log.info("READ STARTED");
        FinancialTransactionId financialTransactionId = new FinancialTransactionId(financialTransaction1.getFinancial_transaction_seq(), financialTransaction1.getCompany().getCompany_seq());
        Optional<FinancialTransaction> optionalUser = userRepository.findById(financialTransactionId);
        FinancialTransaction financialTransaction = optionalUser.get();
        log.info("READ COMPLETED");

        //UPDATE
        log.info("UPDATE STARTED");
        financialTransaction.setMoney(200);
        userRepository.save(financialTransaction);
        log.info("UPDATE COMPLETED");

        //DELETE
        log.info("DELETE STARTED");
        userRepository.delete(financialTransaction);
        log.info("DELETE COMPLETED");
    }
}
