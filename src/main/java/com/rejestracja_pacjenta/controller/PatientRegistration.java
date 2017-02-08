package com.rejestracja_pacjenta.controller;

import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.modul_pacjenta.model.PatientShortInfo;
import com.rejestracja_pacjenta.dao.impl.RegistrationDAOImpl;

@Controller
@RequestMapping(value = "VIEW")
public class PatientRegistration {
	
	@Autowired
	@Qualifier("RegistrationDAO")
	private RegistrationDAOImpl  dao;


	@InitBinder("patientForm")
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);

	    // true passed to CustomDateEditor constructor means convert empty String to null
	}
	
    @RenderMapping
    public String showPatientForm(RenderRequest request, RenderResponse response, Model model) {
        PatientShortInfo patientForm = new PatientShortInfo();    
        model.addAttribute("patientForm", patientForm);
        return "newPatient";
    }
    
    @ActionMapping(params = "action=showPatientFormSubmitted") 
	public void showPatientFormSubmitted(ActionRequest request, ActionResponse response, @ModelAttribute("patientForm") @Validated PatientShortInfo patientForm, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		response.setRenderParameter("action","showPatientForm");
    		return;
		}
		dao.insertPatientShortInfo(patientForm);
		dao.insertPatientRegistrationDetails(patientForm);
		response.setRenderParameter("","");
	}

}
