<!DOCTYPE HTML>
<html>
    <head>
    <meta charset="UTF-8"> <!-- fügt Europäische Umlaute hinzu -->
        <!-- Verlinkung mit der CSS Datei -->
        <link rel="stylesheet" type="text/css" href="JGB.css">
        <style type ="text/css">
        </style>
        <title> Versendet </title>
            <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
    <meta name="description" content="Über meinen Musik Geschmack"/>
    <meta name="author" content="Michel Kühne"/>
    <meta name ="keywords" content="Michel, Kühne, Hobbys, Grundschule, Informationen, Impressum, Grundschule, Model"/>
    <metaname="DC.title" content="Meine Musik"/>
    <metaname="DC.subject" content="Musik" />
    <metaname="DC.creator" content="Michel Kühne" />
    <metaname="DC.description" content="Alles über meine Musik" />
    <meta name="DC.publisher" content="Michel Kühne" />
    </head>
    <body>
    <div id="header">
        <div id="sau">
        <img src="jg-sau-blau1.png">
    </div>
        Junge Gesellschaft Barwedel
    </div>
    <div id="sprechblase1">
    </div>
     <div id="wrapper1">
            <div id="drope">
        <!-- DropeDown Menü start -->
        <b> <nav>
            <ul>
                <li class = "cat1">
                    <a href="index.html">Home</a>
                </li>
                <li class = "cat2">
                    <a href="#">Über uns</a>
                    <ul>
                        <li><a href="grund.html">Gründung</a></li>
                        <li><a href="gesch.html">Geschichte</a></li>
                        <li><a href="30.html">40 Jahre </a></li>
                        
                    </ul>
                </li>
                <li class = "cat3">
                     <a href="#">Events</a>
                     <ul>
                         <li><a href="openair.html">Open Air Fete</a></li>
                         <li><a href="beer.html">Beer Race</a></li>
                         <li><a href="fasching.html">Fasching</a></li>
                         <li><a href="mapf.html">Maibaum/Pfingsten</a></li>
                     </ul>
                </li>
                <li class = "cat4">
                    <a href="#">Mitglieder</a>
                    <ul>
                        <li><a href="angeh.html">Vorstand</a></li>
                        <li><a href="mitwerden.html">Mitglied werden?</a>
                        <li><a href="anderejg.html">Partner </a></li>
                        
                    </ul>
                </li>
                <li class = "cat5">
                    <a href="#">Kontakt</a>
                    <ul>
                        <li><a href="Impresum.html">Impressum</a></li>
                        <li><a href="Formular.html">Formular</a></li>
                        <li><a href="gaestebuch.php">Gästebuch</a></li>
                        
                    </ul>
                </li>
            </ul>
        </nav>
        </b>
    </div>
            <div id="fehler">
<?php
  $fehler = "";
  $name = $_POST['name'];
  $mail = $_POST['mail'];
  $text = $_POST['text'];
  if (empty($name)) {
    $fehler .= "<li>Ihren Namen ein</li>" ;
  }
  if (empty($mail)) {
    $fehler .= "<li>Ihre Mail-Adresse ein</li>" ;
  }
  if (empty($text)) {
    $fehler .= "<li>Ihre Nachricht ein</li>" ;
  }
  if (empty($fehler)) {
    if (get_magic_quotes_gpc()) {
      $text = stripslashes($text);
    }
    $return = chr(13).chr(10);
    $empfaenger = "kuehnemichel@live.de" ;
    $betreff = "Mein Kontaktformular" ;
    $von = "From: Kontaktformular <null@MeineHTML.de>" ;
    $datum = "Datum: ".date("j.n.Y").$return;
    $zeit = "Zeit:  ".date("H:i").$return;
    $abs = "Von:   ".$name." <".$mail.">".$return;
    $trennen = "-------------------------------------".$return;
    $nachricht = $datum.$zeit.$abs.$trennen.$text;
    mail($empfaenger,$betreff,$nachricht,$von);
  }
  ?>
  <?php
  if (empty($fehler)) {
    $return = chr(13).chr(10);
    $nachricht = strip_tags($nachricht);
    $nachricht = htmlentities($nachricht);
    $nachricht = str_replace($return,"<br>",$nachricht);
    echo "<p>Ihre Nachricht wurde versendet.</p>" ;
    echo "<p>$nachricht</p>" ;
  } else {
    echo "<p>Bitte trage Sie </p>" ;
    echo "<ul>$fehler</ul>" ;
  }
  ?>
                     <a href="Formular.html">Zurück zum Formular</a>
         </div>
        </div>
        <div id="s3">
                    <div> Follow us ! </div>
                        <div id="faceook">        
                            <a href="https://www.facebook.com/pages/Junge-Gesellschaft-Barwedel/110315952382517?fref=ts&locale=de_DE"><img src="facebook.ico" width="95px" height="90px"></a>
                        </div>
                                <div id="copy">
                        © Junge Gesellschaft Barwedel 2015
                        </div>
                            <div id="Formu"> <a href="Formular.html">Kontakt </a> </br>
                       <a href="Impresum.html"> Impressum </a>
                            <a href="gaestebuch.php">Gästebuch</a></div>
            </div>
            
    </body>
</html>