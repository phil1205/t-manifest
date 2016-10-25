<?php
//connect.php
$db_name = "DB2468717";
$db_server = "rdbms.strato.de";
$db_user = "U2468717";
$db_password = "db_JGBarwedel1967";

mysql_connect($db_server, $db_user, $db_password) or $DB_Error = 1;
mysql_select_db($db_name) or $DB_Error = 1;
?>