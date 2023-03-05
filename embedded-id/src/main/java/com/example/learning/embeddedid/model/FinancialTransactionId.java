package com.example.learning.embeddedid.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class FinancialTransactionId implements Serializable {

    private Long financial_transaction_seq;

    private Long company_seq;
}
