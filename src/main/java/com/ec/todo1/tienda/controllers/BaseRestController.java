package com.ec.todo1.tienda.controllers;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ec.todo1.tienda.dto.response.ErrorResponse;

/**
 * The REST API for processing the incoming requests the Usuario. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/usuario")
public class BaseRestController {
	final static Logger logger = LoggerFactory.getLogger(BaseRestController.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorResponse return404(NoSuchElementException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ErrorResponse return409(DataIntegrityViolationException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
	}

}
