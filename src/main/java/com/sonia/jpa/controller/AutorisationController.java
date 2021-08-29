package com.sonia.jpa.controller;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonia.jpa.domain.Response;
import com.sonia.jpa.entities.Autorisation;
import com.sonia.jpa.entities.Conge;
import com.sonia.jpa.entities.User;
import com.sonia.jpa.repository.AutorisationRepository;
import com.sonia.jpa.repository.CongeRepository;
import com.sonia.jpa.repository.EmployeeRepository;
import com.sonia.jpa.repository.UserRepository;
import com.sonia.jpa.service.FileStorageService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/aut/v1/")
public class AutorisationController {


	
	@Autowired
	private UserRepository userep;
	
	@Autowired
	private AutorisationRepository autrep;

	@PostMapping("/add/{user}")
	
	public Autorisation add(@RequestBody Autorisation  aut,@PathVariable  Long user) {
		
		
		User empl=userep.findById(user).get();
		
		aut.setUser_aut(empl);
		aut.setEtat("en attente");
		
		return autrep.save(aut);
	}
	
	
	
	
	
	

	
	@GetMapping("/aut/{id_aut}")
	public ResponseEntity<Autorisation>getCongeById(@PathVariable Long id_aut){
		
	
		Autorisation aut = autrep.findById(id_aut).get();
	
	
		return ResponseEntity.ok(aut);
				}
	
	
	
	@GetMapping("/auts")
	public List<Autorisation> allauts(){
			
			return autrep.findAll();
		}
	
	@PutMapping("/auts/{id}")
	public ResponseEntity<Autorisation>updateEtudiant(@PathVariable Long id ,@RequestBody Conge detailEtudiant)
	{
		Autorisation aut =autrep.findById(id).get();
		
		aut.setEtat(detailEtudiant.getEtat());
		
		
		
		
		Autorisation updatedEtudiant=autrep.save(aut);
		return ResponseEntity.ok(updatedEtudiant);
		
	}
	
	
	
	
	
	
}









	
