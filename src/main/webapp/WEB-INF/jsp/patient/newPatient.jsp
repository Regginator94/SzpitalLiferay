<%@include file="/WEB-INF/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=request.getContextPath()%>/static/css/patient.css" />
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tabela pacjentow</title>-->
<%@include file="/WEB-INF/jsp/header2.jsp"%>
<portlet:actionURL var="showPatientFormSubmittedURL">
    <portlet:param name="action" value="showPatientFormSubmitted"/>
</portlet:actionURL>
<portlet:renderURL var="showPatientListURL">
    <portlet:param name="action" value="index"/>
</portlet:renderURL>
	<div> <!--class="container" align="center">--> 
		<h2>Rejestracja pacjenta</h2>
		<form:form method="post" modelAttribute="patientForm" action="${showPatientFormSubmittedURL}">
		<table class="table table-condensed">
		    <tr>
		        <td><form:label path="id">ID</form:label></td>
		        <td><form:input path="id" pattern="[1-9]{1}[0-9]{0,}" title="Poprawny ID"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="name">Imie</form:label></td>
		        <td><form:input path="name" title="Poprawne imie" required="true" />
		        <form:errors path="name" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="secondName">Drugie imie</form:label></td>
		        <td><form:input path="secondName" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="surname">Nazwisko</form:label></td>
		        <td><form:input path="surname" title="Poprawne nazwisko" required="true" />
		        <form:errors path="surname" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="bornDate">Data urodzenia (rrrr-mm-dd)</form:label></td>
		        <td><form:input path="bornDate" type="text" class="date" required="true" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"/>
		        <form:errors path="bornDate" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="idNumber">PESEL</form:label></td>
		        <td><form:input path="idNumber" pattern="[0-9]{11}" title="11-cyfrowy PESEL" />
		        <form:errors path="idNumber" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="sex">Plec (K/M)</form:label></td>
		        <td><form:input path="sex" pattern="[KM]{1}" title="Litera K lub litera M" required="true" />
		        <form:errors path="sex" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="phoneNumber">Telefon (xxx-xxx-xxx)</form:label></td>
		        <td><form:input path="phoneNumber" pattern="\d{3}[\-]\d{3}[\-]\d{3}" title="Numer postaci xxx-xxx-xxx" required="true" />
		        <form:errors path="phoneNumber" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="nationality">Kraj</form:label></td>
		        <td><form:input path="nationality" title="Poprawny kraj" required="true" />
		        <form:errors path="nationality" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="insuranceNumber">Numer ubezpieczenia</form:label></td>
		        <td><form:input path="insuranceNumber" pattern="[1-9][0-9]{1,}" title="Poprawny numer ubezpieczenia" required="true"/>
		        <form:errors path="insuranceNumber" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="homeAddress">Adres (miejscowosc, ulica, nr domu)</form:label></td>
		        <td><form:textarea path="homeAddress" rows="2" style="resize:none;" title="Poprawny adres" required="true"/>
		        <form:errors path="homeAddress" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="healthStatus">Stan zdrowia pacjenta</form:label></td>
		        <td><form:select path="healthStatus" items="${healthStatusList}" /></td>
		        <form:errors path="healthStatus" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="disease">Choroba</form:label></td>
		        <td><form:input path="disease" title="Poprawny typ choroby" required="true"/>
		        <form:errors path="disease" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="medicines">Przyjmowane leki</form:label></td>
		        <td><form:textarea path="medicines" rows="3" style="resize:none;"/>
		        <form:errors path="medicines" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="medicines">Alergie (pokarmowe) pacjenta</form:label></td>
		        <td><form:textarea path="medicines" style="resize:none;" rows="3"/>
		        <form:errors path="medicines" class="text-danger"/></td>
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