'use strict';
angular.module(angularApplicationName).controller('GalleryCtrl', ['$scope', galleryCtrl]);

function galleryCtrl($scope){
	var yearSet = false;
	var gallerySet = false;
	
	var year;
	var title;
	var requestPath;
	var overviewPath;
	var overviewThumbnailPath;
	
	$scope.lblYear = "Jahr";
	$scope.lblEvent = "Event";
	
	$scope.eventsFromYear = [];
	$scope.files = [];
	
	var events = [{
		value: 0, title: 'Open Air', path: '/openAir/'
	},{
		value: 1, title: 'Beer Aventure Race', path: '/beerAdventureRace/'
	},{
		value: 2, title: 'Fasching', path: '/carnival/'
	},{
		value: 3, title: 'Maibaum', path: '/may/'
	},{
		value: 4, title: 'Pfingsten', path: '/pentecost/'
	}];
	
	$scope.galleries = [{
		value: 0, year: '2009', events: [events[0]]
	},{
		value: 1, year: '2016', events: [events[0], events[2], events[4]]
	}];
	
	$scope.resetDD = function(){
		resetDD();
	}
	
	$scope.setYear = function(value, year){
		setYear(value, year);
	}
	$scope.setEvent = function(value, title, path){
		setEvent(value, title, path);
	}
	$scope.isYearTrue = function(value){
		return yearSet;
	}
	$scope.isGalleryTrue = function(value){
		return gallerySet;
	}
	
	function resetDD(){
		var yearSet = false;
		var gallerySet = false;
		
		$scope.lblYear = "Jahr";
		$scope.lblEvent = "Event";
		
		$scope.eventsFromYear = [];
		$scope.files = [];
		
		year = null;
		title = null;
		requestPath = null;
		overviewPath = null;
		overviewThumbnailPath = null;
	}
	
	function setYear(value, y){
		year = y;
		
		$scope.lblYear = y;
		
		$scope.lblEvent = "Event";
		$scope.files = [];
		gallerySet = false;
		
		$scope.eventsFromYear = $scope.galleries[value].events
		yearSet = true;
	}
	function setEvent(value, t, p){
		title = t;
		requestPath = '../../../img/gallery/' + year + p;
		overviewPath = '../img/gallery/' + year + p;
		overviewThumbnailPath = '../img/gallery/' + year + p + 'thumbnail/';
		
		$scope.lblEvent = t;
		
		getFilesInFolder();
	}
	
	function getFilesInFolder(){
		$scope.files = [{
			path: '../img/gallery/2009/openAir/Bild1.jpg',
			thumbnail: '../img/gallery/2009/openAir/Bild1.jpg'
		},{
			path: '../img/gallery/2009/openAir/Bild2.jpg',
			thumbnail: '../img/gallery/2009/openAir/Bild2.jpg'
		}];
		
		gallerySet = true;
	}
}