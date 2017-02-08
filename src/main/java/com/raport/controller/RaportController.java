package com.raport.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
		return modelAndView;
	}
}
