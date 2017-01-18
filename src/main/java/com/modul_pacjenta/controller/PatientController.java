package com.modul_pacjenta.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

import com.modul_pacjenta.dao.impl.PatientDAOImpl;
import com.modul_pacjenta.model.DischargedPatient;
import com.modul_pacjenta.model.PatientShortInfo;
import com.modul_pacjenta.validator.PatientFormValidator;
import com.modules.ModelAndViewUtils;

@Controller
@RequestMapping(value = "VIEW")
public class PatientController {
	
	@Autowired
	@Qualifier("PatientDAO")
	private PatientDAOImpl  dao;
	
	@Autowired
	private PatientFormValidator patientFormValidator;

	@InitBinder("patientForm")
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);

	    // true passed to CustomDateEditor constructor means convert empty String to null
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    binder.setValidator(patientFormValidator);
	}
	
    @RenderMapping
	public ModelAndView index(Integer messageCodeOrNull) {
		ModelAndView modelAndView = ModelAndViewUtils
				.createModelAndView("patient");
		if (messageCodeOrNull != null) {
			List<String> messages = new ArrayList<String>(1);
			List<String> errors = new ArrayList<String>(1);
			switch (messageCodeOrNull) {
			case 1:
				messages.add("submitSampleForm Success.");
				break;
			case 2:
				errors.add("submitSampleForm Failed.");
				break;
			default:
				break;

			}

			if (messages.size() > 0)
				modelAndView.addObject("messages", messages);
			if (errors.size() > 0)
				modelAndView.addObject("errors", errors);
		}
		List<PatientShortInfo> patientShortInfoList = new LinkedList<PatientShortInfo>();
		patientShortInfoList = dao.getPatientShortInfo();
		modelAndView.addObject("patientShortInfoList", patientShortInfoList);
		return modelAndView;
	}
	
//	@RequestMapping(value = "/addPatient", method = RequestMethod.GET)
    @RenderMapping(params = "action=showPatientForm")
    public String showPatientForm(RenderRequest request, RenderResponse response, Model model) {
        PatientShortInfo patientForm = new PatientShortInfo();    
        model.addAttribute("patientForm", patientForm);
        return "newPatient";
    }
	
//	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
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
	
	//@RequestMapping(value = "/dischargePatient", method = RequestMethod.GET)
    @RenderMapping(params = "action=showDischargedPatientForm")
    public String showDischargedPatientForm(RenderRequest request, RenderResponse response, Model model) {
		List<PatientShortInfo> patientShortInfoList = new LinkedList<PatientShortInfo>();
		patientShortInfoList = dao.getPatientShortInfo();
		Map<Integer,String> patientIdList = new LinkedHashMap<Integer,String>();
		for (PatientShortInfo patient : patientShortInfoList) {
			String patientIdAndFullName = "" + patient.getId() + ", " + patient.getName() + " " + 
				patient.getSecondName() + " " + patient.getSurname();
			patientIdList.put(Integer.valueOf(patient.getId()), patientIdAndFullName);
		}
		Map<String,String> reasonList = new LinkedHashMap<String,String>();
		reasonList.put("Wypis pacjenta do domu", "Wypis pacjenta do domu");
		reasonList.put("Zgon pacjenta", "Zgon pacjenta");
		DischargedPatient dischargedPatientForm = new DischargedPatient();
        model.addAttribute("dischargedPatientForm", dischargedPatientForm);
        model.addAttribute("patientIdList", patientIdList);
        model.addAttribute("reasonList", reasonList);
        return "dischargePatient";
    }
	
	//@RequestMapping(value = "/dischargePatientSubmitted", method = RequestMethod.POST)
    @ActionMapping(params = "action=showDischargedPatientFormSubmitted") 
	public void showDischargedPatientFormSubmitted(ActionRequest request, ActionResponse response, Model model, DischargedPatient dischargedPatientForm, BindingResult result) {
		model.addAttribute("dischargedPatientForm", dischargedPatientForm);
		int dischargedPatientFormId = dischargedPatientForm.getPatientShortInfoId();
		dao.updatePatientIfDischarged(dischargedPatientFormId);
		dao.insertPatientDischargeDetails(dischargedPatientForm);
		response.setRenderParameter("","");
	}
	
	@ActionMapping(params = "action =  detailsView")
	public ModelAndView detailsView(ActionRequest request, ActionResponse response, Model model,
			@RequestParam(value = "id") int id) {
		
		System.out.println("czy wjesz³o?");
		ModelAndView modelAndView = ModelAndViewUtils
				.createModelAndView("details");
		PatientShortInfo patientShortInfo = dao.getPatientShortInfo(id);
		modelAndView.addObject("patientShortInfo", patientShortInfo);

		return modelAndView;
	}
	
}
