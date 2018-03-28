'use strict';
angular.module(angularApplicationName).controller('OldExecutivesCtrl', ['$scope', oldExecutivesCtrl]);

function oldExecutivesCtrl($scope){
	$scope.oldExecutives = [
	    {year: '1967', person: 'Edeltraud Koch'},
		{year: '1968', person: 'Heinrich Dürheide'},
        {year: '1969', person: 'Horst Jaeckel'},
        {year: '1970 - 1976', person: 'Joachim Dürheide'},
        {year: '1977 - 1978', person: 'Norbert Kull'},
        {year: '1979', person: 'Hartmut Spellig'},
        {year: '1980', person: 'Gisela Nietner'},
        {year: '1981', person: 'Hermann Klopp'},
        {year: '1982', person: 'Andreas Grotepaust'},
        {year: '1983', person: 'Carola Bischof'},
        {year: '1984', person: 'Michael Mietz'},
        {year: '1985', person: 'Andreas Grotepaust'},
        {year: '1986', person: 'Olaf Mertens'},
        {year: '1987', person: 'Andreas Grotepaust & Bernd Sonntag'},
        {year: '1988', person: 'Hans-Joachim Schulz'},
        {year: '1989', person: 'Uwe-Karsten Hannig'},
        {year: '1990', person: '?'},
        {year: '1991', person: 'Andreas Krusche'},
        {year: '1992', person: '?'},
        {year: '1993', person: 'Dirk Köbis'},
        {year: '1994', person: 'Heiko Ehmann'},
        {year: '1995 - 1997', person: 'Thorsten Leusmann'},
        {year: '1998', person: 'Stefanie Schulz'},
        {year: '1999', person: 'Sebastian Kühne'},
        {year: '2000', person: 'Dennis Leusmann & Anika Beyer & Melanie Leusmann'},
        {year: '2001 - 2002', person: 'Heiko Ehmann'},
        {year: '2003 - 2004', person: 'Tanja Steinbrink'},
        {year: '2005 - 2006', person: 'Paul Budau'},
        {year: '2007 - 2008', person: 'Christian Wrede'},
        {year: '2009 - 2010', person: 'Mareike Kull'},
        {year: '2011 - 2014', person: 'Doreen Suckow'},
        {year: '2015', person: 'Max Fricke'},
        {year: '2016 - 2017', person: 'Doreen Suckow'},
        {year: '2018 -', person: 'Phil Bender'}
    ];
}
