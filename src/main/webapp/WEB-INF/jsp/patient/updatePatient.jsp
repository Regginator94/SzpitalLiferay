<%@include file="/WEB-INF/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=request.getContextPath()%>/static/css/patient.css" />
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tabela pacjentow</title>-->
<%@include file="/WEB-INF/jsp/header2.jsp"%>
<portlet:actionURL var="showUpdatedPatientFormSubmittedURL">
    <portlet:param name="action" value="showUpdatedPatientFormSubmitted"/>
</portlet:actionURL>
<portlet:renderURL var="showPatientListURL">
    <portlet:param name="action" value="index"/>
</portlet:renderURL>
	<div> <!--class="container" align="center">--> 
		<h2>Modyfikacja pacjenta</h2>
		<form:form method="post" modelAttribute="patientForm" action="${showUpdatedPatientFormSubmittedURL}">
		<table class="table table-condensed">
		    <tr>
		        <td><form:label path="id">ID</form:label></td>
		        <td><form:input path="id" value="${currentPatientShortInfo.id}" readonly="true" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="name">Imię</form:label></td>
		        <td><form:input path="name" value="${currentPatientShortInfo.name}" required="true" />
		        <form:errors path="name" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="secondName">Drugie imię</form:label></td>
		        <td><form:input path="secondName" value="${currentPatientShortInfo.secondName}" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="surname">Nazwisko</form:label></td>
		        <td><form:input path="surname" value="${currentPatientShortInfo.surname}"/>
		        <form:errors path="surname" class="text-danger" required="true" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="bornDate">Data urodzenia (rrrr-mm-dd)</form:label></td>
		        <td><form:input path="bornDate" value="${currentPatientShortInfo.bornDate}" type="text" class="date" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" required="true" />
		        <form:errors path="bornDate" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="idNumber">PESEL</form:label></td>
		        <td><form:input path="idNumber" value="${currentPatientShortInfo.idNumber}" pattern="[0-9]{11}" title="11-cyfrowy PESEL" required="true"/>
		        <form:errors path="idNumber" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="sex">Płeć (K/M)</form:label></td>
		        <td><form:input path="sex" value="${currentPatientShortInfo.sex}" pattern="[KM]{1}" title="Litera K lub litera M" required="true" />
		        <form:errors path="sex" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="phoneNumber">Telefon (xxx-xxx-xxx)</form:label></td>
		        <td><form:input path="phoneNumber" value="${currentPatientShortInfo.phoneNumber}" pattern="\d{3}[\-]\d{3}[\-]\d{3}" title="Numer postaci xxx-xxx-xxx" required="true" />
		        <form:errors path="phoneNumber" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="nationality">Kraj</form:label></td>
		        <td><form:input path="nationality" value="${currentPatientShortInfo.nationality}" title="Poprawny kraj" required="true" />
		        <form:errors path="nationality" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="insuranceNumber">Numer ubezpieczenia</form:label></td>
		        <td><form:input path="insuranceNumber" value="${currentPatientShortInfo.insuranceNumber}" pattern="[1-9][0-9]{1,}" title="Poprawny numer ubezpieczenia" required="true" />
		        <form:errors path="insuranceNumber" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="homeAddress">Adres (miejscowość, ulica, nr domu)</form:label></td>
		        <td><form:input path="homeAddress" value="${currentPatientShortInfo.homeAddress}" title="Poprawny adres" required="true" />
		        <form:errors path="homeAddress" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <form:input class="submit" path="" type="submit" value="Wyślij"></form:input>
		        </td>
		    </tr>
		</table>
		</form:form>  
		<a href="${showPatientListURL}"><div class="back"></div></a>
	
	</div>
<%@include file="/WEB-INF/jsp/footer.jsp"%>