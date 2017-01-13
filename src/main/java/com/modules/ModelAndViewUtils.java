package com.modules;

import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewUtils {

	public static final String ROOT_CONTEXT = "rootContext";

	public static ModelAndView createModelAndView(String viewName) {
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject(ROOT_CONTEXT, Configuration.getRootContext());

		return modelAndView;
	}
}
