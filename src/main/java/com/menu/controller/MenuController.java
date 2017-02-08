package com.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

import com.modules.ModelAndViewUtils;

@Controller
@RequestMapping(value = "VIEW")
public class MenuController {

	 @RenderMapping
		public ModelAndView index() {
			ModelAndView modelAndView = ModelAndViewUtils
					.createModelAndView("menu");
			
			return modelAndView;
	 }
}
