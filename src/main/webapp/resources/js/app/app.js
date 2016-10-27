(function(angular) {
	angular.module('JGApp.indexCtrl', []);
	angular.module('JGApp.oldExecutivesCtrl', []);
	angular.module('JGApp.galleryCtrl', []);
	angular.module('JGApp.guestbookCtrl', []);
	angular.module('JGApp.session', []);
	angular.module('JGApp.authSharedService', []);
	
	var app = angular.module('JGApp', ['ngRoute',
	                                   'ngResource',
	                                   'JGApp.indexCtrl',
	                                   'JGApp.oldExecutivesCtrl',
	                                   'JGApp.galleryCtrl',
	                                   'JGApp.guestbookCtrl',
	                                   
	                                   'http-auth-interceptor',
	                                   'JGApp.session',
	                                   'JGApp.authSharedService']);
	
	// intern routing
	app.config(function($routeProvider, $httpProvider, USER_ROLES) {
	    $routeProvider
	      .when('/', {title: 'Startseite', header: "Junge Gesellschaft Barwedel", templateUrl: 'resources/templates/home.html'})
	      .when('/aktuell', {title: 'Aktuell', templateUrl: 'resources/templates/news.html'})
	      .when('/jgb/gruendung', {title: 'Gründung', templateUrl: 'resources/templates/jgb/founding.html'})
	      .when('/jgb/geschichte', {title: 'Geschichte', templateUrl: 'resources/templates/jgb/history.html'})
	      .when('/veranstaltungen/openAir', {title: 'Open Air Fete', templateUrl: 'resources/templates/events/openAir.html'})
	      .when('/veranstaltungen/bobbyCar', {title: 'Bobby Car Rennen', templateUrl: 'resources/templates/events/bobbyCar.html'})
	      .when('/veranstaltungen/fasching', {title: 'Fasching', templateUrl: 'resources/templates/events/carnival.html'})
	      .when('/veranstaltungen/beerAdventureRace', {title: 'Beer Adventure Race', templateUrl: 'resources/templates/events/beerAdventure.html'})
	      .when('/veranstaltungen/maibaum', {title: 'Maibaum', templateUrl: 'resources/templates/events/may.html'})
	      .when('/veranstaltungen/pfingsten', {title: 'Pfingsten', templateUrl: 'resources/templates/events/pentecost.html'})
	      
	      .when('/events', {title: 'Events', templateUrl: 'resources/templates/events.html'})
	      
	      .when('/mitglieder/vorstand', {title: 'Vorstand', templateUrl: 'resources/templates/member/executive.html'})
	      .when('/mitglieder/eintritt', {title: 'Mitglied werden', templateUrl: 'resources/templates/member/enter.html'})
	      .when('/gaestebuch', {title: 'Gästebuch', templateUrl: 'resources/templates/guestbook.html'})
	      .when('/gallerie', {title: 'Gallerie', templateUrl: 'resources/templates/gallery.html'})
	      .when('/partner', {title: 'Gallerie', templateUrl: 'resources/templates/partner.html'})
	      
	      .when('/vorstand/uebersicht', {title: 'Vorstandsaufgaben', templateUrl: 'resources/templates/user/overview.html'})
	      
	      .when('/login', {title: 'LOGIN', header: "LOGIN", templateUrl: 'resources/templates/login.html'})
	      
	      .otherwise({redirectTo:'/'});
	    
	    //$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
	});
	
	app.run(function($rootScope, $window, $location, $http, authSharedService, session, USER_ROLES, $q, $timeout){
		// changing variables by visiting new templates
		$rootScope.$on('$routeChangeSuccess', function(event, current, previous){
			$rootScope.title = current.$$route.title;
			$rootScope.header = current.$$route.header;
		});
		
		$rootScope.$on('event:auth-forbidden', function(rejection) {
			  $rootScope.$evalAsync(function() {
				  $location.path('/error/403').replace();
			  });
		});
		
		$rootScope.$on('$routeChangeStart', function(event, next) {
			if (next.originalPath === "/login" && $rootScope.authenticated) {
				event.preventDefault();
			}
			else if (next.access && next.access.loginRequired && !$rootScope.authenticated) {
				event.preventDefault();
				$rootScope.$broadcast("event:auth-loginRequired", {});
			}
			else if(next.access && !authSharedService.isAuthorized(next.access.authorizedRoles)) {
				event.preventDefault();
				$rootScope.$broadcast("event:auth-forbidden", {});
			}
		});
		
		$rootScope.$on('event:auth-loginConfirmed', function(event, data) {
			$rootScope.loadingAccount = false;
			var nextLocation = ($rootScope.requestedUrl ? $rootScope.requestedUrl : "/vorstand/uebersicht");
			var delay = ($location.path() === "/loading" ? 1500 : 0);
			
			$timeout(function() {
				session.create(data);
				$rootScope.account = session;
				$rootScope.authenticated = true;
				$location.path(nextLocation).replace();
			}, delay);
		});
		
		$rootScope.$on('event:auth-loginRequired', function(event, data) {
			if ($rootScope.loadingAccount && data.status !== 401) {
				$rootScope.requestedUrl = $location.path()
				$location.path('/loading');
			}
			else {
				session.invalidate();
				$rootScope.authenticated = false;
				$rootScope.loadingAccount = false;
				$location.path('/login');
			}
		});
	});
	
	app.constant('USER_ROLES', {
	    all: '*',
	    admin: 'admin',
	    user: 'user'
	});
})(angular);