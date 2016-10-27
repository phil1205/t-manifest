(function(angular) {
	angular
		.module('JGApp.authSharedService', [])
		.service('authSharedService', ['$rootScope', '$http', '$resource', 'authService', 'session', authSharedService]);
	
	function authSharedService($rootScope, $http, $resource, authService, session){
		return {
			login: function(userName, password) {
				var config = {
					params: {
						username: userName,
						password: password,
					},
					ignoreAuthModule: 'ignoreAuthModule'
				};
				
				$http.post('/authenticate', '', config)
					.then(function(data, status, headers, config) {
						authService.loginConfirmed(data);
					}, function(data, status, headers, config) {
						$rootScope.authenticated = false;
						$rootScope.authenticationError = true;
						session.invalidate();
					});
			},
			
			getAccount: function () {
				$rootScope.loadingAccount = true;
				
				$http.get('security/account')
					.then(function (response) {
						console.log("getAcc: " + response);
						authService.loginConfirmed(response.data);
					});
			},
			
			isAuthorized: function (authorizedRoles) {
				if (!angular.isArray(authorizedRoles)) {
					if (authorizedRoles == '*') {
						return true;
					}
					authorizedRoles = [authorizedRoles];
				}
				
				var isAuthorized = false;
				angular.forEach(authorizedRoles, function (authorizedRole) {
					var authorized = (!!session.login && session.userRoles.indexOf(authorizedRole) !== -1);
					
					if (authorized || authorizedRole == '*') {
						isAuthorized = true;
					}
				});
				
				return isAuthorized;
			}
		};
	}
})(angular);