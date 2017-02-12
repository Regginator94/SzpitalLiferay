<%@include file="/WEB-INF/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=request.getContextPath()%>/static/css/patient.css" />
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tabela pacjentow</title>-->
<%@include file="/WEB-INF/jsp/header2.jsp"%>
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=request.getContextPath()%>/static/css/patient.css" />
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
		<div class="left">
		<h2>Karta pacjenta</h2>
		<h4>Dane osobowe</h4>
		<p>Imię i nazwisko: ${patientFullInfo.name} ${patientFullInfo.surname}</p>
		<p>Data urodzenia: ${patientFullInfo.bornDate}</p>
		<p>PESEL: ${patientFullInfo.idNumber}</p>
		<p>Adres zamieszkania: ${patientFullInfo.homeAddress}</p>
		<p>Numer ubezpieczenia: ${patientFullInfo.insuranceNumber}</p>
		<div id="section-3">
			<div class="divided-section">
				<h4 class="text-style"><b>Obecny stan pacjenta:</b></h4><p style="padding-left:40px">${patientFullInfo.healthStatus}</p>
				<h4 class="text-style">Zmień stan pacjenta</h4>
					<div style="padding-left: 70px; padding-bottom: 10px;">
					<form:form method="post" modelAttribute="updatedPatient" action="${showPatientCardUpdatedURL}">
					<form:select path="healthStatus" items="${healthStatusList}" />
					<form:input class="submit" path="" type="submit" value="Zmień stan"></form:input>
					</form:form>
					</div>
				<h4 class="text-style"><b>Stwierdzona choroba:</b></h4>
			<p style="padding-left:40px">${patientFullInfo.disease}</p>
			<h4 class="text-style"><b>Przyjmowane leki:</b></h4>
			<p style="padding-left:40px">${patientFullInfo.medicines}</p>
			<h4 class="text-style">Podaj nowe leki</h4>
			<div style="padding-left: 70px; padding-bottom: 10px;">
				<form:form method="post" modelAttribute="updatedPatient" action="${showPatientCardUpdatedURL}">
				<form:input path="medicines" />
				<form:input class="submit" path="" type="submit" value="Dodaj leki"></form:input>
				</form:form>
			</div>
			<h4 class="text-style"><b>Alergie:</b></h4>
			<p style="padding-left:40px">${patientFullInfo.allergies}</p>
			<h4 class="text-style">Dodaj nowe alergie</h4>
			<div style="padding-left: 70px; padding-bottom: 10px;">
				<form:form method="post" modelAttribute="updatedPatient" action="${showPatientCardUpdatedURL}">
				<form:input path="allergies" />
				<form:input class="submit" path="" type="submit" value="Dodaj alergie"></form:input>
				</form:form>
			</div>
			<a href="${showPatientListURL}"><div class="back"></div></a>
				
			</div>
			
			
		</div>
		</div>
		<div class="right">
		<h4>Aktywności</h4>
		<table id="sort" class="table table-condensed table-stripped table-bordered" style="background: rgba(158, 158, 158, 0.1);">	
				<thead>
					<tr>
						<th>Data</th>
						<th>Aktywność</th> 
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
			Dodaj nową aktywność i dodatkowe informacje:
			<form:form method="post" modelAttribute="activity" action="${showActivityAddedURL}">
			<form:select path="activityType" items="${activityTypeList}" />
			<form:input path="additionalInfo" />
			<form:input class="submit" path="" type="submit" value="Dodaj aktywność"></form:input>
			</form:form>
					
			</div>
	</div>
<%@include file="/WEB-INF/jsp/footer.jsp"%>