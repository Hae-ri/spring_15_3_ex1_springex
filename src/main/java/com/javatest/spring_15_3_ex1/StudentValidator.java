package com.javatest.spring_15_3_ex1;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student student = (Student) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		
		int studentId = student.getId();
		if (studentId == 0) {
			errors.rejectValue("id", "trouble");
		}
	}

}
