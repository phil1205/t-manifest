'use strict';
angular.module(angularApplicationName).controller('GuestbookCtrl', ['$scope', '$http', guestbookCtrl]);

function guestbookCtrl($scope, $http){
	$scope.entries = [];
	$scope.gotEntries = false;
	
	// get existing entries
	$scope.getEntries = function(){
		$scope.entries = [];
		
		$http({
			url: 'resources/database/dbGetData.php',
			method: 'GET',
			contentType: 'application/json'
		})
		.then(function(response){
			$scope.entries = response.data;
			
			if($scope.entries.length != 0){
				$scope.gotEntries = true;
				
			} else{
				$scope.gotEntries = false;
				
				displayAlertGetNoEntries();
			}
		}, function(err){
			displayAlertGetError();
		});
	}
	
	// pass new entry
	$scope.setEntry = function(entry){
		var data = JSON.stringify({"name": entry.name, "mail": entry.mail, "entry": entry.text});
		$http({
			url: 'resources/database/dbPostData.php',
			method: 'POST',
			contentType: 'application/json',
			data: data
		})
		.then(function(data){
			$scope.entry = null;
			
			displayAlertSubmitSuccess();
		}, function(err){
			displayAlertSubmitError();
		});
	}
	
	// call alerts
	function closeAllAlerts(){
		var alert=$("#alertGetError");
		alert.hide();
		var alert=$("#alertGetNoEntries");
		alert.hide();
		var alert=$("#alertSubmitError");
		alert.hide();
		var alert=$("#alertSubmitSuccess");
		alert.hide();
	}
	function displayAlertGetError(){
		closeAllAlerts();
		var alert=$("#alertGetError");
        alert.show();
	};
	function displayAlertGetNoEntries(){
		closeAllAlerts();
		var alert=$("#alertGetNoEntries");
        alert.show();
	};
	
	function displayAlertSubmitError(){
		closeAllAlerts();
		var alert=$("#alertSubmitError");
        alert.show();
	};
	function displayAlertSubmitSuccess(){
		closeAllAlerts();
		var alert=$("#alertSubmitSuccess");
		alert.show();
	};
}