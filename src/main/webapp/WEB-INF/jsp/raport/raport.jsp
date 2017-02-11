<%@include file="/WEB-INF/jsp/header.jsp"%>
<title>Raport pielÄgniarski</title>
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
			    <option>Popołudniowy</option>
</table>	
<table class="table table-condensed"> 		
	<thead>
		<tr>
			<th width="30%">Dane indentyfikujące pacjenta</th> 
			<th width="40%">Opis aktywności</th>
			<th>Dodatkowe informacje</th>
		</tr>
	</thead>
	<tr>
				  <label for="Przyjeto">Przyjęto:</label>
				  <label for="Zmarlo">Zmarło:</label>
				  <label for="Goraczkujacy">Gorączkujący:</label>
		</td>
		<td>
			<table class="table table-condensed">
				<tr>
			        <tr><form:select path="patientList" id= "selectId" items="${patientList}" /></tr>
               </tr>
			</table>
		</td>
		<td><textarea rows="4" cols="50"></textarea></td>
		<td></td>
	</tr>
		<tr>
				  <label for="Przyjeto">Przyjęto:</label>
				  <label for="Zmarlo">Zmarło:</label>
				  <label for="Goraczkujacy">Gorączkujący:</label>
		</td>
		<td>
			<table class="table table-condensed">
				<tr>
			        <tr><form:select path="patientList" id= "selectId"  items="${patientList}" /></tr>
               </tr>
			</table>
		</td>
		<td><textarea rows="4" cols="50"></textarea></td>
		<td></td>
	</tr>
		<tr>
				  <label for="Przyjeto">Przyjęto:</label>
				  <label for="Zmarlo">Zmarło:</label>
				  <label for="Goraczkujacy">Gorączkujący</label>
		</td>
		<td>
			<table class="table table-condensed">
				<tr>
			        <tr><form:select path="patientList" id= "selectId" items="${patientList}" /></tr>
               </tr>
			</table>
		</td>
		<td><textarea rows="4" cols="50"></textarea></td>
		<td></td>
	</tr>
</table>	
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

