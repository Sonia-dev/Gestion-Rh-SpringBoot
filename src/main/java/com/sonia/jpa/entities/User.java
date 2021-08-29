package com.sonia.jpa.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity

public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String username;
 private String email;
 
 
@JsonProperty(access = Access.WRITE_ONLY)
@OneToMany(cascade = CascadeType.ALL ,targetEntity = Conge.class,mappedBy = "user" ,fetch = FetchType.LAZY)
List<Conge>conges=new ArrayList<Conge>();



@JsonProperty(access = Access.WRITE_ONLY)
@OneToMany(cascade = CascadeType.ALL ,targetEntity = Autorisation.class,mappedBy = "user_aut" ,fetch = FetchType.LAZY)
List<Autorisation>aut=new ArrayList<Autorisation>();

 public String getUsername() {
	return username;
}



public Long getId() {
	return id;
}



public Set<Role> getRoles() {
	return roles;
}



public void setRoles(Set<Role> roles) {
	this.roles = roles;
}



public void setId(Long id) {
	this.id = id;
}







public User() {
	super();
}



public User(String username, String email, String password) {
	super();
	this.username = username;
	this.email = email;
	this.password = password;
}



public void setUsername(String username) {
	this.username = username;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



private String password;

 
 
 @ManyToMany
 private Set<Role> roles = new HashSet<>();

}
