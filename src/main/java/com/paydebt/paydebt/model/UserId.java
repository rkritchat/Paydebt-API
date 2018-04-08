package com.paydebt.paydebt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user_id")
public class UserId implements ModelMarker {
    @Id
    @NotEmpty
    private String id;
    @NotEmpty
    private String pwd;
    public UserId(){}

    public UserId(@NotEmpty String id, @NotEmpty String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
