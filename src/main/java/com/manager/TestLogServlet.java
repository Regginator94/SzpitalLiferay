package com.manager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.modules.Configuration;

public class TestLogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestLogServlet.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.info("Manager log test INFO");
		LOGGER.warn("Manager log test WARNING");
		LOGGER.debug("Manager log test DEBUG");
		LOGGER.error("Manager log test ERROR");
		System.out.println("Manager system out test - "
				+ Configuration.getRootPath());
		System.err.println("Manager system err test - "
				+ Configuration.getRootContext());

	}

}
