package com.paydebt.paydebt.form;

public class PaymentForm {
    private String user;
    private int debtReference;
    private String description;
    private double amount;
    private double amountPaid;
    private int transactionRef;
    private int status;
    private String date;
    private String creditorReference;
    private int id;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public int getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(int transactionRef) {
        this.transactionRef = transactionRef;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreditorReference() {
        return creditorReference;
    }

    public void setCreditorReference(String creditorReference) {
        this.creditorReference = creditorReference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PaymentForm{" +
                "user='" + user + '\'' +
                ", debtReference=" + debtReference +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", ampuntPaid=" + amountPaid +
                ", transcationRef=" + transactionRef +
                ", status=" + status +
                ", date='" + date + '\'' +
                ", creditorReference='" + creditorReference + '\'' +
                ", id=" + id +
                '}';
    }
}
