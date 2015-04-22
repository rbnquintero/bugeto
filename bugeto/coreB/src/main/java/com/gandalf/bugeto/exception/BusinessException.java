package com.gandalf.bugeto.exception;

public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    private String status;

    private String causer;

    public BusinessException(Throwable e) {
        super(e);
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, String status) {
        super(msg);
        this.status = status;
    }

    public BusinessException(String msg, Throwable t) {
        super(msg, t);
    }

    public BusinessException(String msg, String status, Throwable t) {
        super(msg, t);
        this.status = status;
    }

    public BusinessException(String msg, String causer, String status) {
        super(msg);
        this.causer = causer;
        this.status = status;
    }

    public BusinessException(String msg, String causer, String status, Throwable t) {
        super(msg, t);
        this.causer = causer;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getCauser() {
        return causer;
    }
}
