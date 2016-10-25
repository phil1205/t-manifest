<?php
//fill in data
$strGetData = "SELECT eintrag_ID, name, eintrag, datum FROM gaestebuch WHERE akzeptiert = 1;";
$query_strGetData = mysql_query($strGetData);

while($fetchData = mysql_fetch_assoc($query_strGetData)){
	$getTime = strtotime($fetchData['datum']);
	echo "<p id = \"eintragName\">Von ".$fetchData['name']."</p>";
	echo "<p id = \"eintragDatum\">am ".date('d.m.Y', $getTime)."</p>";
	echo "<p id = \"eintragInhalt\">".nl2br($fetchData['eintrag'])."</p>";
}

mysql_close()
?>