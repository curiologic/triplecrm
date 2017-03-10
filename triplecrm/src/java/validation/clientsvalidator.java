/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import crm.clients;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author xulix
 */
@Component
public class clientsvalidator implements Validator {
    
    private static final Logger logger = Logger.getLogger(clientsvalidator.class.getName());

	@Override
	public boolean supports(Class<?> clazz) {
		return clients.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "client.name.required");
        
        clients client = (clients)target;
		if(client.getName().length() > 120) {
			errors.rejectValue("name","client.name.length");
		}
        
        if (!client.getName().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("name","client.name.pattern");
        }
	}
}
