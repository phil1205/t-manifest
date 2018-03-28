'use strict';
angular.module(angularApplicationName).controller('HomeCtrl', ['$scope', '$rootScope', homeCtrl]);

function homeCtrl($scope, $rootScope){
	$rootScope.wasLoaded = false;
	
	$scope.imageIndicator = [false, false];
	$scope.barwedelViewWasLoaded = false;
	
	$scope.showHomeContent = function(index){
		$scope.imageIndicator[index] = true;
		
		if($scope.imageIndicator[0] == true && $scope.imageIndicator[1] == true){
			$rootScope.wasLoaded = true;
		}
	}
	$scope.showBarwedelView = function(){
		$scope.barwedelViewWasLoaded = true;
	}
}