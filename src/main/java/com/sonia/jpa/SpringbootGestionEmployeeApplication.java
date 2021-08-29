package com.sonia.jpa;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sonia.jpa.service.FileStorageService;

@SpringBootApplication
public class SpringbootGestionEmployeeApplication {

	@Resource
	  FileStorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootGestionEmployeeApplication.class, args);
	}
	
	public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }

}
