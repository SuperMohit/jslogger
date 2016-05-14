package com.opinio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opinio.entity.Activities;
import com.opinio.service.LogServiceImpl;

@RestController
public class LogController {
	
	@Autowired LogServiceImpl logService;
	
    @RequestMapping("/log")
    public ResponseEntity<?> log(@RequestBody final Activities activities) {
    	   logService.logActitvity(activities);    	
           return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value="/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Activities> getLogs(){   	
    	Activities activities = logService.getLogs();
    	if(activities.getActivityLogs() != null && activities.getActivityLogs().size() > 0)
    		return new ResponseEntity<Activities>(activities,HttpStatus.OK);    	
    	else 
    		return new ResponseEntity<Activities>(HttpStatus.NO_CONTENT);
    		
    }
}
