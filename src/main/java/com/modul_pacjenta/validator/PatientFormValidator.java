package com.modul_pacjenta.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.modul_pacjenta.model.PatientShortInfo;
import com.modules.ValidationUtils;

@Component("patientFormValidator")
@Scope("singleton")
public class PatientFormValidator implements Validator {


	public boolean supports(Class<?> clazz) {
		return PatientShortInfo.class.equals(clazz);
	}


	public void validate(Object target, Errors errors) {

		PatientShortInfo patient = (PatientShortInfo) target;

		ValidationUtils.rejectIfEmpty(errors, "id", "ID jest wymagany!"); //autoprzyznane w BD?
		ValidationUtils.rejectIfEmpty(errors, "name", "Imie jest wymagane!");
		ValidationUtils.rejectIfEmpty(errors, "surname", "Nazwisko jest wymagane!");
		ValidationUtils.rejectIfEmpty(errors, "bornDate", "Data urodzenia jest wymagana!");
		ValidationUtils.rejectIfEmpty(errors, "sex", "P³eæ jest wymagana!");
		ValidationUtils.rejectIfEmpty(errors, "nationality", "Kraj jest wymagany!");
		ValidationUtils.rejectIfEmpty(errors, "insuranceNumber", "Numer ubezpieczenia jest wymagany!");
		
		if (patient.getBornDate() == null)
			ValidationUtils.reject(errors, "bornDate", "Data urodzenia niepoprawnie wprowadzona!");
		
		ValidationUtils.validateIdNumber(errors, "idNumber", String.valueOf(patient.getIdNumber()), "PESEL niepoprawnie wprowadzony!");
		ValidationUtils.validatePhoneNumber(errors, "phoneNumber", patient.getPhoneNumber(), "Numer telefonu niepoprawnie wprowadzony!");
	}

}
