package com.opinio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opinio.entity.Activities;
import com.opinio.entity.ActivityLog;
import com.opinio.entity.Errors;
import com.opinio.entity.JSError;
import com.opinio.repository.ErrorRepository;
import com.opinio.repository.LogRepository;

@Service
public class LogServiceImpl {

	@Autowired
	LogRepository logRepository;
	@Autowired
	ErrorRepository errorRepository;
	public void logActivity(Activities activities){	
		
	if(activities !=null && activities.getActivityLogs()!=null)	
		for(ActivityLog activity : activities.getActivityLogs())
			logRepository.save(activity);	
	}
	
	public void logError(JSError jsError){	
		  errorRepository.save(jsError);
		}
	
	public Errors getErrors(){
	      Errors errors = new Errors();
	      List<JSError> jsErrors = (List<JSError>) errorRepository.findAll();
		  errors.setErrors(jsErrors);
		  return errors;
	}
	
	public Activities getLogs(){		
		Activities activities = new Activities();		
		List<ActivityLog> activityLogs = (List<ActivityLog>) logRepository.findAll();
	    activities.setActivityLogs(activityLogs);
		return activities;
	}
}
