package com.tasks.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;










import com.google.gson.Gson;
import com.modules.ModelAndViewUtils;
import com.tasks.dao.impl.TaskDAOImpl;
import com.tasks.model.Task;


@Controller
@RequestMapping(value = "VIEW")
public class TaskController {

	@Autowired
	@Qualifier("TaskDAO")
	private TaskDAOImpl  dao;
	
	@RenderMapping
	public ModelAndView index(Model model) {
		ModelAndView modelAndView = ModelAndViewUtils
				.createModelAndView("task");
		List<Task> taskDetailsList = new LinkedList<Task>();
		taskDetailsList = dao.getTaskDetails();
		Gson gson = new Gson();
		modelAndView.addObject("taskDetailsList", taskDetailsList);
		
		String json = gson.toJson(taskDetailsList);
	    modelAndView.addObject("taskJson", json);
	    
		return modelAndView;
	}
	
}
