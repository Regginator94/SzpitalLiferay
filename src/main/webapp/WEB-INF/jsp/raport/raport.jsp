<%@include file="/WEB-INF/jsp/header.jsp"%>
<title>Raport pielęgniarski</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
  $( "#datepicker" ).datepicker();
} );
</script>
<%@include file="/WEB-INF/jsp/header2.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/__jquery.tablesorter/jquery.tablesorter.min.js"></script>
<portlet:actionURL var="addActivitiesURL">
    <portlet:param name="action" value="addActivities"/>
</portlet:actionURL>
<h1 align="center">Raport pielęgniarski</h1> 

<table class="table table-condensed"> 
	<tr>
		<td>Data:</td>
        <td><input type="text" id="datepicker"></td>
        <td></td>
        <td>
		        <form:label path="raportList">Rodzja raportu</form:label>
		        <form:select path="raportList" items="${raportList}" />
		</td>
			    <option>Popołudniowy</option>
</table>	
<table class="table table-condensed"> 		
	<thead>
		<tr>
			<th width="30%">Dane indentyfikujące pacjenta</th> 
			<th width="40%">Opis aktywności</th>
			<th>Dodatkowe informacje</th>
		</tr>
	</thead>
	<tr>
		<td>
			<table class="table table-condensed">
				<form:form method="post" commandName="patientSend" action="${addActivitiesURL}">
				        <tr><form:select path="patient" items="${patientList}" /></tr>
				        <tr> <form:input class="submit" path="" type="submit" value="Wyślij"></form:input> </tr>
               </form:form>
			</table>
		</td>
		<td><textarea rows="4" cols="50">${activities}</textarea></td>
		<td><textarea rows="4" cols="50"></textarea></td>
	</tr>
		<tr>
		<td>
			<table class="table table-condensed">
				<form:form method="post" commandName="patientSend" action="${addActivitiesURL}">
				        <tr><form:select path="patient" items="${patientList}" /></tr>
				        <tr> <form:input class="submit" path="" type="submit" value="Wyślij"></form:input> </tr>
               </form:form>
			</table>
		</td>
		<td><textarea rows="4" cols="50">${activities1}</textarea></td>
		<td><textarea rows="4" cols="50"></textarea></td>
	</tr>
		<tr>
		<td>
			<table class="table table-condensed">
				<form:form method="post" commandName="patientSend" action="${addActivitiesURL}">
				        <tr><form:select path="patient" items="${patientList}" /></tr>
				        <tr> <form:input class="submit" path="" type="submit" value="Wyślij"></form:input> </tr>
               </form:form>
			</table>
		</td>
		<td><textarea rows="4" cols="50">${activities2}</textarea></td>
		<td><textarea rows="4" cols="50"></textarea></td>
	</tr>
</table>	
 <form:input class="submit" path="" type="submit" value="Generuj raport"></form:input>
<%@include file="/WEB-INF/jsp/footer.jsp"%>

<script type="text/javascript">
$("#selectId").on('change', function() {
	    $.ajax({
        action: "addActivities",
        type: "POST",
        data: JSON.stringify({"id":this.value}),
        dataType: "json",
        traditional: true,
        contentType: "application/json; charset=utf-8",
        success: function (data) {
           
        }
    });
})
</script>

