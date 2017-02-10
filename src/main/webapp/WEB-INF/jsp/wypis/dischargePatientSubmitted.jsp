<%@include file="/WEB-INF/jsp/header.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tabela pacjentow</title>
<%@include file="/WEB-INF/jsp/header2.jsp"%>
	<div class="container" align="center">
		<h2>Wypis pacjenta ukonczony</h2>
		<table class="table table-condensed">
		    <tr>
		        <td>ID Pacjenta</td>
		        <td>${dischargedPatientForm.patientShortInfoId}</td>
		    </tr>
		    <tr>
		        <td>Przyczyna wypisu</td>
		        <td>${dischargedPatientForm.reason}</td>
		    </tr>
		    <tr>
		        <td>Komentarz</td>
		        <td>${dischargedPatientForm.comment}</td>
		    </tr>
		</table>  
		<p class="text-center"><a href="dischargePatient">Wypisz innego pacjenta</a></p>
		<p class="text-center"><a href="../patient/">Lista pacjentow</a></p>  
		<p class="text-center"><a href="newPatient">Zarejestruj pacjenta</a></p>
	</div>
<%@include file="/WEB-INF/jsp/footer.jsp"%>