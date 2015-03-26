package com.gandalf.bugeto.persistence.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "movTypes" database table.
 * 
 */
@Entity
@Table(name="\"movTypes\"")
@NamedQuery(name="MovType.findAll", query="SELECT m FROM MovType m")
public class MovType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVTYPE_TYPEID_GENERATOR", sequenceName="MOVTYPES_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVTYPE_TYPEID_GENERATOR")
	@Column(name="\"typeId\"")
	private Long typeId;
	
	@Column(name="\"typeName\"")
	private String typeName;

	//bi-directional many-to-one association to MovCategory
	@OneToMany(mappedBy="movType")
	private List<MovCategory> movCategories;

	//bi-directional one-to-one association to Movimiento
	@OneToMany(mappedBy="movType")
	private List<Movimiento> movimiento;

	public MovType() {
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<MovCategory> getMovCategories() {
		return this.movCategories;
	}

	public void setMovCategories(List<MovCategory> movCategories) {
		this.movCategories = movCategories;
	}

	public MovCategory addMovCategory(MovCategory movCategory) {
		getMovCategories().add(movCategory);
		movCategory.setMovType(this);

		return movCategory;
	}

	public MovCategory removeMovCategory(MovCategory movCategory) {
		getMovCategories().remove(movCategory);
		movCategory.setMovType(null);

		return movCategory;
	}

	public List<Movimiento> getMovimiento() {
		return this.movimiento;
	}

	public void setMovimiento(List<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}

}