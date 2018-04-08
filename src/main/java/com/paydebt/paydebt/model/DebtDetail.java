package com.paydebt.paydebt.model;

import javax.persistence.*;

@Entity
@Table(name = "debt_detail")
public class DebtDetail implements ModelMarker{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;
    private double amount;
    @Column(name = "creditor_ref")
    private String creditorReference;
    @Column(name = "debtor_ref")
    private String debtorReference;
    private int status;

    @Column(name = "create_date")
    private String createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCreditorReference() {
        return creditorReference;
    }

    public void setCreditorReference(String creditorReference) {
        this.creditorReference = creditorReference;
    }

    public String getDebtorReference() {
        return debtorReference;
    }

    public void setDebtorReference(String debtorReference) {
        this.debtorReference = debtorReference;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "DebtDetail{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", creditorReference='" + creditorReference + '\'' +
                ", debtorReference='" + debtorReference + '\'' +
                ", status=" + status +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
