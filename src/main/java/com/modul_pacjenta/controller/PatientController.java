package com.modul_pacjenta.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	protected void initPatientFormBinder(WebDataBinder binder) {
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
    public String showPatientForm(Model model) {
        PatientShortInfo patientForm = new PatientShortInfo();    
        model.addAttribute("patientForm", patientForm);
        return "newPatient";
    }
	
//	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public String showPatientFormSubmitted(Model model, @ModelAttribute("patientForm") @Validated PatientShortInfo patientForm, BindingResult result) {
		if (result.hasErrors()) {
			return "newPatient";
		}
		dao.insertPatientShortInfo(patientForm);
		dao.insertPatientRegistrationDetails(patientForm);
		return "newPatientAdded";
	}
	
	//@RequestMapping(value = "/dischargePatient", method = RequestMethod.GET)
    public String showDischargedPatientForm(Model model) {
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
	public String showDischargedPatientFormSubmitted(Model model, DischargedPatient dischargedPatientForm, BindingResult result) {
		model.addAttribute("dischargedPatientForm", dischargedPatientForm);
		int dischargedPatientFormId = dischargedPatientForm.getPatientShortInfoId();
		dao.updatePatientIfDischarged(dischargedPatientFormId);
		dao.insertPatientDischargeDetails(dischargedPatientForm);
		return "dischargePatientSubmitted";
	}
	
	@RequestMapping(params = "action =  detailsView")
	public ModelAndView detailsView(RenderRequest request, RenderResponse response, Model model,
			@RequestParam(value = "id") int id) {
		
		System.out.println("czy wjesz³o?");
		ModelAndView modelAndView = ModelAndViewUtils
				.createModelAndView("details");
		PatientShortInfo patientShortInfo = dao.getPatientShortInfo(id);
		modelAndView.addObject("patientShortInfo", patientShortInfo);

		return modelAndView;
	}
	
}
