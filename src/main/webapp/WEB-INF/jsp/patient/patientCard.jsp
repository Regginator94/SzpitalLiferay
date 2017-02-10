<%@include file="/WEB-INF/jsp/header.jsp"%>

<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tabela pacjentow</title>-->
<%@include file="/WEB-INF/jsp/header2.jsp"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/__jquery.tablesorter/jquery.tablesorter.min.js"></script>
	<script type="text/javascript">
$(document).ready(function(){   
	$('#sort').tablesorter(); 	
});
</script>

<portlet:actionURL var="showPatientCardUpdatedURL">
    <portlet:param name="action" value="showPatientCardUpdated"/>
    <portlet:param name="id" value="${patientFullInfo.id}"/>
</portlet:actionURL>
<portlet:renderURL var="showPatientListURL">
    <portlet:param name="action" value="index"/>
</portlet:renderURL>

<portlet:actionURL var="showActivityAddedURL">
    <portlet:param name="action" value="showActivityAdded"/>
    <portlet:param name="id" value="${patientFullInfo.id}"/>
</portlet:actionURL>

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
		<table id="sort" class="table table-condensed table-stripped table-bordered">	
				<thead>
					<tr>
						<th>Data</th>
						<th>Aktywnosc</th> 
					</tr>
				</thead>
					<tbody>
						<c:forEach items="${activityList}" var="activity">
							<tr>
								<td>${activity.activityDatetime}</td>
								<td>${activity.activityType} (${activity.additionalInfo})</td>			 
							</tr>
						</c:forEach>
					</tbody>
			</table>
			Dodaj nowa aktywnosc i dodatkowe informacje:
			<form:form method="post" modelAttribute="activity" action="${showActivityAddedURL}">
			<form:select path="activityType" items="${activityTypeList}" />
			<form:input path="additionalInfo" />
			<form:input class="submit" path="" type="submit" value="Dodaj aktywnosc"></form:input>
			</form:form>
		<p><a href="${showPatientListURL}">Powrot do listy pacjentow</a></p>  
	</div>
<%@include file="/WEB-INF/jsp/footer.jsp"%>