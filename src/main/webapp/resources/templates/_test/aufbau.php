<!-- Aufbau -->

<div id="header">

    <img id="logo" src="../bilder/Logo/logo.png">

    <?php
    if($header == "Junge Gesellschaft Barwedel"){
        echo '<p class = "header-jgb">'.$header.'</p>';
    }
    else{
        echo '<p class = "header-name">'.$header.'</p>';
    }
    ?>

    <img id="sau" src="../bilder/Standard/jg-sau-blau1.png">

</div>

<?php
if($header == "Junge Gesellschaft Barwedel"){
    include 'banner.php';
}
?>

<div id="sprechblase"></div>

<div id="<?php echo $wrapper; ?>">

    <div id = "background">

        <div id="drope">

        <!-- DropDown Menü start -->
        <b> <nav>
            <ul>
                <li class = "cat1">
                    <a href="../index.php">Home</a>
                </li>
                <li class = "cat2">
                    <a href="../content/aktuell.php">Aktuelles</a>
                </li>
                <li class = "cat3">
                    <a href="#">Über uns</a>
                    <ul>
                        <li><a href="../content/gruendung.php">Gründung</a></li>
                        <li><a href="../content/geschichte.php">Geschichte</a></li>
                    </ul>
                </li>
                <li class = "cat4">
                     <a href="#">Events</a>
                     <ul>
                         <li><a href="../content/openair.php">Open Air Fete</a></li>
                         <li><a href="../content/bobbycar.php">Bobby Car Rennen</a></li>
                         <li><a href="../content/fasching.php">Fasching</a></li>
                         <li><a href="../content/beer.php">Beer Adventure Race</a></li>
                         <li><a href="../content/maibaum.php">Maibaum</a></li>
                         <li><a href="../content/pfingsten.php">Pfingsten</a></li>
                     </ul>
                </li>
                <li class = "cat5">
                    <a href="#">Mitglieder</a>
                    <ul>
                        <li><a href="../content/vorstand.php">Vorstand</a></li>
                        <li><a href="../content/mitwerden.php">Mitglied werden?</a>
                    </ul>
                </li>
                <li class = "cat6">
                    <a href="../content/gaestebuch.php">Gästebuch</a>
                </li>
                <li class = "cat7">
                    <a href="../content/gallerie.php">Gallerie</a>
                </li>
            </ul>
            </nav>
        </b>
        </div>
        <!-- DropDown Menü Ende -->