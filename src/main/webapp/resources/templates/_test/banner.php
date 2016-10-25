<?php
// Funktionen
function getDiffDays($event){
	$termin = strtotime($event);
	$diff_seconds = $termin - $GLOBALS['zeit'];

	return intval(($diff_seconds-1) / 86400) + 1;
}
function getDiffSeconds($event){
	$termin = strtotime($event);
	$diff_seconds = $termin - $GLOBALS['zeit'];

	return $diff_seconds;
}
function getEventLength($days){
	$seconds = $days * 86400 - 1;
	$seconds = $seconds * -1;

	return $seconds;
}

// Zeitzone
date_default_timezone_set("Europe/Berlin");
$zeit = time();
//$zeit = mktime(23, 23, 59, 05, 17, 2016);

// Events
$fasching = "06.02.2016";
$kinder_fasching = "07.02.2016";
$kalkar = "29.04.2016";
$pfingstzelten = "13.05.2016";
$bobby_car = "04.06.2016";
$open_air = "10.09.2016";
$jhv = "10.12.2016";

// Banner Beschriftung
if(getDiffSeconds($fasching) >= getEventLength(1)){
	if(getDiffSeconds($fasching) >= getEventLength(1) && getDiffSeconds($fasching) <= 0){
		$banner = "Heute: Faschingsumzug";
	}
	elseif(getDiffSeconds($fasching) <= 86400 && getDiffSeconds($fasching) >= 1){
		$banner = "Morgen: Faschingsumzug";
	}
	else{
		$banner = "In ".getDiffDays($fasching)." Tagen: Faschingsumzug";
	}
}

elseif(getDiffSeconds($kinder_fasching) >= getEventLength(1)){
	if(getDiffSeconds($kinder_fasching) >= getEventLength(1) && getDiffSeconds($kinder_fasching) <= 0){
		$banner = "Heute: Kinderfasching";
	}
	elseif(getDiffSeconds($kinder_fasching) <= 86400 && getDiffSeconds($kinder_fasching) >= 1){
		$banner = "Morgen: Kinderfasching";
	}
	else{
		$banner = "In ".getDiffDays($kinder_fasching)." Tagen Kinderfasching";
	}
}

elseif(getDiffSeconds($kalkar) >= getEventLength(3)){
	if(getDiffSeconds($kalkar) >= getEventLength(1) && getDiffSeconds($kalkar) <= 0){
		$banner = "Heute: Beginn unserer Fahrt nach Kalkar";
	}
	elseif(getDiffSeconds($kalkar) >= getEventLength(2) && getDiffSeconds($kalkar) <= -86400){
		$banner = "Zurzeit sind wir in Kalkar";
	}
	elseif(getDiffSeconds($kalkar) >= getEventLength(3) && getDiffSeconds($kalkar) <= -172800){
		$banner = "Letzter Tag in Kalkar";
	}
	elseif(getDiffSeconds($kalkar) <= 86400 && getDiffSeconds($kalkar) >= 1){
		$banner = "Morgen: Unsere Fahrt nach Kalkar";
	}
	else{
		$banner = "In ".getDiffDays($kalkar)." Tagen: Unser Wochenende in Kalkar";
	}
}

elseif(getDiffSeconds($pfingstzelten) >= getEventLength(4)){
	if(getDiffSeconds($pfingstzelten) >= getEventLength(1) && getDiffSeconds($pfingstzelten) <= 0){
		$banner = "Heute: Beginn des Pfingstzelten";
	}
	elseif(getDiffSeconds($pfingstzelten) >= getEventLength(2) && getDiffSeconds($pfingstzelten) <= -86400){
		$banner = "Zurzeit: Pfingstzelten";
	}
	elseif(getDiffSeconds($pfingstzelten) >= getEventLength(3) && getDiffSeconds($pfingstzelten) <= -172800){
		$banner = "Zurzeit: Pfingstzelten";
	}
	elseif(getDiffSeconds($pfingstzelten) >= getEventLength(4) && getDiffSeconds($pfingstzelten) <= -259200){
		$banner = "Zurzeit: Pfingstzelten";
	}
	elseif(getDiffSeconds($pfingstzelten) <= 86400 && getDiffSeconds($pfingstzelten) >= 1){
		$banner = "Morgen: Beginn des Pfingstzelten";
	}
	else{
		$banner = "In ".getDiffDays($pfingstzelten)." Tagen: Pfingstzelten";
	}
}

elseif(getDiffSeconds($bobby_car) >= getEventLength(1)){
	if(getDiffSeconds($bobby_car) >= getEventLength(1) && getDiffSeconds($bobby_car) <= 0){
		$banner = "Heute: Bobby Car Rennen";
	}
	elseif(getDiffSeconds($bobby_car) <= 86400 && getDiffSeconds($bobby_car) >= 1){
		$banner = "Morgen: Bobby Car Rennen";
	}
	else{
		$banner = "In ".getDiffDays($bobby_car)." Tagen: Bobby Car Rennen";
	}
}

elseif(getDiffSeconds($open_air) >= getEventLength(1)){
	if(getDiffSeconds($open_air) >= getEventLength(1) && getDiffSeconds($open_air) <= 0){
		$banner = "Heute: Open Air Fete!";
	}
	elseif(getDiffSeconds($open_air) <= 86400 && getDiffSeconds($open_air) >= 1){
		$banner = "Morgen: Open Air Fete!";
	}
	else{
		$banner = "In ".getDiffDays($open_air)." Tagen: Open Air Fete!";
	}
}

elseif(getDiffSeconds($jhv) >= getEventLength(1)){
	if(getDiffSeconds($jhv) >= getEventLength(1) && getDiffSeconds($jhv) <= 0){
		$banner = "Heute: Unsere Jahreshauptversammlung";
	}
	elseif(getDiffSeconds($jhv) <= 86400 && getDiffSeconds($jhv) >= 1){
		$banner = "Morgen: Unsere Jahreshauptversammlung";
	}
	else{
		$banner = "In ".getDiffDays($jhv)." Tagen: Unsere Jahreshauptversammlung";
	}
}
?>

<div class="bouncing">
	<p>
		<?php
		echo $banner;
		?>
	</p>
</div>