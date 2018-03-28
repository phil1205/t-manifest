'use strict';
angular.module(angularApplicationName).controller('UsCtrl', ['$scope', '$rootScope', usCtrl]);

function usCtrl($scope, $rootScope){
	$rootScope.wasLoaded = false;
	
	$scope.showImageContent = function(){
		$rootScope.wasLoaded = true;
	}
}