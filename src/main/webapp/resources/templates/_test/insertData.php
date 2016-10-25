<?php
//declare variables
$name = $_POST['Name'];
$mail = $_POST['EMail'];
$eintrag = $_POST['inhalt'];

//get max ID
$strGetMaxID = "SELECT MAX(eintrag_ID) FROM gaestebuch";
$query_strGetMaxID = mysql_query($strGetMaxID);

$fetchData = mysql_fetch_row($query_strGetMaxID);
$eintragID = $fetchData[0] + 1;

//fill in data
$strInsertData = "INSERT INTO gaestebuch (akzeptiert, eintrag_ID, name, mail, eintrag, datum) VALUES ('0', '".$eintragID."', '".$name."', '".$mail."', '".$eintrag."', '".date('Y-m-d', $zeit)."');";
$query_strInsertData = mysql_query($strInsertData);

$name = "";
$mail = "";
$eintrag = "";
?>