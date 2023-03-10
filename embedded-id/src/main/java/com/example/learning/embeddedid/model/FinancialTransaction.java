package com.example.learning.embeddedid.model;

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
public class FinancialTransaction {

    @EmbeddedId
    private FinancialTransactionId financialTransactionId;

    @ManyToOne
    @JoinColumn(name = "company_fk")
    @MapsId("company_seq")
    private Company company;

    private int money;

    private String nature;

    public FinancialTransaction(FinancialTransactionId financialTransactionId, Integer money, String nature) {
        this.financialTransactionId = financialTransactionId;
        this.money = money;
        this.nature = nature;
    }

    public FinancialTransaction(Integer money, String nature) {
        this.money = money;
        this.nature = nature;
    }

}
