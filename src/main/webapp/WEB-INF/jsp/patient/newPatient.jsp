<%@include file="/WEB-INF/jsp/header.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tabela pacjentow</title>
<%@include file="/WEB-INF/jsp/header2.jsp"%>
	<div class="container" align="center">
		<h2>Rejestracja pacjenta</h2>
		<form:form method="post" modelAttribute="patientForm" action="addPatient">
		<table class="table table-condensed">
		    <tr>
		        <td><form:label path="id">ID</form:label></td>
		        <td><form:input path="id" />
		        <td><form:errors path="id" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="name">Imie</form:label></td>
		        <td><form:input path="name" />
		        <form:errors path="name" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="secondName">Drugie imie</form:label></td>
		        <td><form:input path="secondName" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="surname">Nazwisko</form:label></td>
		        <td><form:input path="surname" />
		        <form:errors path="surname" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="bornDate">Data urodzenia (rrrr-mm-dd)</form:label></td>
		        <td><form:input path="bornDate" />
		        <form:errors path="bornDate" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="idNumber">PESEL</form:label></td>
		        <td><form:input path="idNumber" />
		        <form:errors path="idNumber" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="sex">Plec</form:label></td>
		        <td><form:input path="sex" />
		        <form:errors path="sex" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="phoneNumber">Telefon (xxx-xxx-xxx)</form:label></td>
		        <td><form:input path="phoneNumber" />
		        <form:errors path="phoneNumber" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="nationality">Kraj</form:label></td>
		        <td><form:input path="nationality" />
		        <form:errors path="nationality" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="insuranceNumber">Numer ubezpieczenia</form:label></td>
		        <td><form:input path="insuranceNumber" />
		        <form:errors path="insuranceNumber" class="text-danger"/></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <form:input class="submit" path="" type="submit" value="Wyslij"></form:input>
		        </td>
		    </tr>
		</table>
		</form:form>  
	</div>
<%@include file="/WEB-INF/jsp/footer.jsp"%>