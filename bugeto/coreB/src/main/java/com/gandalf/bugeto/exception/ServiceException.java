package com.gandalf.bugeto.exception;

/**
 * Excepcion a utilizar en los Services
 *
 * @author JWM - Ruben Quintero
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    protected String status;

    private String causer;

    public ServiceException() {
        super();
    }

    public ServiceException(Throwable e) {
        super(e);
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, String status) {
        super(msg);
        this.status = status;
    }

    public ServiceException(String msg, Throwable t) {
        super(msg, t);
    }

    public ServiceException(String msg, String status, Throwable t) {
        super(msg, t);
        this.status = status;
    }

    public ServiceException(String msg, String causer, String status) {
        super(msg);
        this.causer = causer;
        this.status = status;
    }

    public ServiceException(String msg, String causer, String status, Throwable t) {
        super(msg, t);
        this.causer = causer;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCauser() {
        return causer;
    }

    public void setCauser(String causer) {
        this.causer = causer;
    }

}
