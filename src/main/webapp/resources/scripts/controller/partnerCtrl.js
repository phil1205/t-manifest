'use strict';
angular.module(angularApplicationName).controller('PartnerCtrl', ['$scope', '$rootScope', partnerCtrl]);

function partnerCtrl($scope, $rootScope){
	$scope.data = [{
		picture: 'brome.gif',
		href: 'http://www.jgbrome.de/',
		title: 'Junge Gesellschaft Brome',
		show: false
	}, {
		picture: 'jglessien.png',
		href: 'http://www.jglessien.de/index.php/de/',
		title: 'Junge Gesellschaft Lessien',
		show: false
	}, {
		picture: 'jg_grussendorf.jpg',
		href: 'http://www.jg-grussendorf.de/',
		title: 'Junge Gesellschaft Grußendorf',
		show: false
	}, {
		picture: 'jg_bergfeld.jpg',
		href: 'http://www.jgbergfeld.de/',
		title: 'Junge Gesellschaft Bergfeld',
		show: false
	}, {
		picture: 'jg_tuelau.gif',
		href: 'https://www.jg-tuelau-fahrenhorst.de',
		title: 'Junge Gesellschaft Tülau-Fahrenhorst',
		show: false
	}, {
		picture: 'jg_hoitlingen.gif',
		href: 'http://www.jghoitlingen.de/',
		title: 'Junge Gesellschaft Hoitlingen',
		show: false
	}, {
		picture: 'lk_gifhorn.png',
		href: 'http://www.landkreis-gifhorn.de/',
		title: 'Landkreis Gifhorn',
		show: false
	}, {
		picture: 'boldecker.png',
		href: 'http://www.boldecker-land.de/index.php?%3FID=ha9pvn4p9aipdajve7mk8j2r25',
		title: 'Samtgemeinde Boldecker Land',
		show: false
	}, {
		picture: 'ffbarwedel.png',
		href: 'https://www.freiwillige-feuerwehr-barwedel.de',
		title: 'Reitvereinigung Barwedel',
		show: false
	}, {
		picture: 'landmaschinenfreunde.png',
		href: 'http://www.landmaschinenfreunde.de',
		title: 'Historischen Landmaschinenfreunde Barwedel',
		show: false
	}, {
		picture: 'svb.gif',
		href: 'http://www.sv-barwedel.de/',
		title: 'SV Barwedel',
		show: false
	}, {
		picture: 'hufe.png',
		href: 'http://www.hufe-online.de',
		title: 'HuFEvents',
		show: false
	}, {
		picture: 'wiesn.png',
		href: 'http://www.jembkerwiesn.de',
		title: 'Jembker Wiesn',
		show: false
	}, {
		picture: 'wildvikings.jpg',
		href: 'http://www.wildvikings-mc.com/Wolfsburg.htm',
		title: 'Wild Vikings Wolfsburg',
		show: false
	}, {
		picture: 'big-sound.jpg',
		href: 'http://www.big-sound.de/',
		title: 'Big-Sound',
		show: false
	}];
	
	$scope.setShowTrue = function(index){
		$scope.data[index].show = true;
	}
}