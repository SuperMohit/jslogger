package com.opinio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.opinio.entity.JSError;

@Repository
public interface ErrorRepository extends CrudRepository<JSError, Integer>{

}
