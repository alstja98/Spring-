package com.mvc.file.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//유효성 검사
@Service
public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UploadFile file=(UploadFile)target;
		
		if(file.getFile() == null ) {
			errors.rejectValue("file", "errorCode", "Please select a file");
		}
	}

	
}
