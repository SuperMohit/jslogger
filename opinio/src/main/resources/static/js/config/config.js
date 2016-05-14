'use strict';

var activityLog ={ 
   "widget" : "button",
   "jevent"  :  "",
   "browser" : "",
   "os"   : "" ,
   "comment" : ""
}; 

var TRACE_SIZE = 40;
var activityTrace = [];

function logActivity(isError,activityLog){
	activityTrace.push(activityLog);
	
	if(activityTrace.length > TRACE_SIZE || isError){   
       
         alert(JSON.stringify(activityTrace));
         var controllerElement = document.querySelector('div');
		 var controllerScope = angular.element(controllerElement).scope();
         controllerScope.logErrors(activityTrace);
         return;
	}
	  	
}


opinioApp.config(function ($provide) {

            $provide.decorator('$exceptionHandler', function ($delegate) {

                return function (exception, cause) {
                    $delegate(exception, cause);
                    activityLog.widget = "opinion";
                    activityLog.jevent = "click";
                    activityLog.comment = "click the button";
                    activityLog.os = "ubuntu";
                    activityLog.browser = "firefox";
                    logActivity(true,activityLog);
                };
            });
        });












