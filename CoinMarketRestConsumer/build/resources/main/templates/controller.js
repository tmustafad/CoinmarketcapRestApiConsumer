var app = angular.module('app', []);


app.controller('getcontroller', function($scope, $http, $location) {
	$scope.getfunction = function(){
		var url = $location.absUrl() + "/";
		
		$http.get(url).then(function (response) {
			$scope.response = response
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});