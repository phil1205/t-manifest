 <?php
    $host = "rdbms.strato.de"; 
    $user = "U2819662"; 
    $pass = "db_JGBarwedel1967"; 
    $database = "DB2819662";
    
    $con = mysql_connect($host,$user,$pass);
    if (!$con) {
        die('Could not connect: ' . mysql_error());
    }
    
    mysql_select_db($database,$con);
    //get param
    $data = json_decode(file_get_contents("php://input"));
    
    $pName = mysql_real_escape_string($data->name);
    $pMail = mysql_real_escape_string($data->mail);
    $pEntry = mysql_real_escape_string($data->entry);
    $pDate = mysql_real_escape_string($data->date);
    $pAccepted = mysql_real_escape_string($data->accepted);
    
    //insert
    $query = "INSERT INTO guestbook (name,mail,entry,date,accepted) VALUES ('".$pName."','".$pMail."','".$pEntry."',CURDATE(),0)";
    
    $result = mysql_query($query) OR die(mysql_error());
?>