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
    //select
    $query = "SELECT * FROM `guestbook` WHERE accepted = true";
    
    $result = mysql_query($query) OR die(mysql_error()); 
    
    $arr = array();
    
    //now we turn the results into an array and loop through them. 
    while ($row = mysql_fetch_array($result)) { 
        $entryID = $row['entryID']; 
        $name = $row['name']; 
        $mail = $row['mail']; 
        $entry = $row['entry']; 
        $date = $row['date']; 
        $accepted = $row['accepted']; 
        
        array_push($arr, array('entryID' => $entryID, 'name' => $name, 'mail' => $mail, 'entry' => $entry, 'date' => $date, 'accepted' => $accepted));
    }
    echo json_encode($arr);
?>