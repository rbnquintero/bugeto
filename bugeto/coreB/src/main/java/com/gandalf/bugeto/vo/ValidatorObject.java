package com.gandalf.bugeto.vo;

import java.io.Serializable;

/**
 * Created by rbnquintero on 3/26/15.
 */
public class ValidatorObject implements Serializable{
    private static final long serialVersionUID = 1L;

    private String campo;
    private String mensajeError;

    public ValidatorObject(String campo, String mensajeError){
        this.campo = campo;
        this.mensajeError = mensajeError;
    }

    public String getCampo() {
        return campo;
    }
    public void setCampo(String campo) {
        this.campo = campo;
    }
    public String getMensajeError() {
        return mensajeError;
    }
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
