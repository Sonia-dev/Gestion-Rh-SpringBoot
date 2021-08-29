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

import com.sonia.jpa.entities.Departement;
import com.sonia.jpa.entities.Employee;
import com.sonia.jpa.repository.DepartementRepository;
 import com.sonia.jpa.repository.DepartementRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/dep/")
public class DepartementController {
	
	@Autowired
	private DepartementRepository departRep;

	//add_departement
		@PostMapping("/new")
	    public ResponseEntity<Departement> addDep(@RequestBody Departement dep) {
			
			
	        return new ResponseEntity<Departement>(departRep.save(dep), HttpStatus.OK);
	    }
		//list

		@GetMapping("/departments")
		public Iterable<Departement> alldepartments(){
			
			return departRep.findAll();
		}
		
		

		@GetMapping("/department/{id}")
		public Departement recherche(@PathVariable Long id) {
			Departement e = departRep.findById(id).get();
			for(Employee employe : e.getEmployees()) {
				employe.setDepartements(null);
			}
			return e;
		}
		
		
		
		
		
}
