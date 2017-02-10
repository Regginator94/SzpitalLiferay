<%@include file="/WEB-INF/jsp/header.jsp"%>
<!--  <title>Lista pacjentow</title> -->
<%@include file="/WEB-INF/jsp/header2.jsp"%>
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=request.getContextPath()%>/static/css/patient.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/__jquery.tablesorter/jquery.tablesorter.min.js"></script>
	<script type="text/javascript">
$(document).ready(function(){   
	$('#sort').tablesorter(); 	
});
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/searchbar.js"></script>
<portlet:renderURL var="showPatientFormURL">
    <portlet:param name="action" value="showPatientForm"/>
</portlet:renderURL>
<portlet:renderURL var="showDischargedPatientFormURL">
    <portlet:param name="action" value="showDischargedPatientForm"/>
</portlet:renderURL>
	<div> 
		<div>
			<input type="text" id="szukaj_osoby" placeholder="Szukaj pacjenta...">
			<table id="sort" class="table table-striped table-bordered tablesorter centertab" style="text-align: center;">	
				<thead>
					<tr>
						<th>ID</th>
						<th>Imie</th>
						<th>Nazwisko</th> 
						<th>Data urodzenia</th>
						<th>PESEL</th>
						<th>Numer telefonu</th>
						<th></th>
					</tr>
				</thead>
					<tbody>
						<c:forEach items="${patientShortInfoList}" var="shortInfo">
							<tr>
								<portlet:renderURL var="KartaPacjenta">
												<portlet:param name="action" value="showPatientCard" />
												<portlet:param name="id" value="${shortInfo.id}" />
								</portlet:renderURL>
								<td><a href="${KartaPacjenta}">${shortInfo.id}</a></td>
								<td>${shortInfo.name}</td>
								<td>${shortInfo.surname}</td>
								<td>${shortInfo.bornDate}</td>					
								<td>${shortInfo.idNumber}</td>	
								<td>${shortInfo.phoneNumber}</td> 	
								<portlet:renderURL var="WidokSzczegolowy">
												<portlet:param name="action" value="showUpdatedPatientForm" />
												<portlet:param name="id" value="${shortInfo.id}" />
								</portlet:renderURL>	
								<td ><a href="${WidokSzczegolowy}" ><div class="modify-patient"></div></a></td>
							</tr>
						</c:forEach>
					</tbody>
			</table> 
			<a href="${showPatientFormURL}"><span class="add-patient"></span></a>
			<a href="${showDischargedPatientFormURL}"><span class="delete-patient"></span></a>
		</div>
	</div> 
	
<%@include file="/WEB-INF/jsp/footer.jsp"%>
