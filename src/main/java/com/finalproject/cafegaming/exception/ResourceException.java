package com.finalproject.cafegaming.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author AuPhan
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceException extends RuntimeException{

}
