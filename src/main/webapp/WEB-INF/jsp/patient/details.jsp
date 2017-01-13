<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-striped table-bordered">	
					<tr>
						<th>ID</th>
						<th>Imie</th>
						<th>Nazwisko</th> 
						<th>Data urodzenia</th>
						<th>PESEL</th> 
						<th>Numer telefonu</th>	
					</tr>
					<tr>
						<td class="filter" ></td>
						<td class="filter"></td>
						<td class="filter"></td>
						<td class="filter"></td>
						<td class="filter"></td>
						<td class="filter"></td>
					</tr>
				<tbody>
						<tr>
							<td>${patientShortInfo.id}</td>
							<td>${patientShortInfo.name}</td>
							<td>${patientShortInfo.surname}</td>
							<td>${patientShortInfo.bornDate}</td>					
							<td>${patientShortInfo.idNumber}</td>	
							<td>${patientShortInfo.phoneNumber} </td> 							
						</tr>
				</tbody>
							</table> 
</body>
</html>