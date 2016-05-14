package com.opinio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opinio.entity.ActivityLog;

@Repository
public interface LogRepository extends CrudRepository<ActivityLog, Integer>{

}
