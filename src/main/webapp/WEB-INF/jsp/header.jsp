<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="javax.portlet.PortletResponse"%>
<%@ page import="javax.portlet.PortletPreferences"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false" isELIgnored="false"
	contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" media="screen"
	href="webapp/static/css/ui-lightness/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="webapp/static/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="webapp/static/css/ui.jqgrid-bootstrap.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="webapp/static/css/ui.jqgrid-bootstrap-ui.css" />
<link href="webapp/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="webapp/static/css/menu.css"
	rel="stylesheet">
<link
	href="webapp/static/bootstrap/css/bootstrap-datepicker.css"
	media="screen" rel="stylesheet">
<link
	href="webapp/static/css/tablesorter.css"
	media="screen" rel="stylesheet">

<script src="webapp/static/js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
<script src="webapp/static/js/i18n/grid.locale-pl.js"
	type="text/javascript"></script>
<script src="webapp/static/js/jquery.jqGrid.min.js"
	type="text/javascript"></script>
<script src="webapp/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/ecmascript"
	src="webapp/static/bootstrap/js/bootstrap-datepicker.js"></script>
<script type="text/ecmascript"
	src="webapp/static/bootstrap/js/bootstrap3-typeahead.js"></script>
