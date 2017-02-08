<%@include file="/WEB-INF/jsp/header.jsp"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/__jquery.tablesorter/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/todo.js"></script>

<%@include file="/WEB-INF/jsp/header2.jsp"%>




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
	                	<div class="task-status" id="pending">_____________________</div>
	             		<div class="task-status" id="inProgress">_____________________</div>
						<div class="task-status" id="completed">_____________________</div>
						<button type="button" class="btn btn-primary" id="add-btn" data-toggle="button" aria-pressed="false" autocomplete="off">
  							+
						</button>
						<div id="delete-div">Przeciagnij tu by usunac.</div>
    					<div><div style="clear:both;"></div> 
       					</div>      
					</div>
			</div>
        
	
            <div id="add-container" class="hidden">
            
                <form id="todo-form">
                <h3>Dodaj zadanie</h3>
                    <input type="text" class="t-f" placeholder="Tytul" />
                    <textarea placeholder="Opis" class="t-f"  style="resize: none;"></textarea>
                    <input type="text" class="t-f"  id="datepicker" placeholder="Do (dd/mm/yyyy)" />
                   <!-- 	<input type="text" placeholder="test" /> -->
                
                 <div class="row" id="prio" style="padding: 10px">
		             <h4 class="text-center">Priorytet</h4>
				    <div class="[ form-group ]">
			            <input type="checkbox" name="p3" id="fancy-checkbox-info" autocomplete="off" />
			            <div class="[ btn-group ]">
			                <label for="fancy-checkbox-info" class="[ btn btn-info ]">
			                    <span class="[ glyphicon glyphicon-ok ]"></span>
			                    <span></span>
			                </label>
			                <label for="fancy-checkbox-info" class="[ btn btn-default ]">
			                    Normalny
			                </label>
			            </div>
        			</div>
			        <div class="[ form-group ]">
			            <input type="checkbox" name="p2" id="fancy-checkbox-warning"  autocomplete="off" />
			            <div class="[ btn-group ]">
			                <label for="fancy-checkbox-warning" class="[ btn btn-warning ]" >
			                    <span class="[ glyphicon glyphicon-ok ]"></span>
			                    <span></span>
			                </label>
			                <label for="fancy-checkbox-warning" class="[ btn btn-default ]" >
			                    Podwyzszony
			                </label>
			            </div>
			        </div>
			        <div class="[ form-group ]">
			            <input type="checkbox" name="p1" id="fancy-checkbox-danger" autocomplete="off" />
			            <div class="[ btn-group ]" >
			                <label for="fancy-checkbox-danger"  class="[ btn btn-danger ]"  >
			                    <span class="[ glyphicon glyphicon-ok ]"></span>
			                    <span></span>
			                </label>
			                <label for="fancy-checkbox-danger" class="[ btn btn-default ]" >
			                   Wysoki!
			                </label>
			            </div>
			        </div>
		                   <br>
	   					<input type="button" class="btn btn-primary" id="adding" value="Dodaj" onclick="sendAndAdd();" />
	   					<input type="button" class="btn btn-primary" value="Wyczysc" onclick="todo.clear();" />
	   					
   				</div> 
            </div>
      </div>            
      
           


	
<script type="text/javascript">
$(document).ready(function(){   
	
 	$('#sort2').tablesorter(); 	 
	$( "#datepicker" ).datepicker();
	$( "#datepicker" ).datepicker("option", "dateFormat", "dd/mm/yy");
	$(".task-container").droppable();
	$(".todo-task").draggable({ revert: "valid", revertDuration:200 });
	
	$("#add-btn").click(function () {	
		if(($(this).is('.enabled')) ) {
			$('#add-container').toggleClass('hidden');
		 }
		
		else {
			$('#add-container').removeClass('hidden');	
		}   
		$(this).toggleClass('enabled');   
		$('#add-container').toggleClass('task-list');
			});
	  
			$("#fancy-checkbox-info").click( function () {
		if($('#fancy-checkbox-info').is('.active')) {
				document.getElementById("fancy-checkbox-danger").removeAttribute("disabled");
				document.getElementById("fancy-checkbox-warning").removeAttribute("disabled");
		}
		else { 
				document.getElementById("fancy-checkbox-danger").disabled = true; 
				document.getElementById("fancy-checkbox-warning").disabled = true; 
		}
		$('#fancy-checkbox-info').toggleClass('active');	 
	});

	$("#fancy-checkbox-warning").click( function () {
		if($('#fancy-checkbox-warning').is('.active')) {
				document.getElementById("fancy-checkbox-danger").removeAttribute("disabled");
				document.getElementById("fancy-checkbox-info").removeAttribute("disabled");
		
		}
		else { 
				document.getElementById("fancy-checkbox-danger").disabled = true; 
				document.getElementById("fancy-checkbox-info").disabled = true; 
		}
		$('#fancy-checkbox-warning').toggleClass('active');	 
	});
	
	$("#fancy-checkbox-danger").click( function () {
		if($('#fancy-checkbox-danger').is('.active')) {
				document.getElementById("fancy-checkbox-info").removeAttribute("disabled");
				document.getElementById("fancy-checkbox-warning").removeAttribute("disabled");
		
		}
		else { 
				document.getElementById("fancy-checkbox-warning").disabled = true; 
				document.getElementById("fancy-checkbox-info").disabled = true; 
		}
		$('#fancy-checkbox-danger').toggleClass('active');	 
	});
	
	var task = JSON.parse('${taskJson}'); 
	sendAndAdd = function() {
    var checkedItems = {}, counter = 0;
        $("#prio .active").each(function(idx, input) {
        	//alert($('input').attr('name'));
	            checkedItems[counter] = input.name;
	            counter++;
        });
        var string = JSON.stringify(checkedItems, null, '\t');
		
     prior = JSON.parse(string);
     todo.getPriors(prior);
     todo.add();
	}
	todo.getTasks(task)
	todo.init();
	
});
</script>
	
<%@include file="/WEB-INF/jsp/footer.jsp"%>
