package com.wypis_pacjenta.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.modul_pacjenta.model.DischargedPatient;
import com.modul_pacjenta.model.PatientShortInfo;
import com.wypis_pacjenta.dao.impl.WypisDAOImpl;


@Controller
@RequestMapping(value = "VIEW")
public class WypisPacjentaController {
	
	@Autowired
	@Qualifier("WypisDAO")
	private WypisDAOImpl  dao;
	
	 @RenderMapping
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
		
	    @ActionMapping(params = "action=showDischargedPatientFormSubmitted") 
		public void showDischargedPatientFormSubmitted(ActionRequest request, ActionResponse response, Model model, DischargedPatient dischargedPatientForm, BindingResult result) {
			model.addAttribute("dischargedPatientForm", dischargedPatientForm);
			int dischargedPatientFormId = dischargedPatientForm.getPatientShortInfoId();
			dao.updatePatientIfDischarged(dischargedPatientFormId);
			dao.insertPatientDischargeDetails(dischargedPatientForm);
			response.setRenderParameter("","");
		}
	    
	    @RenderMapping(params = "action=showUpdatedPatientForm")
	    public String showUpdatedPatientForm(RenderRequest request, RenderResponse response, Model model,
				@RequestParam(value = "id") int id) {
	    	
	    	PatientShortInfo currentPatientShortInfo = dao.getPatientShortInfo(id);
	    	model.addAttribute("currentPatientShortInfo", currentPatientShortInfo);
	    	PatientShortInfo patientForm = new PatientShortInfo();    
	        model.addAttribute("patientForm", patientForm);
	        
	        return "updatePatient";
	    }
		
	    @ActionMapping(params = "action=showUpdatedPatientFormSubmitted") 
		public void showUpdatedPatientFormSubmitted(ActionRequest request, ActionResponse response, @ModelAttribute("patientForm") @Validated PatientShortInfo patientForm, BindingResult result, Model model) {
	    	model.addAttribute("patientForm", patientForm);
			int updatedPatientFormId = patientForm.getId();
			dao.updatePatientIfModified(patientForm, updatedPatientFormId);
			response.setRenderParameter("","");
		}
}