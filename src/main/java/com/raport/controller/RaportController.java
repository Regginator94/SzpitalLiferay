package com.raport.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

import com.modul_pacjenta.model.Activity;
import com.modul_pacjenta.model.PatientSend;
import com.modul_pacjenta.model.PatientShort;
import com.modul_pacjenta.model.PatientShortInfo;
import com.modules.ModelAndViewUtils;
import com.raport.dao.impl.RaportDAOImpl;


@Controller
@RequestMapping(value = "VIEW")
public class RaportController {
	
	@Autowired
	@Qualifier("RaportDAO")
	private RaportDAOImpl  dao;


	@InitBinder("raportForm")
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);

	    // true passed to CustomDateEditor constructor means convert empty String to null
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
    @RenderMapping
	public ModelAndView index(Integer messageCodeOrNull) {
		ModelAndView modelAndView = ModelAndViewUtils
				.createModelAndView("raport");
		Map<String,String> raportList = new LinkedHashMap<String,String>();
		raportList.put("Poranny", "Poranny");
		raportList.put("Dzienny", "Dzienny");
		raportList.put("Nocny", "Nocny");
		PatientSend patientSend = new PatientSend();
		List<PatientShortInfo> patientShortInfoList = dao.getPatientShortInfo();
		LinkedList<PatientShort> patientIdList = new LinkedList<PatientShort>();
		for (PatientShortInfo patient : patientShortInfoList) {
			String patientIdAndFullName = "" + patient.getId() + ", " + patient.getName() + " " + 
				patient.getSecondName() + " " + patient.getSurname();
			PatientShort patient1 =  new PatientShort(Integer.valueOf(patient.getId()), patientIdAndFullName);
			patientIdList.add(patient1);
		}
        modelAndView.addObject("patientSend", patientSend);
        modelAndView.addObject("patientList", patientIdList);
        modelAndView.addObject("raportList", raportList);
	
		return modelAndView;
	}
    
    @ActionMapping(params = "action=addActivities") 
	public void showDischargedPatientFormSubmitted(ActionRequest request, ActionResponse response, Model model, PatientSend patientSend, BindingResult result) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();

    	try{
    		Activity activity = dao.patientActivity(3);
    		model.addAttribute("activities", activity);
    		
    	} catch( EmptyResultDataAccessException e) {
    		Activity activit = new Activity("", "Brak aktywności", "", date);
    		model.addAttribute("activities", activit);
    	}
	}
    
}
