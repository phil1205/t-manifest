(function(angular){
	'use strict';

	angular
		.module('JGApp.indexCtrl')
		.controller('IndexCtrl', ['$scope', '$location', '$http', indexCtrl]);

	function indexCtrl($scope, $location, $http){
		$scope.lblLogin = "Anmelden";
		
		$scope.route = function(path, selected){
			$location.path(path);
			$scope.selected = selected;
		};
		$scope.updateLabel = function(){
			if($scope.lblLogin == "Anmelden"){
				$scope.lblLogin = "ausblenden";
			}
			else{
				$scope.lblLogin = "Anmelden";
			}
			$location.path("/login");
		};
		
//		$scope.login = function(loginData){
//			login(loginData);
//		};
		
		$scope.credentials = {};
		var self = this;
		var authenticate = function(credentials, callback) {

		    var headers = credentials ? {authorization : "Basic "
		        + btoa(credentials.username + ":" + credentials.password)
		    } : {};

		    $http.get('/users', {headers : headers}).then(function(response) {
		      callback && callback();
		    }, function() {
		      $rootScope.authenticated = false;
		      callback && callback();
		    });

		  }

		  authenticate();
		  
		  $scope.login = function() {
		      authenticate($scope.credentials, function() {
		        if ($rootScope.authenticated) {
		          $location.path("/");
		          self.error = false;
		        } else {
		          $location.path("/login");
		          self.error = true;
		        }
		      });
		  };
		  
		  self.logout = function() {
			  $http.post('/logout', {}).finally(function() {
			    $rootScope.authenticated = false;
			    $location.path("/");
			  });
			}
		  
		  
		  
		var year = moment().year();
		$scope.footer = '© Junge Gesellschaft Barwedel ' + year;
	}
})(angular);