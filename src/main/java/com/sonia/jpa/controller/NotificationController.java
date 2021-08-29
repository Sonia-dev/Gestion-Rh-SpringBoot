package com.sonia.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonia.jpa.entities.Departement;
import com.sonia.jpa.entities.Notification;
import com.sonia.jpa.repository.DepartementRepository;

@RestController
public class NotificationController {

	    @Autowired
	    private SimpMessagingTemplate template;

	    @Autowired
		private DepartementRepository departRep;
	    // Initialize Notifications
	    private Notification notifications = new Notification(0);

	    @GetMapping("/notify")
	    
	    public Iterable<Departement>  getNotification() {

	        // Increment Notification by one
	        notifications.increment();

	        // Push notifications to front-end
	        template.convertAndSend("/topic/notification", notifications);

	    	
			return departRep.findAll();
	    }
	}


