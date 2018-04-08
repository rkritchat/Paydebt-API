package com.paydebt.paydebt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String createDate;

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
