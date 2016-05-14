package com.opinio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opinio.entity.Activities;
import com.opinio.entity.ActivityLog;
import com.opinio.repository.LogRepository;

@Service
public class LogServiceImpl {

	@Autowired
	LogRepository repository;
	
	public void logActitvity(Activities activities){	
		
	if(activities !=null && activities.getActivityLogs()!=null)	
		for(ActivityLog activity : activities.getActivityLogs())
			repository.save(activity);	
	}
	
	public Activities getLogs(){		
		Activities activities = new Activities();		
		List<ActivityLog> activityLogs = (List<ActivityLog>) repository.findAll();
	    activities.setActivityLogs(activityLogs);
		return activities;
	}
}
