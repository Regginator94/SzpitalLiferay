<%@include file="/WEB-INF/jsp/header.jsp"%>
<title>Raport pielęgniarski</title>
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

<h1 align="center">Raport pielegniarski</h1> 

<table class="table table-condensed"> 
	<tr>
		<td>Data:</td>
        <td><input type="text" id="datepicker"></td>
        <td></td>
        <td>
        	<form>
			  <label for="raportType">Rodzaj raportu:</label>
			  <select name="raportType" id="raportType">
			    <option>Ranny</option>
			    <option>Popoludniowy</option>
			    <option>Nocny</option>
			  </select>
			</form>
</table>	
<table class="table table-condensed"> 		
	<thead>
		<tr>
			<th width="10%">Numer wpisu</th>
			<th width="20%">Statystyka</th>
			<th width="30%">Dane indentyfikujace pacjenta</th> 
			<th width="40%">Opis zdarzenia</th>
		</tr>
	</thead>
	<tr>
		<td width="10%">1 </td>
		<td width="20%"> 
			<table class="table table-condensed">
            <tr>
              <td>
              	<form>
				  <label for="Przyjeto">Przyjeto:</label>
				  <select name="Przyjeto" id="Przyjeto">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>
			<tr>
              <td>
              	<form>
				  <label for="Wypisano">Wypisano:</label>
				  <select name="Wypisano" id="Wypisano">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>            
            <tr>
              <td>
              	<form>
				  <label for="Zmarlo">Zmarlo:</label>
				  <select name="Zmarlo" id="Zmarlo">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>
            <tr>
              <td>
              	<form>
				  <label for="Goraczkujacy">Goraczkujacy:</label>
				  <select name="Goraczkujacy" id="Goraczkujacy">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>
          </table>
		</td>
		<td>
			<table class="table table-condensed">
				<tr>
				  <td>
	              	<form>
					  <label for="Goraczkujacy"></label>
					  <select name="Goraczkujacy" id="Goraczkujacy">
					    <option>pacjent 1</option>
					    <option>pacjent 2</option>
					    <option>pacjent 4</option>
					  </select>
					</form>
	              </td>
               </tr>
			</table>
		</td>
		<td><textarea rows="4" cols="50"></textarea></td>
	</tr>
		<tr>
		<td width="10%">2 </td>
		<td width="20%"> 
			<table class="table table-condensed">
            <tr>
              <td>
              	<form>
				  <label for="Przyjeto">Przyjeto:</label>
				  <select name="Przyjeto" id="Przyjeto">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>
			<tr>
              <td>
              	<form>
				  <label for="Wypisano">Wypisano:</label>
				  <select name="Wypisano" id="Wypisano">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>            
            <tr>
              <td>
              	<form>
				  <label for="Zmarlo">Zmarlo:</label>
				  <select name="Zmarlo" id="Zmarlo">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>
            <tr>
              <td>
              	<form>
				  <label for="Goraczkujacy">Goraczkujacy:</label>
				  <select name="Goraczkujacy" id="Goraczkujacy">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>
          </table>
		</td>
		<td>
			<table class="table table-condensed">
				<tr>
				  <td>
	              	<form>
					  <label for="Goraczkujacy"></label>
					  <select name="Goraczkujacy" id="Goraczkujacy">
					    <option>pacjent 1</option>
					    <option>pacjent 2</option>
					    <option>pacjent 4</option>
					  </select>
					</form>
	              </td>
               </tr>
			</table>
		</td>
		<td><textarea rows="4" cols="50"></textarea></td>
	</tr>
		<tr>
		<td width="10%">3 </td>
		<td width="20%"> 
			<table class="table table-condensed">
            <tr>
              <td>
              	<form>
				  <label for="Przyjeto">Przyjeto:</label>
				  <select name="Przyjeto" id="Przyjeto">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>
			<tr>
              <td>
              	<form>
				  <label for="Wypisano">Wypisano:</label>
				  <select name="Wypisano" id="Wypisano">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>            
            <tr>
              <td>
              	<form>
				  <label for="Zmarlo">Zmarlo:</label>
				  <select name="Zmarlo" id="Zmarlo">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>
            <tr>
              <td>
              	<form>
				  <label for="Goraczkujacy">Goraczkujacy:</label>
				  <select name="Goraczkujacy" id="Goraczkujacy">
				    <option>0</option>
				    <option>1</option>
				    <option>2</option>
				  </select>
				</form>
              </td>
            </tr>
          </table>
		</td>
		<td>
			<table class="table table-condensed">
				<tr>
				  <td>
	              	<form>
					  <label for="Goraczkujacy"></label>
					  <select name="Goraczkujacy" id="Goraczkujacy">
					    <option>pacjent 1</option>
					    <option>pacjent 2</option>
					    <option>pacjent 4</option>
					  </select>
					</form>
	              </td>
               </tr>
			</table>
		</td>
		<td><textarea rows="4" cols="50"></textarea></td>
	</tr>
</table>	
<%@include file="/WEB-INF/jsp/footer.jsp"%>
