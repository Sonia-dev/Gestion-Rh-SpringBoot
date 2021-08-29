package com.sonia.jpa.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonia.jpa.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	

	List<Employee> findByDepartements(Long departementid);
	


}
