package com.gandalf.bugeto.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the "userInfo" database table.
 */
@Entity
@Table(name = "\"userInfo\"")
@NamedQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "\"userId\"")
    private Long userInfoId;

    @Column(name = "nickname")
    private String userInfoNickname;

    //bi-directional one-to-one association to User
    @OneToOne(mappedBy = "userInfo")
    private User user;

    public UserInfo() {
    }

    public UserInfo(String userInfoNickname) {
        this.userInfoNickname = userInfoNickname;
    }

    public Long getUserInfoId() {
        return this.userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserInfoNickname() {
        return this.userInfoNickname;
    }

    public void setUserInfoNickname(String userInfoNickname) {
        this.userInfoNickname = userInfoNickname;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}