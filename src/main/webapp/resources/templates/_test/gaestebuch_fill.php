<div id="gast">
    Wollen Sie einen Beitrag hinzufügen?<br>
    Dann einfach Ausfüllen und abschicken.<€br><br>

    <form method="post">
    
        Ihr Name:<br>
        <input name="Name" size="40" id="input"></br>

        E-Mail:<br>
        <input name="EMail" size="40" id="input"></br>

        Inhalt:</br>
        <textarea name="inhalt" cols="40" rows="10" wrap="physical" id="textarea"></textarea><br>
        <input name="submit" type="submit" value="Absenden">

    </form>

</div>

<?php

include 'alert.php';

date_default_timezone_set("Europe/Berlin");
$zeit = time();

if(isset($_POST['submit']) && !empty($_POST['submit']) == true){
    if (empty($_POST['Name']) or empty($_POST['EMail']) or empty($_POST['inhalt']) == true){
        echo '<script type="text/javascript">alert_ungueltig();</script>';
    }
    elseif(count($_POST['inhalt']) > 3000){
        echo '<script type="text/javascript">alert_laenge();</script>';
    }
    elseif(filter_var($_POST['EMail'], FILTER_VALIDATE_EMAIL) == false){
        echo '<script type="text/javascript">alert_mail();</script>';
    }
    else{
        include 'insertData.php';
    }
}

?>

<p id = "eintraege"> Einträge </p>