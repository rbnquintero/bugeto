package com.gandalf.bugeto.persistence.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "movCategories" database table.
 * 
 */
@Entity
@Table(name="\"movCategories\"")
@NamedQuery(name="MovCategory.findAll", query="SELECT m FROM MovCategory m")
public class MovCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVCATEGORY_CATID_GENERATOR", sequenceName="MOVCATEGORIES_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVCATEGORY_CATID_GENERATOR")
	@Column(name="\"catId\"")
	private Long catId;

	@Column(name="\"catName\"")
	private String catName;

	//bi-directional many-to-one association to MovType
	@ManyToOne
	@JoinColumn(name="\"movType\"")
	private MovType movType;

	//bi-directional one-to-one association to Movimiento
	@OneToMany(mappedBy="movCategory")
	private List<Movimiento> movimiento;

	public MovCategory() {
	}

	public Long getCatId() {
		return this.catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public MovType getMovType() {
		return this.movType;
	}

	public void setMovType(MovType movType) {
		this.movType = movType;
	}

	public List<Movimiento> getMovimiento() {
		return this.movimiento;
	}

	public void setMovimiento(List<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}

}