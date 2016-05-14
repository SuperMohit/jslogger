package com.opinio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opinio.entity.ActivityLog;
import com.opinio.repository.LogRepository;

@Service
public class LogServiceImpl {

	@Autowired
	LogRepository repository;
	
	public void logActitvity(ActivityLog activity){		
	 repository.save(activity);	
	 System.out.println("repository saved");
	}
	
	
}
