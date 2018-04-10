package com.paydebt.paydebt.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="payment")
public class Payment {
    @Id
    @Column(name = "transaction_ref")
    private int transactionReference;
    private String userId;

    @Column(name = "debt_ref")
    private int debtReference;
    private String description;
    private double amount;

    @Column(name="amount_paid")
    private double amountPaid;

    @Column(name = "status")
    private int status;
    @Column(name = "payment_date",columnDefinition = "DATETIME")
    private Date paymentDate;

    public Payment() {
    }

    public Payment(String userId, int debtReference, String description, double amount, double amountPaid, int transactionReference, int status, Date paymentDate) {
        this.userId = userId;
        this.debtReference = debtReference;
        this.description = description;
        this.amount = amount;
        this.amountPaid = amountPaid;
        this.transactionReference = transactionReference;
        this.status = status;
        this.paymentDate = paymentDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDebtReference() {
        return debtReference;
    }

    public void setDebtReference(int debtReference) {
        this.debtReference = debtReference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(int transactionReference) {
        this.transactionReference = transactionReference;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
