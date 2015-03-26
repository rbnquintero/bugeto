package com.gandalf.bugeto.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the "userBalance" database table.
 * 
 */
@Entity
@Table(name="\"userBalance\"")
@NamedQuery(name="UserBalance.findAll", query="SELECT u FROM UserBalance u")
public class UserBalance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERBALANCE_BALID_GENERATOR", sequenceName="USERBALANCE_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERBALANCE_BALID_GENERATOR")
	@Column(name="\"balId\"")
	private Long balId;

	@Column(name="\"balAmount\"")
	private Double balAmount;

	//bi-directional one-to-one association to Movimiento
	@OneToOne(mappedBy="userBalance")
	private Movimiento movimiento;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="\"balUser\"")
	private User user;

	public UserBalance() {
	}
	
	public UserBalance(Double balAmount, User user) {
		this.balAmount = balAmount;
		this.user = user;
	}
	
	public Long getBalId() {
		return this.balId;
	}

	public void setBalId(Long balId) {
		this.balId = balId;
	}

	public Double getBalAmount() {
		return this.balAmount;
	}

	public void setBalAmount(Double balAmount) {
		this.balAmount = balAmount;
	}

	public Movimiento getMovimiento() {
		return this.movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}