<%@include file="/WEB-INF/jsp/header.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tabela pacjentow</title>
<%@include file="/WEB-INF/jsp/header2.jsp"%>
	<div class="container" align="center">
		<h2>Rejestracja pacjenta ukonczona</h2>
		<table class="table table-condensed">
		    <tr>
		        <td>ID</td>
		        <td>${patientForm.id}</td>
		    </tr>
		    <tr>
		        <td>Imię</td>
		        <td>${patientForm.name}</td>
		    </tr>
		    <tr>
		        <td>Drugie imię</td>
		        <td>${patientForm.secondName}</td>
   	 		</tr>
   	 		<tr>
		        <td>Nazwisko</td>
		        <td>${patientForm.surname}</td>
   	 		</tr>
   	 		<tr>
		        <td>Data urodzenia</td>
		        <td>${patientForm.bornDate}</td>
   	 		</tr>
   	 		<tr>
		        <td>PESEL</td>
		        <td>${patientForm.idNumber}</td>
   	 		</tr>
   	 		<tr>
		        <td>Plec</td>
		        <td>${patientForm.sex}</td>
   	 		</tr>
   	 		<tr>
		        <td>Telefon</td>
		        <td>${patientForm.phoneNumber}</td>
   	 		</tr>
   	 		<tr>
		        <td>Kraj</td>
		        <td>${patientForm.nationality}</td>
   	 		</tr>
   	 		<tr>
		        <td>Numer ubezpieczenia</td>
		        <td>${patientForm.insuranceNumber}</td>
   	 		</tr>
		</table>
		<p class="text-center"><a href="newPatient">Zarejestruj innego pacjenta</a></p>
		<p class="text-center"><a href="../patient/">Lista pacjentów</a></p>  
	</div>
<%@include file="/WEB-INF/jsp/footer.jsp"%>