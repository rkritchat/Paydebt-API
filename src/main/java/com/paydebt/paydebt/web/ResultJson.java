package com.paydebt.paydebt.web;


public class ResultJson {
    private String status;
    private Object result;
    private String errorMessage;

    public ResultJson(){}

    public ResultJson(String status, String errorMessage, Object result) {
        this.status = status;
        this.result = result;
        this.errorMessage = errorMessage;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
