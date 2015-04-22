package com.gandalf.bugeto.exception;

public class UtilException extends Exception {

    private static final long serialVersionUID = 1L;

    private String status;

    private String causer;

    public UtilException(Throwable e) {
        super(e);
    }

    public UtilException(String msg) {
        super(msg);
    }

    public UtilException(String msg, String status) {
        super(msg);
        this.status = status;
    }

    public UtilException(String msg, Throwable t) {
        super(msg, t);
    }

    public UtilException(String msg, String status, Throwable t) {
        super(msg, t);
        this.status = status;
    }

    public UtilException(String msg, String causer, String status) {
        super(msg);
        this.causer = causer;
        this.status = status;
    }

    public UtilException(String msg, String causer, String status, Throwable t) {
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
