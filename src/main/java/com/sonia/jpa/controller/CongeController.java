package com.sonia.jpa.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonia.jpa.entities.Conge;
import com.sonia.jpa.entities.Employee;


import com.sonia.jpa.entities.User;
import com.sonia.jpa.repository.CongeRepository;
import com.sonia.jpa.repository.EmployeeRepository;
import com.sonia.jpa.repository.UserRepository;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/conge/v1/")
public class CongeController {

	@Autowired
	private EmployeeRepository employeeRep;
	@Autowired
	private UserRepository userep;
	
	@Autowired
	private CongeRepository congrep;

	

	@PostMapping("/add/{user}")
	
	public Conge add(@RequestBody Conge conge,@PathVariable  Long user) {
		
		
		User empl=userep.findById(user).get();
		
		conge.setUser(empl);
		conge.setEtat("en attente");
		
		return congrep.save(conge);
	}
	
	
	
	

	
	@GetMapping("/Conges/{id_conge}")
	public ResponseEntity<Conge>getCongeById(@PathVariable Long id_conge){
		
	
		Conge conge = congrep.findById(id_conge).get();
	
	
		return ResponseEntity.ok(conge);
				}
	
	
	
	@GetMapping("/conges")
	public List<Conge> allconges(){
			
			return congrep.findAll();
		}
	
	@PutMapping("/congess/{id}")
	public ResponseEntity<Conge>updateEtudiant(@PathVariable Long id ,@RequestBody Conge detailEtudiant)
	{
		Conge cong =congrep.findById(id).get();
		
		cong.setEtat(detailEtudiant.getEtat());
		
		
		
		
		Conge updatedEtudiant=congrep.save(cong);
		return ResponseEntity.ok(updatedEtudiant);
		
	}
	
	
	
	
	
	
}









	