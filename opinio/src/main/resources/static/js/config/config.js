'use strict';

var activityLog ={ 
   "id"	 : null,	
   "widget" : "button",
   "jevent"  :  "",
   "browser" : "",
   "os"   : "" ,
   "comment" : ""
}; 

var jsError = {
	"id" : null,
	"errortype" : "",
	"priority"  : 0,
	"errordetails" : ""
}

var activityTrace = {
		activityLogs : []
};


setTimeout(function(){ sendToServer();},10000);

function logActivity(activityLog){
		 activityTrace.activityLogs.push(activityLog);
		 sendToServer();
	}
	  	

function sendToServer(){
	if( activityTrace.activityLogs.length ==0 ) return;
	var controllerScope = angular.element($("#opCon")).scope();
    controllerScope.logActivity(activityTrace);
    activityTrace.activityLogs = [];
}



opinioApp.config(function ($provide) {

            $provide.decorator('$exceptionHandler', function ($delegate) {

                return function (exception, cause) {
                    $delegate(exception, cause);
                    
                    activityLog.id = null;
                    activityLog.widget = "opinion";
                    activityLog.jevent = "click";
                    activityLog.comment = "click the button";
                    activityLog.os = navigator.platform;
                    activityLog.browser = navigator.appCodeName + navigator.appName;
                    
                    logActivity(true,activityLog);
                    logException(exception);
                };
            });
        });

function logException(exception){	
	jsError.id= null;
	jsError.errortype = exception.split(":")[0];
	jsError.priority = exception.split(":")[1];
	jsError.errordetails = "exception thrown";
	var controllerScope = angular.element($("#opCon")).scope();
    controllerScope.logError(jsError);
    
}










