package com.example.learning.idclass.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FinancialTransactionId implements Serializable {

    private Long financial_transaction_seq;

    private Long company;
}
