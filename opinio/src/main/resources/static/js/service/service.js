'use strict';

opinioApp.factory('OpinioService', ['$http', '$q', function($http, $q){

	return {
              logger: function(data) {
            	
					return $http.post( '/logActivity', data)
							.then(
									function(response){								
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while logging data');
										return $q.reject(errResponse);
									}
							);
			
			} ,
			
			logError: function(data) {
            	
				return $http.post( '/logError', data)
						.then(
								function(response){								
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while logging data');
									return $q.reject(errResponse);
								}
						);
		
		}
	} 
}]);