package com.example.learning.multipleid.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity(name = "FINANCIAL_TRANSACTION")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class FinancialTransaction {

    @Id
    @GeneratedValue
    private long financial_transaction_seq;

    //Even if we remove referencedColumnName it will refer to the primary key of the table i.e company_seq by default.
    //But if we want we can have a foreign key on any other column like name also. Then a unique constraint on name will also be created.
    @Id
    @ManyToOne()
    @JoinColumn(name = "company_fk", referencedColumnName = "company_seq")
    private Company company;

    private int money;

    private String nature;

    public FinancialTransaction(Integer money, String nature) {
        this.money = money;
        this.nature = nature;
    }

}
