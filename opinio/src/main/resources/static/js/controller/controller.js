'use strict';

opinioApp.controller('OpinioController', ['$scope', 'OpinioService', function($scope, OpinioService) {
        
          var self = $scope ;
          self.throwErrors = function(errorId){        	
           if(errorId==0) throw new EvalError('0', 'someFile.js', 10); 
           else if(errorId==1) throw new InternalError('1', 'someFile.js', 10); 
           else if(errorId==2) throw new RangeError('2', 'someFile.js', 10); 
           else if(errorId==3) throw new ReferenceError('3', 'someFile.js', 10); 
           else if(errorId==4) throw new SyntaxError('4', 'someFile.js', 10); 
           else if(errorId==5) throw new TypeError('5', 'someFile.js', 10); 
           else if(errorId==6) throw new URIError('6', 'someFile.js', 10); 
           
         };


          self.logActivity = function (data) {
         
        	 OpinioService.logger(data)
                  .then(
      					       function(d) {   alert("success");
      						            					       },
            					function(errResponse){
            						console.error('Error while logging activity.');
            					}
      			       );
        
          };
          
          self.logError = function (data) {
              
         	 OpinioService.logError(data)
                   .then(
       					       function(d) {   alert("success");
       						            					       },
             					function(errResponse){
             						console.error('Error while logging js exception.');
             					}
       			       );
         
           };

        }]);