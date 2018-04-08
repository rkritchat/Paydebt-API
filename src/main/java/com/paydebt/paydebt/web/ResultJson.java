package com.paydebt.paydebt.web;

public class ResultJson {
    private String status;
    private Object result;
    private String erroMessage;

    public ResultJson(){}

    public ResultJson(String status, Object result, String erroMessage) {
        this.status = status;
        this.result = result;
        this.erroMessage = erroMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getErroMessage() {
        return erroMessage;
    }

    public void setErroMessage(String erroMessage) {
        this.erroMessage = erroMessage;
    }
}
