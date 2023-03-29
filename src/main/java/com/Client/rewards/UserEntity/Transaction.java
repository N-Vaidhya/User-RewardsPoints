package com.Client.rewards.UserEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @Column(name="USER_ID")
    private Long userId;

    @Column(name = "TRANSACTION_DATE")
    private Timestamp transactionDate;

    @Column(name = "AMOUNT")
    private double transactionAmount;


    public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
