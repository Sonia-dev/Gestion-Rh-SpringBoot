package com.sonia.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Departement  {
	

	

	public Departement() {
		super();
	}

	public Long getId_dep() {
		return id_dep;
	}

	public void setId_dep(Long id_dep) {
		this.id_dep = id_dep;
	}

	public String getNom_dep() {
		return nom_dep;
	}

	public void setNom_dep(String nom_dep) {
		this.nom_dep = nom_dep;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_dep;
	private String nom_dep;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL ,targetEntity = Employee.class,mappedBy = "departements" ,fetch = FetchType.LAZY)
	List<Employee>employees=new ArrayList<Employee>();
	
	
}
