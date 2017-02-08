
/* Some info
Using newer versions of jQuery and jQuery UI in place of the links given in problem statement
All data is stored in local storage
User data is extracted from local storage and saved in variable todo.data
Otherwise, comments are provided at appropriate places
*/
var task;
var priority;
var todo = todo || {},
    data = JSON.parse(localStorage.getItem("todoData")) || [];


data = data || {};




(function(todo, data, $) {
	
    var defaults = {
            todoTask: "todo-task",
            todoHeader: "task-header",
            todoDate: "task-date",
            todoDescription: "task-description",
            todoPriority: "task-priority",
            taskId: "task-id",
            formId: "todo-form",
            dataAttribute: "data",
            deleteDiv: "delete-div"
        }, status = {
            "1" : "#pending",
            "2" : "#inProgress",
            "3" : "#completed"
        };

    
    todo.getTasks = function (tasks) {
    	task = tasks;
    }
    
    todo.init = function (options) {
    	
    	
        options = options || {};
        options = $.extend({}, defaults, options);

        loadElements();
        
        
        $.each(data, function (index, params) {
            generateElement(params);
       
        });
        
        
        todo.getPriors = function (prior) {
        	priority = prior;
        }
        
        

       
        // Adding drop function to each category of task
        $.each(status, function (index, value) {
            $(value).droppable({
                drop: function (event, ui) {
                        var element = ui.helper,
                            css_id = element.attr("id"),
                            id = css_id.replace(options.taskId, ""),
                            object = data[id];
                        	if(id < 100000) {
                        		object = data[id-1];
                        	} else {
                        		object = data[id];
                        	}
                        
                            // Removing old element
                            removeElement(object);

                            // Changing object code
                            object.code = index;

                            // Generating new element
                            generateElement(object);

                            // Updating Local Storage
                            if(id < 100000) {
                            	data[id-1] = object;
                            } else {
                            	data[id] = object;
                            }
                            
                            	localStorage.setItem("todoData", JSON.stringify(data));

                            // Hiding Delete Area
                            $("#" + defaults.deleteDiv).hide();
                    }
            });
        });
       
        // Adding drop function to delete div
        $("#" + options.deleteDiv).droppable({
            drop: function(event, ui) {
                var element = ui.helper,
                    css_id = element.attr("id"),
                    id = css_id.replace(options.taskId, ""),
                    object = data[id];
                if(id < 100000) {
            		object = data[id-1];
            	} else {
            		object = data[id];
            	}
                // Removing old element
                removeElement(object);

                // Updating local storage
                if(id < 100000) {
                	delete data[id-1];
                } else {
                	delete data[id];
                }
                localStorage.setItem("todoData", JSON.stringify(data));

                // Hiding Delete Area
                $("#" + defaults.deleteDiv).hide();
            }
        })

    };
    
    function checkForValue(json, value) {
        for (key in json) {

        	if(json[key].title === value.title && json[key].description === value.description) {
        		return true;
        	}
        }
        return false;
    }
    
    var addItem = function (item) {
    	oldVal = JSON.parse(localStorage.getItem('todoData')) || [];
    	
    		if(!checkForValue(oldVal, item)) {
    			oldVal[item.id-1] = item;
		    	localStorage.setItem('todoData', JSON.stringify(oldVal));
	    	} 
    		
    	

    }
    var loadElements = function () {
    	for(i = 0; i < task.length; i++) {
    		tempData = {
    	            id : task[i].id,
    	            code : task[i].status,
    	            title:  task[i].title,
    	            priority: task[i].priority,
    	            date: task[i].date,
    	            description: task[i].description
    	        };
    		addItem(tempData);
    	}
    	

    };
    
    var readPriority = function () {
    	var p = 3;
    	for(i = 0; i < Object.keys(priority).length; i++) {
    		if(parseInt(priority[i].substring(1,2)) < p)
    			p = parseInt(priority[i].substring(1,2));
    	}
    	return p;
    };
    
    
 
    
    // Add Task
    var generateElement = function(params){
        var parent = $(status[params.code]),
            wrapper;
   
        if (!parent) {
            return;
        }

        wrapper = $("<div />", {
            "class" : defaults.todoTask,
            "id" : defaults.taskId + params.id,
            "data" : params.id
        }).appendTo(parent);

        $("<div />", {
            "class" : defaults.todoHeader,
            "text": params.title
        }).appendTo(wrapper);

        $("<div />", {
            "class" : defaults.todoDate,
            "text": params.date
        }).appendTo(wrapper);

        $("<div />", {
            "class" : defaults.todoDescription,
            "text": params.description
        }).appendTo(wrapper);
        
       
    	   if(params.priority == 1) {
    		   $("<div />", {
    		   "class" : defaults.todoPriority,
    		   "text": params.priority
    		   }).appendTo(wrapper);
    	   }
    	   
    	   if(params.priority == 2) {
    		   $("<div />", {
    		   "class" : "task-priority2",
    		   "text": params.priority
    		   }).appendTo(wrapper);
    	   }
    	   
    	   if(params.priority == 3) {
    		   $("<div />", {
    		   "class" : "task-priority3",
    		   "text": params.priority
    		   }).appendTo(wrapper);
    	   }
            
            
        

	    wrapper.draggable({
            start: function() {
                $("#" + defaults.deleteDiv).show();
            },
            stop: function() {
                $("#" + defaults.deleteDiv).hide();
            },
	        revert: "invalid",
	        revertDuration : 200
        });

    };
  
    // Remove task
    var removeElement = function (params) {

    	$("#" + defaults.taskId + params.id).remove();
    
       
    	
    };
    
    // Adding task using form
    todo.add = function() {
        var inputs = $("#todo-form .t-f"),
            errorMessage = "Title can not be empty",
            id, title, description,date, priority, tempData;

        
        title = inputs[0].value;
        description = inputs[1].value;
        priority = readPriority(priority);

        date = inputs[2].value;

        if (!title || !description || !date) {
            generateDialog(errorMessage);
            return;
        }

        id = new Date().getTime();

        tempData = {
            id : id,
            code: "1",
            title: title,
            priority: priority,
            date: date,
            description: description
        };

        // Saving element in local storage
        
        data[id] = tempData;
        localStorage.setItem("todoData", JSON.stringify(data));

        // Generate Todo Element
        
        generateElement(tempData);

        // Reset Form
        inputs[0].value = "";
        inputs[1].value = "";
        inputs[2].value = "";
        
    };

    var generateDialog = function (message) {
        alert("Wszystkie pola muszą być wypełnione");
    };

    todo.clear = function () {
        data = {};
        localStorage.setItem("todoData", JSON.stringify(data));
        $("." + defaults.todoTask).remove();
    };

})(todo, data, jQuery);