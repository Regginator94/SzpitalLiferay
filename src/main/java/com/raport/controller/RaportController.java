package com.raport.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

import com.modul_pacjenta.model.DischargedPatient;
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
		List<PatientShortInfo> patientShortInfoList = dao.getPatientShortInfo();
		Map<Integer,String> patientIdList = new LinkedHashMap<Integer,String>();
		for (PatientShortInfo patient : patientShortInfoList) {
			String patientIdAndFullName = "" + patient.getId() + ", " + patient.getName() + " " + 
				patient.getSecondName() + " " + patient.getSurname();
			patientIdList.put(Integer.valueOf(patient.getId()), patientIdAndFullName);
		}
		DischargedPatient dischargedPatientForm = new DischargedPatient();
        modelAndView.addObject("dischargedPatientForm", dischargedPatientForm);
        modelAndView.addObject("patientList", patientIdList);
        modelAndView.addObject("raportList", raportList);
	
		return modelAndView;
	}
    
    @ActionMapping(params = "action=addActivities") 
	public void showDischargedPatientFormSubmitted(ActionRequest request, ActionResponse response, Model model, DischargedPatient dischargedPatientForm, BindingResult result) {
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("yeeeeeeeyys"));
    	//response.addProperty(arg0, arg1);
	}
    
}
