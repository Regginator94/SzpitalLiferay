<%@include file="/WEB-INF/jsp/header.jsp"%>

<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tabela pacjentow</title>-->
<%@include file="/WEB-INF/jsp/header2.jsp"%>
<portlet:actionURL var="showPatientCardUpdatedURL">
    <portlet:param name="action" value="showPatientCardUpdated"/>
    <portlet:param name="id" value="${patientFullInfo.id}"/>
</portlet:actionURL>
<portlet:renderURL var="showPatientListURL">
    <portlet:param name="action" value="index"/>
</portlet:renderURL>
	<div> <!--class="container" align="center">--> 
		<h2>Karta pacjenta</h2>
		<h4>Dane osobowe</h4>
		<p>Imie i nazwisko: ${patientFullInfo.name} ${patientFullInfo.surname}</p>
		<p>Data urodzenia: ${patientFullInfo.bornDate}</p>
		<p>PESEL: ${patientFullInfo.idNumber}</p>
		<p>Adres zamieszkania: ${patientFullInfo.homeAddress}</p>
		<p>Numer ubezpieczenia: ${patientFullInfo.insuranceNumber}</p>
		<h4>Obecny stan pacjenta</h4>
		<p>${patientFullInfo.healthStatus}</p>
		Zmien stan pacjenta:
		<form:form method="post" modelAttribute="updatedPatient" action="${showPatientCardUpdatedURL}">
		<form:select path="healthStatus" items="${healthStatusList}" />
		<form:input class="submit" path="" type="submit" value="Zmien stan"></form:input>
		</form:form>
		<h4>Stwierdzona choroba</h4>
		<p>${patientFullInfo.disease}</p>
		<h4>Przyjmowane leki</h4>
		<p>${patientFullInfo.medicines}</p>
		Dodaj nowe leki:
		<form:form method="post" modelAttribute="updatedPatient" action="${showPatientCardUpdatedURL}">
		<form:input path="medicines" />
		<form:input class="submit" path="" type="submit" value="Dodaj leki"></form:input>
		</form:form>
		<h4>Alergie</h4>
		<p>${patientFullInfo.allergies}</p>
		Dodaj nowe alergie:
		<form:form method="post" modelAttribute="updatedPatient" action="${showPatientCardUpdatedURL}">
		<form:input path="allergies" />
		<form:input class="submit" path="" type="submit" value="Dodaj alergie"></form:input>
		</form:form>
		<h4>Aktywnosci</h4>
		<p><a href="${showPatientListURL}">Powrot do listy pacjentow</a></p>  
	</div>
<%@include file="/WEB-INF/jsp/footer.jsp"%>