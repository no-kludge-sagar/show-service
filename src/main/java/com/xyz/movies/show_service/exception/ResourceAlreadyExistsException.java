package com.xyz.movies.show_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceAlreadyExistsException extends RuntimeException {

	public ResourceAlreadyExistsException(String resourceName) {
		super(String.format("%s already exists with the given input(s). Cannot create a duplicate %s.", resourceName, resourceName));
	}
	
}
