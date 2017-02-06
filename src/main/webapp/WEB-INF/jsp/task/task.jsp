<%@include file="/WEB-INF/jsp/header.jsp"%>
<%@include file="/WEB-INF/jsp/header2.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/__jquery.tablesorter/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/todo.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap_button_list.js"></script>



	<div class="container" align="center">
	


		<div class="row">
			<table id="sort2" class="table table-striped table-bordered tablesorter">	
				<thead>
					<tr>
						<th>ID</th>
						<th>title</th>
						<th>description</th> 
						<th>priority</th>
						<th>status</th>
				
					</tr>
				</thead>
					<tbody>
						<c:forEach items="${taskDetailsList}" var="details" >
							<tr>
								<td>${details.id}</td>
								<td>${details.title}</td>
								<td>${details.description}</td>
								<td>${details.priority}</td>					
								<td>${details.status}</td>	
										
							</tr>
						</c:forEach>
					</tbody>
			</table> 
			
		</div>
		
			<div class="task-container">
                	<div class="task-list">
                		<h3>Zadania</h3>
	                	<div class="task-status" id="pending"></div>
	             		<div class="task-status" id="inProgress">_____________________</div>
						<div class="task-status" id="completed">_____________________</div>
					</div>
			</div>
        
	
            <div class="task-list">
                <h3>Dodaj zadanie</h3>
                <form id="todo-form">
                    <input type="text" class="t-f" placeholder="Tytul" />
                    <textarea placeholder="Opis" class="t-f"  style="resize: none;"></textarea>
                    <input type="text" class="t-f"  id="datepicker" placeholder="Do (dd/mm/yyyy)" />
                   <!-- 	<input type="text" placeholder="test" /> -->
                 <div class="row" id="prio" style="padding: 10px">
		                   <h4 class="text-center">Priorytet</h4>
		                 
		                   <span class="button-checkbox">
		      					  <button type="button" class="btn btn_pad" name="p1" data-color="danger">WAZNE!</button>
		      					  <input type="checkbox" class="hidden" checked />
		   				   </span> <br>
		   				   <span class="button-checkbox">
		      					  <button type="button" class="btn btn_pad" name="p2" data-color="warning">PODWYZSZONY</button>
		      					  <input type="checkbox" class="hidden"  checked />
		   				   </span> <br>
		   				   <span class="button-checkbox">
		      					  <button type="button" class="btn btn_pad" name="p3" data-color="info">NORMALNY</button>
		      					  <input type="checkbox" class="hidden"  checked />
		   				   </span>
	   				<!--   	<div class="row col-lg-10" align="center">
		   				   <br>
		   				   		<button class="btn btn-primary" id="get-checked-data">Get Checked Data</button>
		            			<pre id="display-json" ></pre>
     					</div>  -->
   				</div>  
   				 <input type="button" class="btn btn-primary" id="adding" value="Dodaj" onclick="sendAndAdd();" />
                   
                </form>
 <input type="button" class="btn btn-primary" value="Wyczysc" onclick="todo.clear();" />
               
			<div id="delete-div">
                    Przeciagnij tu by usunac.
            </div>
                
            </div>

            <div style="clear:both;"></div>

               </div>
                   
                    
      
           


	</div>
	
<script type="text/javascript">
$(document).ready(function(){   
    
 	$('#sort2').tablesorter(); 	 
	$( "#datepicker" ).datepicker();
	$( "#datepicker" ).datepicker("option", "dateFormat", "dd/mm/yy");

	$(".task-container").droppable();
	$(".todo-task").draggable({ revert: "valid", revertDuration:200 });
	
	var task = JSON.parse('${taskJson}'); 
	sendAndAdd = function() {
        //event.preventDefault(); 
    var checkedItems = {}, counter = 0;
        $("#prio .active").each(function(idx, button) {
	            checkedItems[counter] = button.name;
	            counter++;
        });
        var string = JSON.stringify(checkedItems, null, '\t');
		
     prior = JSON.parse(string);
     todo.getPriors(prior);
     todo.add();
	}
	todo.init(task);
});
</script>
	
<%@include file="/WEB-INF/jsp/footer.jsp"%>
