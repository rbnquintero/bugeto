package com.gandalf.bugeto.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_USERID_GENERATOR", sequenceName="USER_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_USERID_GENERATOR")
	@Column(name="id")
	private Long userId;

	@Column(name="password")
	private String userPassword;

	@Column(name="username")
	private String userUsername;
	
	@Column(name="\"status\"")
	private Long userStatus;
	
	@Column(name="\"fechaCreacion\"")
	private Date userFechaCreacion;
	
	@Column(name="\"token\"")
	private String userToken;

	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="user")
	private List<Movimiento> movimientos;

	//bi-directional many-to-one association to UserBalance
	@OneToMany(mappedBy="user")
	private List<UserBalance> userBalances;

	//bi-directional one-to-one association to UserInfo
	@OneToOne
	@JoinColumn(name="\"userInfo\"")
	private UserInfo userInfo;

	public User() {
	}

    public User(String username, String password) {
        this.userUsername = username;
        this.userPassword = password;
    }

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserUsername() {
		return this.userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	
	public Long getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Long userStatus) {
		this.userStatus = userStatus;
	}
	
	public Date getUserFechaCreacion() {
		return userFechaCreacion;
	}

	public void setUserFechaCreacion(Date userFechaCreacion) {
		this.userFechaCreacion = userFechaCreacion;
	}
	
	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Movimiento addMovimiento(Movimiento movimiento) {
		getMovimientos().add(movimiento);
		movimiento.setUser(this);

		return movimiento;
	}

	public Movimiento removeMovimiento(Movimiento movimiento) {
		getMovimientos().remove(movimiento);
		movimiento.setUser(null);

		return movimiento;
	}

	public List<UserBalance> getUserBalances() {
		return this.userBalances;
	}

	public void setUserBalances(List<UserBalance> userBalances) {
		this.userBalances = userBalances;
	}

	public UserBalance addUserBalance(UserBalance userBalance) {
		getUserBalances().add(userBalance);
		userBalance.setUser(this);

		return userBalance;
	}

	public UserBalance removeUserBalance(UserBalance userBalance) {
		getUserBalances().remove(userBalance);
		userBalance.setUser(null);

		return userBalance;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}