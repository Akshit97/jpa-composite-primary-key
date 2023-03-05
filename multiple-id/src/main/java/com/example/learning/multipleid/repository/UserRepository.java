package com.example.learning.multipleid.repository;

import com.example.learning.multipleid.model.Company;
import com.example.learning.multipleid.model.FinancialTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(FinancialTransaction financialTransaction) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(financialTransaction);
        tx.commit();
        session.close();
    }

    public FinancialTransaction get(Long financial_transaction_seq, Company company) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        FinancialTransaction financialTransaction = new FinancialTransaction();
        financialTransaction.setFinancial_transaction_seq(financial_transaction_seq);
        financialTransaction.setCompany(company);
        financialTransaction = session.get(FinancialTransaction.class,financialTransaction);
        tx.commit();
        session.close();
        return financialTransaction;
    }

    public void update(FinancialTransaction financialTransaction) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(financialTransaction);
        tx.commit();
        session.close();
    }

    public void delete(FinancialTransaction financialTransaction) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        financialTransaction = session.get(FinancialTransaction.class,financialTransaction);
        session.delete(financialTransaction);
        tx.commit();
        session.close();
    }

}
