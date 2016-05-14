'use strict';

opinioApp.controller('OpinioController', ['$scope', 'OpinioService', function($scope, OpinioService) {
        
	      
          var self = $scope ;
          var say = "sayer sooth";
          self.throwErrors = function(errorId){
        	
           if(errorId==0) throw new EvalError('Hello', 'someFile.js', 10); 
         };


          self.logErrors = function (data) {
         
        	 OpinioService.logger(data)
                  .then(
      					       function(d) {   alert("success");
      						            					       },
            					function(errResponse){
            						console.error('Error while fetching members');
            					}
      			       );
        
          };

        }]);