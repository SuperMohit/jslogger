'use strict';

var activityLog ={ 
   "id"	 : 0,	
   "widget" : "button",
   "jevent"  :  "",
   "browser" : "",
   "os"   : "" ,
   "comment" : ""
}; 

var TRACE_SIZE = 40;
var activityTrace = {
		activityLogs : []
};

function logActivity(isError,activityLog){
	activityTrace.activityLogs.push(activityLog);
	
	if(activityTrace.activityLogs.length > TRACE_SIZE || isError){   
       
         alert(JSON.stringify(activityTrace));
		 var controllerScope = angular.element($("#opCon")).scope();
         controllerScope.logErrors(activityTrace);
         return;
	}
	  	
}


opinioApp.config(function ($provide) {

            $provide.decorator('$exceptionHandler', function ($delegate) {

                return function (exception, cause) {
                    $delegate(exception, cause);
                    activityLog.id = null;
                    activityLog.widget = "opinion";
                    activityLog.jevent = "click";
                    activityLog.comment = "click the button";
                    activityLog.os = "ubuntu";
                    activityLog.browser = "firefox";
                    
                    logActivity(true,activityLog);
                };
            });
        });












