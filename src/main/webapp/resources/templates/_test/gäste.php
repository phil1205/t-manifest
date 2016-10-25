<html>
    <head>
    </head>
    <body>
    Wollen Sie einen Beitrag hinzufügen?<br><br>

<form action="neuerbeitrag.php" Method="post">

Ihr Name:<br>
<input name="Name" size="40"><br><br>

E-Mail:<br>
<input name="EMail" size="40"><br>
<br><br>

Inhalt:<br>

<textarea name="inhalt" cols="40" rows="12"
wrap="physical"></textarea><br>
<input type="submit" value="Absenden">
</form>
<hr>

<?php
$beitrag = file("gaestebuch.txt");
?>
</body>
</html>