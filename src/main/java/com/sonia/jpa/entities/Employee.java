package com.sonia.jpa.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
public class Employee {
	

	public Long getId_empl() {
		return id_empl;
	}

	public void setId_empl(Long id_empl) {
		this.id_empl = id_empl;
	}

	public String getNom_empl() {
		return nom_empl;
	}

	public void setNom_empl(String nom_empl) {
		this.nom_empl = nom_empl;
	}

	public String getPrenom_empl() {
		return prenom_empl;
	}

	public void setPrenom_empl(String prenom_empl) {
		this.prenom_empl = prenom_empl;
	}

	

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getDate_embauche() {
		return date_embauche;
	}

	public void setDate_embauche(String date_embauche) {
		this.date_embauche = date_embauche;
	}

	public String getLieu_naissance() {
		return lieu_naissance;
	}

	public void setLieu_naissance(String lieu_naissance) {
		this.lieu_naissance = lieu_naissance;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public Long getNbre_enfant() {
		return nbre_enfant;
	}

	

	public void setNbre_enfant(Long nbre_enfant) {
		this.nbre_enfant = nbre_enfant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom_pere() {
		return nom_pere;
	}

	public void setNom_pere(String nom_pere) {
		this.nom_pere = nom_pere;
	}

	public String getNom_mere() {
		return nom_mere;
	}

	public void setNom_mere(String nom_mere) {
		this.nom_mere = nom_mere;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Departement getDepartements() {
		return departements;
	}

	public void setDepartements(Departement departements) {
		this.departements = departements;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id_empl;
	private String nom_empl;
	private String prenom_empl;
	
	private String date_naissance;
	
	private String date_embauche;
	private String lieu_naissance;
	private String situation;
	private String diplome;
	private Long nbre_enfant;
	private String email;
	private String nom_pere;
	private String nom_mere ;
	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	private String telephone;
	
	public Employee() {
		super();
	}
	
	
	
	

	@ManyToOne//(targetEntity = Departement.class)
	//@JoinColumn(name = "departement_id",referencedColumnName = "id_dep")
	//@JsonBackReference
	private Departement departements;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "contrat",referencedColumnName ="id")
	private Contrat contrat;
	
	
}
