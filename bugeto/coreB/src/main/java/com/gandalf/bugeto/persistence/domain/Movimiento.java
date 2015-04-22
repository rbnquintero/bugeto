package com.gandalf.bugeto.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the movimientos database table.
 * 
 */
@Entity
@Table(name="movimientos")
@NamedQuery(name="Movimiento.findAll", query="SELECT m FROM Movimiento m")
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVIMIENTOS_MOVID_GENERATOR", sequenceName="TRANSACTION_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIMIENTOS_MOVID_GENERATOR")
	@Column(name="\"movId\"")
	private Long movId;

	@Column(name="\"movAmmount\"")
	private double movAmmount;

	@Column(name="\"movComments\"")
	private String movComments;

	@Temporal(TemporalType.DATE)
	@Column(name="\"movDate\"")
	private Date movDate;

	//bi-directional one-to-one association to MovCategory
	@ManyToOne
	@JoinColumn(name="\"movCategory\"")
	private MovCategory movCategory;

	//bi-directional one-to-one association to MovType
	@ManyToOne
	@JoinColumn(name="\"movType\"")
	private MovType movType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="\"userId\"")
	private User user;

	//bi-directional one-to-one association to UserBalance
	@OneToOne
	@JoinColumn(name="\"movBalance\"")
	private UserBalance userBalance;
	
	@Column(name="\"cuentaId\"")
	private Long movCuentaId;

	public Movimiento() {
	}

	public Long getMovId() {
		return this.movId;
	}

	public void setMovId(Long movId) {
		this.movId = movId;
	}

	public double getMovAmmount() {
		return this.movAmmount;
	}

	public void setMovAmmount(double movAmmount) {
		this.movAmmount = movAmmount;
	}

	public String getMovComments() {
		return this.movComments;
	}

	public void setMovComments(String movComments) {
		this.movComments = movComments;
	}

	public Date getMovDate() {
		return this.movDate;
	}

	public void setMovDate(Date movDate) {
		this.movDate = movDate;
	}

	public MovCategory getMovCategory() {
		return this.movCategory;
	}

	public void setMovCategory(MovCategory movCategory) {
		this.movCategory = movCategory;
	}

	public MovType getMovType() {
		return this.movType;
	}

	public void setMovType(MovType movType) {
		this.movType = movType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBalance getUserBalance() {
		return this.userBalance;
	}

	public void setUserBalance(UserBalance userBalance) {
		this.userBalance = userBalance;
	}
	
	public Long getMovCuentaId() {
		return movCuentaId;
	}

	public void setMovCuentaId(Long movCuentaId) {
		this.movCuentaId = movCuentaId;
	}

}