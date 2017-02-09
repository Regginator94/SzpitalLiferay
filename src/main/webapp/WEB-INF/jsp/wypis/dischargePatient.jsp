<%@include file="/WEB-INF/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=request.getContextPath()%>/static/css/patient.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tabela pacjentow</title>
<%@include file="/WEB-INF/jsp/header2.jsp"%>
<portlet:actionURL var="showDischargedPatientFormSubmittedURL">
    <portlet:param name="action" value="showDischargedPatientFormSubmitted"/>
</portlet:actionURL>
<portlet:renderURL var="showPatientListURL">
    <portlet:param name="action" value="index"/>
</portlet:renderURL>
	<div></div> <!--class="container" align="center">-->
		<h2>Wypis pacjenta</h2>
		<form:form method="post" commandName="dischargedPatientForm" action="${showDischargedPatientFormSubmittedURL}">
		<table class="table table-condensed">
		    <tr>
		        <td><form:label path="patientShortInfoId">Wybierz pacjenta</form:label></td>
		        <td><form:select path="patientShortInfoId" items="${patientIdList}" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="reason">Powod wypisania pacjenta</form:label></td>
		        <td><form:select path="reason" items="${reasonList}" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="comment">Komentarz</form:label></td>
		        <td><form:textarea path="comment" rows="3" cols="30"/></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <form:input class="submit" path="" type="submit" value="Wyslij"></form:input>
		        </td>
		    </tr>
		</table>
		</form:form>
		<a href="${showPatientListURL}"><div class="back"></div></a>
	</div>
<%@include file="/WEB-INF/jsp/footer.jsp"%>