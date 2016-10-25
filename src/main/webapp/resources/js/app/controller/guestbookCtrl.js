(function(angular){
	'use strict';

	angular
		.module('JGApp.guestbookCtrl')
		.controller('GuestbookCtrl', ['$scope', '$http', guestbookCtrl]);

	function guestbookCtrl($scope, $http){
		$scope.entries = [];
		
		var newName;
		var newEMail;
		var newEntry;
		var newDate;
		
		$scope.getEntry = function(){
			getEntry();
		}
		$scope.setEntry = function(name, mail, entry, date){
			newName = name;
			newEMail = mail;
			newEntry = entry;
			newDate = date;
			
			setEntry();
		}
		
		// get existing entries
		function getEntry(){
			$scope.entries = [];
			
			var URL = String('http://localhost:8080/guestbooks/');
			$http({
				url: URL,
				method: 'GET',
				contentType: 'application/json'
			})
			.then(useData);
		}
		function useData(){
			console.log(data);
			if (angular.isDefined(data.data)){
				$scope.entries = data.data;
			}
		}
		
		// pass new entry
		function setEntry(){
			var URL = String('http://localhost:8080/guestbooks/');
			$http({
				url: URL,
				method: 'POST',
				contentType: 'application/json',
				data: {strName: newName, strEMail: newEMail, strEntry: newEntry, strDate: newDate, byteAccepted: 0}
			})
			.then(displayAlertSucces, displayAlertError)
		}
		
		// call alerts
		function displayAlertSucces(){
			var alert=$("#alertSucces");
	        alert.show();
		};
		function displayAlertError(){
			var alert=$("#alertError");
	        alert.show();
		};
	}
})(angular);