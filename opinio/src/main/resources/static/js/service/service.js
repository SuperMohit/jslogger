'use strict';

opinioApp.factory('OpinioService', ['$http', '$q', function($http, $q){

	return {
              logger: function(data) {
            	
					return $http.post( '/log', data)
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