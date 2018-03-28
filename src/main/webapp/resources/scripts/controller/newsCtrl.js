'use strict';
angular.module(angularApplicationName).controller('NewsCtrl', ['$scope', '$sce', newsCtrl]);

function newsCtrl($scope, $sce){
	// $sce.trustAsHtml
	
	$scope.isDone = function(date){
		var today = moment();
		return today >= moment(date);
	};
	
    $scope.data = [{
        title: '10.02. - Faschingsumzug',
        endDate: "2018-02-11",
        content: $sce.trustAsHtml('Nach einjähriger Pause werden wir zusammen mit den barwedler "Alten Säcken" unseren Faschingsumzug durchführen. Dazu werden wir auf den Straßen mit unseren Wägen und Outfits nach dem Motto: <i>Superhelden und Videospielfiguren</i> rumziehen und versuchen, Spenden für unseren Verein zu sammeln. Natürlich stoßen wir mit unseren Mitbürgern und Mitgliedern dabei gerne an und geben einen aus <i class="em em-wink"></i>')
    },{
		title: '11.02. 14:00 - Kinderfasching',
		endDate: "2018-02-12",
		content: $sce.trustAsHtml('Wie jedes Jahr veranstalten wir für die Kinder in unserem Dorf das traditionelle Kinderfasching. Diesmal wieder im barwedler Heidekrug.')
    }, {
        title: '28.04. & 29.04. - Maibaum holen und aufstellen',
        endDate: moment("2018-05-30", "YYYY-MM-DD"),
        content: $sce.trustAsHtml('Am 28. April ziehen wir in die Wälder und schlagen für unser Dorf den Maibaum. Dazu werden die Mitglieder in einem Anhänger zum Gebiet gefahren. Dort beginnen dann unsere weiblichen Mitglieder nach alter Tradition den Maibaum zu fall zu bringen.</br> Am Folgetag ist der Maibaum dann an seinem gewöhnlichen Platz geschmückt vorzufinden.')
    },{
		title: '18.05. bis 21.05. - Pfingstzelten',
		endDate: moment("2018-05-22", "YYYY-MM-DD"),
		content: $sce.trustAsHtml('Auch dieses Jahr feieren wir wieder am Hangar über das verlängerte Wochenende unser Pfingstzelten.</br>' +
		 	'<b>Das Highlight:</b> Am Samstag kommen die Pfingstochsen frei und stellen das Dorf auf den Kopf.</br>' +
		 	'Gegen eine kleine Spende werden die Bewohner verschont <i class="em em-wink"></i>')
	}, {
		title: '08.09. 20:00 - Open Air Fete',
		endDate: moment("2018-09-09", "YYYY-MM-DD"),
		content: $sce.trustAsHtml('<p>' +
		 	'<h4 class="text-danger">Das Highlight im September!</h4>' +
		 	'Unsere erfolgreiche Open Air Fete findet auch 2018 statt! Zum <b>44. Mal</b> laden wir mit Musik für Jung und Alt ein, damit sich jeder gut aufgehoben fühlt. Ein Muss für alle feierfreudigen.</br>' +/*
		 	'Auch weil dieses Jahr folgende Künstler dabei sind:</br></br>' +
		 	'<span class="glyphicon glyphicon glyphicon-certificate" aria-hidden="true"></span> <a href="https://www.facebook.com/Skurril2013/" target="_blank">Skurril</a></br>' +
		 	'<span class="glyphicon glyphicon glyphicon-certificate" aria-hidden="true"></span> <a href="https://www.facebook.com/DeadRockPilots/?hc_ref=ARQ1xfbAqdeR6loR9utYmvqNsOWDr9jcajfM1dv41wQkIigd_T9Sxe_KkIJrMxarBBM" target="_blank">Deadrock Pilots</a> (rocken zum 2. Mal bei uns nach 2014) </br>' +
		 	'<span class="glyphicon glyphicon-headphones" aria-hidden="true"></span> <a href="https://www.facebook.com/djloopx/" target="_blank">DJ Loop-X</a> (feiert mit Euch genauso wie im Vorjahr)</br>' +
		 	'</br>' +*/
		 	'<b class="text-warning">Also, scheut euch nicht vorbei zu kommen</b> <i class="em em-sunglasses"></i>' +
		 	'</p>')
	}, {
		title: '15.12. 18:00 - Jahreshauptversammlung',
		endDate: moment("2018-12-16", "YYYY-MM-DD"),
		content: $sce.trustAsHtml('Wie jedes Jahr werden unsere Mitglieder über das vergangene Jahr infomiert und die Planungen für das anfallende Jahr werden erläutert')
	}];
}
