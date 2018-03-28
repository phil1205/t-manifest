'use strict';

var angularApplicationName = 'JGApp';

(function() {
	
	angular.module(
			angularApplicationName,
			['ngResource', 'ngRoute']).config(function($routeProvider){
				
		$routeProvider
	    .when('/', {
	    	templateUrl: 'resources/views/pages/home.html',
	    	controller: 'HomeCtrl'})
	    .when('/aktuell', {
	    	templateUrl: 'resources/views/pages/news.html',
	    	controller: 'NewsCtrl'})
	    
	    .when('/ueberUns/wir', {
	    	templateUrl: 'resources/views/pages/aboutUs/us.html',
	    	controller: 'UsCtrl'})
	    .when('/ueberUns/gruendung', {
	    	templateUrl: 'resources/views/pages/aboutUs/founding.html'})
	    .when('/ueberUns/geschichte', {
	    	templateUrl: 'resources/views/pages/aboutUs/history.html'})
	    .when('/ueberUns/eintreten', {
	    	templateUrl: 'resources/views/pages/aboutUs/enter.html'})
	    .when('/ueberUns/impressum', {
	    	templateUrl: 'resources/views/pages/aboutUs/imprint.html'})
	    
	    .when('/events', {
	    	templateUrl: 'resources/views/pages/events.html'})
	      
	    .when('/mitglieder/vorstand', {
	    	templateUrl: 'resources/views/pages/member/executive.html'})
	    .when('/mitglieder/mitgliederUndBeitritt', {
	    	templateUrl: 'resources/views/pages/member/memberAndEnter.html'})
	    .when('/gaestebuch', {
	    	templateUrl: 'resources/views/pages/guestbook.html'})
	    .when('/galerie', {
	    	templateUrl: 'resources/views/pages/gallery.html'})
	    
	    .when('/partner', {
	    	templateUrl: 'resources/views/pages/partner.html',
	    	controller: 'PartnerCtrl'})
	    
	    // errors
		.when('/error/404', {
			templateUrl : 'resources/views/pages/error/404.html'})
	    	
	    .otherwise({redirectTo:'/error/404'});
	});
	
	angular.module(angularApplicationName).run(function($rootScope, $location, $interval) {
		var history = [];
		var currentYear = new Date().getFullYear();
		
		$rootScope.APP_INFO = {
			name : 'JG Barwedel',
			copyright : String('© Junge Gesellschaft Barwedel'),
			year : currentYear
		};
			
		$rootScope.isRoute = function(path) {
			return location.href.endsWith(path);
		};
		$rootScope.goTo = function(path) {
			$location.path(path);
		};
		
		// changing variables by visiting new templates
		$rootScope.$on('$routeChangeSuccess', function(event, current, previous){
			history.push($location.$$path);
		});
		
		// go back to previous page
		$rootScope.back = function () {
	        var prevUrl = history.length > 1 ? history.splice(-2)[0] : "/";
	        $location.path(prevUrl);
	    };
	    
	    // for showing the db-content
		$rootScope.wasLoaded = true;
	});
	
	angular.module(angularApplicationName).filter('parseDate', function(){
		return function(date){
			var parseDate = moment(date, "YYYY-MM-DD");
			return parseDate.format("DD.MM.YYYY")
		}
	}).filter('isDefined', function(){
		return angular.isDefined;
	});
})();
