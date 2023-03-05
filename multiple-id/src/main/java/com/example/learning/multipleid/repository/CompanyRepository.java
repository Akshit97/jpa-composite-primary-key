package com.example.learning.multipleid.repository;

import com.example.learning.multipleid.model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public CompanyRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Company company) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(company);
        tx.commit();
        session.close();
    }

}
