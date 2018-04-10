package com.paydebt.paydebt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    private int id;
    @Column(name = "debt_ref")
    private int debtReference;
    @Column(name = "debtor_ref")
    private String debtorReference;
    @Column(name = "creditor_ref")
    private String creditorReference;
    private double amount;
    @Column(name = "create_date")
    private Date createDate;

    public Receipt() {
    }

    public Receipt(int debtReference, String debtorReference, String creditorReference, double amount, Date createDate) {
        this.debtReference = debtReference;
        this.debtorReference = debtorReference;
        this.creditorReference = creditorReference;
        this.amount = amount;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDebtReference() {
        return debtReference;
    }

    public void setDebtReference(int debtReference) {
        this.debtReference = debtReference;
    }

    public String getDebtorReference() {
        return debtorReference;
    }

    public void setDebtorReference(String debtorReference) {
        this.debtorReference = debtorReference;
    }

    public String getCreditorReference() {
        return creditorReference;
    }

    public void setCreditorReference(String creditorReference) {
        this.creditorReference = creditorReference;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
