'use strict';

opinioApp.factory('OpinioService', ['$http', '$q', function($http, $q){

	return {
              logger: function(data) {
					return $http.post( '/post', data)
							.then(
									function(response){								
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			

			alert("sending to server" + data);
			}
	} 
}]);