package com.paydebt.paydebt.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private int id;
    private String description;
    private int status;
    @Column(name = "create_date",columnDefinition = "DATETIME")
    private Date createDate;

    public Transaction() {
    }

    public Transaction(String description, int status, Date createDate) {
        this.description = description;
        this.status = status;
        this.createDate = createDate;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
