package com.opinio.entity;

import java.util.ArrayList;
import java.util.List;

public class Errors {
    private List<JSError> errors = new ArrayList<>();
	public List<JSError> getErrors() {
		return errors;
	}

	public void setErrors(List<JSError> errors) {
		this.errors = errors;
	}
    
}
