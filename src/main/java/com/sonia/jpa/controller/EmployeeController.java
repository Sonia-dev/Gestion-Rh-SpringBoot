package com.sonia.jpa.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lowagie.text.DocumentException;
import com.sonia.jpa.entities.Departement;
import com.sonia.jpa.entities.Employee;
import com.sonia.jpa.exportPdf.PdfExporter;
import com.sonia.jpa.repository.ContratRepository;
import com.sonia.jpa.repository.DepartementRepository;
import com.sonia.jpa.repository.EmployeeRepository;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRep;
	
	@Autowired
	private DepartementRepository deprep;
	@Autowired
	private ContratRepository contrep;


	
	

	@PostMapping("/add/{departements}")
	
	@Secured("hasRole('ADMIN')")
	public Employee add(@RequestBody Employee employee,@PathVariable  Long departements) {
		
		
		Departement dep=deprep.findById(departements).get();
		
		employee.setDepartements(dep);
	
		System.out.println(employee.getNom_empl());
		
		return employeeRep.save(employee);
	}
	
	@GetMapping("/employees/{id_empl}")
	public ResponseEntity<Employee>getEmployeeById(@PathVariable Long id_empl){
		
	
		Employee employee = employeeRep.findById(id_empl).get();
	
	
		return ResponseEntity.ok(employee);
				}
	
	
	@GetMapping("/employees")
	public List<Employee> allemployees(){
			
			return employeeRep.findAll();
		}
	
	
	
	
	
	
	
	 @GetMapping("employees/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=employees_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Employee> listempl = employeeRep.findAll();
	         
	        PdfExporter exporter = new PdfExporter(listempl);
	        exporter.export(response);
	         
	    }
	
	
	
	 @DeleteMapping("/{id}")
		public String delete(@PathVariable Long id) {
		 employeeRep.deleteById(id);
		return "Suppression avec succés";
	    }
	
	
	
	
	
	
	@PutMapping("/employees/{id_empl}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable Long id_empl ,@RequestBody Employee detailEmployee)
	{
		Employee employee=employeeRep.findById(id_empl).get();
		
		employee.setNom_empl(detailEmployee.getNom_empl());
		employee.setPrenom_empl(detailEmployee.getPrenom_empl());
		employee.setTelephone(detailEmployee.getTelephone());
		
		Employee updatedEmployee=employeeRep.save(employee);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	
	
	
	
	
}
