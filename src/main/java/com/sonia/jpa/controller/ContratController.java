package com.sonia.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonia.jpa.entities.Contrat;
import com.sonia.jpa.repository.ContratRepository;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/contrat")
public class ContratController {
	
	@Autowired
	private ContratRepository ContratRep;

	
	
	//add_departement
			@PostMapping("/ADD")
		    public Contrat addDepP(@RequestBody Contrat C) {
				
		        return ContratRep.save(C);
		    }
	
	

	//add_departement
		@PostMapping("/new")
	    public ResponseEntity<Contrat> addDep(@RequestBody Contrat C) {
			
	        return new ResponseEntity<Contrat>(ContratRep.save(C), HttpStatus.OK);
	    }
		//list

		@GetMapping("/all")
		public Iterable<Contrat> allContrats(){
			
			return ContratRep.findAll();
		}
		
		

		@GetMapping("/contrat/{id}")
		public Contrat recherche(@PathVariable Long id) {
			Contrat C = ContratRep.findById(id).get();
			return C;
		}
		
		


}
