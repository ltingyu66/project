package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = CourseCodeConstrainValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//define default
	public String value() default "LUV";
	
	//error
	public String message() default "must start with LUV";
	
	//default groups
	public Class<?>[] groups() default {};
	
	//default payloads
	public Class<? extends Payload>[] payload() default{};

}
