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
	<!--<div class="container" align="center">
	 <div class="row">
	 	<div class="col-md-8 col-lg-8 col-sm-8 col-xs-8" >
			<p>Tu na razie jest sciernisko...<br>
			ale bedzie zegar</p>
		</div>
		<div class="col-md-4 col-lg-4 col-sm-4 col-xs-4" align="right">
			<p>A tam, gdzie to kretowisko...<br>
			beda notyfikacje</p>
		</div> 
		
	</div>-->
<!-- 	<h1>Lista Pacjentów</h1>  -->
	
	<!--<div class="row"> 
		<div class="col-md-2 col-lg-2 col-sm-12 col-xs-12">
			
			<ul class="list-inline">
				<li><a href="#" class="list-group-item home"></a></li>
				<li><a href="#" class="list-group-item patient"></a></li>
				<li><a href="#" class="list-group-item archive"></a></li>
				<li><a href="#" class="list-group-item report"></a></li>
				<li><a href="#" class="list-group-item pharmacy"></a></li>
			</ul>
		</div>  -->

	<div> <!-- class="col-md-10 col-lg-10 col-sm-12 col-xs-12" -->
	
	<!--  	<div class="row" align="left">
			<ol class="breadcrumb" >
				<li><a href="#">Home</a></li>
				<li><a href="#">Cos</a></li>
				<li class="active">Lista Pacjentów</li>
			</ol>
		</div>   -->

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
												<portlet:param name="action" value="showUpdatedPatientForm" />
												<portlet:param name="id" value="${shortInfo.id}" />
								</portlet:renderURL>	
								<td><a href="${WidokSzczegolowy}">Modyfikuj</a></td>			 
							</tr>
						</c:forEach>
					</tbody>
			</table> 
			<p><a href="${showPatientFormURL}">Rejestracja pacjenta</a></p>
			<p><a href="${showDischargedPatientFormURL}">Wypis pacjenta</a></p>
		</div>
		
	<!--	<div class="row">
	  	<div class="col-md-8 col-lg-8 col-sm-8 col-xs-8" align="left">
			<p>buttoniki</p>
		</div> 
		<div class="col-md-4 col-lg-4 col-sm-4 col-xs-4" align="right">
			<p>1 / 8</p>
		</div>

		</div> -->
	</div> 

	

	
<%@include file="/WEB-INF/jsp/footer.jsp"%>
