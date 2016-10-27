(function(angular){
	'use strict';

	angular
		.module('JGApp.indexCtrl')
		.controller('IndexCtrl', ['$scope', '$location', '$http', '$rootScope', 'authSharedService', indexCtrl]);

	function indexCtrl($scope, $location, $http, $rootScope, authSharedService){
		$scope.credentials = {};
		
		$scope.openDiv = false;
		$scope.lblLogin = "Anmelden";
		$scope.btncolor = "btn-info";
		
		$scope.route = function(path, selected){
			$location.path(path);
			$scope.selected = selected;
		};
		
		$scope.updateLabel = function(){
			updateLabel();
		};
		
		function updateLabel(){
			if($scope.lblLogin == "Anmelden"){
				$scope.btncolor = "btn-default";
				$scope.lblLogin = "ausblenden";
			}
			else{
				$scope.btncolor = "btn-info";
				$scope.lblLogin = "Anmelden";
			}
		}
		
		var year = moment().year();
		$scope.footer = '© Junge Gesellschaft Barwedel ' + year;
		
		$scope.login = function() {
			$rootScope.authenticationError = false;
			authSharedService.login($scope.credentials.username, $scope.credentials.password);
			
			console.log($rootScope.authenticated);
			
			if($rootScope.authenticated == true){
				var alert=$("#nav-collapse2");
		        alert.hide();
		        
		        updateLabel();
			}
		}
		
		$scope.logout = function() {
			$http.post('/logout', {})["finally"](function() {
				$rootScope.authenticated = false;
			    $location.path("/");
			});
		}
	}
})(angular);