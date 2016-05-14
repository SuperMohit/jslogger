package com.opinio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opinio.entity.ActivityLog;
import com.opinio.service.LogServiceImpl;

@RestController
public class LogController {
	
	@Autowired LogServiceImpl logService;
	
    @RequestMapping("/log")
    public ResponseEntity<?> greeting(ActivityLog activity) {
    	   System.out.println("Got logged activity");
           logService.logActitvity(activity);
           return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
