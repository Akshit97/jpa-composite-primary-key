package com.example.learning.idclass.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "FINANCIAL_TRANSACTION")
@Getter
@Setter
@NoArgsConstructor
@ToString
@IdClass(FinancialTransactionId.class)
public class FinancialTransaction {

    @Id
    @GeneratedValue
    private Long financial_transaction_seq;

    @Id
    @ManyToOne
    @JoinColumn(name = "company_fk")
    @MapsId("company_seq")
    private Company company;

    private int money;

    private String nature;

    public FinancialTransaction(Company company, Integer money, String nature) {
        this.company = company;
        this.money = money;
        this.nature = nature;
    }

}
