<%@include file="/WEB-INF/jsp/header.jsp"%>
<!--  <title>Lista pacjentow</title> -->
<%@include file="/WEB-INF/jsp/header2.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/__jquery.tablesorter/jquery.tablesorter.min.js"></script>
	<script type="text/javascript">
$(document).ready(function(){   
	$('#sort').tablesorter(); 	
});
</script>

<portlet:renderURL var="showPatientFormURL">
    <portlet:param name="action" value="showPatientForm"/>
</portlet:renderURL>
<portlet:renderURL var="showDischargedPatientFormURL">
    <portlet:param name="action" value="showDischargedPatientForm"/>
</portlet:renderURL>
	<div> 
		<div>
			<table id="sort" class="table table-striped table-bordered tablesorter">	
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
								<td>${shortInfo.id}</td>
								<td>${shortInfo.name}</td>
								<td>${shortInfo.surname}</td>
								<td>${shortInfo.bornDate}</td>					
								<td>${shortInfo.idNumber}</td>	
								<td>${shortInfo.phoneNumber}</td> 	
								<portlet:renderURL var="WidokSzczegolowy">
												<portlet:param name="action" value="detailsView" />
												<portlet:param name="id" value="${shortInfo.id}" />
								</portlet:renderURL>	
								<td><a href="${WidokSzczegolowy}">Szczegoly</a></td>			 
							</tr>
						</c:forEach>
					</tbody>
			</table> 
			<p><a href="${showPatientFormURL}">Rejestracja pacjenta</a></p>
			<p><a href="${showDischargedPatientFormURL}">Wypis pacjenta</a></p>
		</div>
	</div> 
	</div>		
<%@include file="/WEB-INF/jsp/footer.jsp"%>
