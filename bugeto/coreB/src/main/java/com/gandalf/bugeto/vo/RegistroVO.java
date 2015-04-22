package com.gandalf.bugeto.vo;

import java.io.Serializable;

/**
 * Created by rbnquintero on 3/26/15.
 */
public class RegistroVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String passwordConfirma;
    private String nickname;
    private Double initialAmount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Double initialAmount) {
        this.initialAmount = initialAmount;
    }

    public String getPasswordConfirma() {
        return passwordConfirma;
    }

    public void setPasswordConfirma(String passwordConfirma) {
        this.passwordConfirma = passwordConfirma;
    }
}
