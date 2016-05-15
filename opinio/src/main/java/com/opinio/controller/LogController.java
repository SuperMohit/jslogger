package com.opinio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opinio.entity.Activities;
import com.opinio.entity.Errors;
import com.opinio.entity.JSError;
import com.opinio.service.LogServiceImpl;

@RestController
public class LogController {
	
	@Autowired LogServiceImpl logService;
	
    @RequestMapping("/logActivity")
    public ResponseEntity<?> logActivity(@RequestBody final Activities activities) {
    	   logService.logActivity(activities);    	
           return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/logError")
    public ResponseEntity<?> logError(@RequestBody final JSError jsError) {
    	   logService.logError(jsError);   	
           return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value="/fetchActivity", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Activities> getLogs(){   	
    	Activities activities = logService.getLogs();
    	if(activities.getActivityLogs() != null && activities.getActivityLogs().size() > 0)
    		return new ResponseEntity<Activities>(activities,HttpStatus.OK);    	
    	else 
    		return new ResponseEntity<Activities>(HttpStatus.NO_CONTENT);
    		
    }
    
    @RequestMapping(value="/fetchError", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Errors> getErrors(){   	
    	Errors errors = logService.getErrors();
    	if(errors.getErrors() != null && errors.getErrors().size() > 0)
    		return new ResponseEntity<Errors>(errors,HttpStatus.OK);    	
    	else 
    		return new ResponseEntity<Errors>(HttpStatus.NO_CONTENT);
    		
    }
}
