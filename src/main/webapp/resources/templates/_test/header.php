	<!-- Header -->

	<meta charset="UTF-8"> <!-- fügt Europäische Umlaute hinzu -->
	<meta name="author" content="Michel Kühne"/>
	<meta name ="keywords" content="Junge Gesellschaft Barwedel, JGB, JG B, Barwedel, JG Barwedel, Junge Gesellschaft, JG Barwedel <?php echo $header; ?>, Junge Gesellschaft Barwedel <?php echo $header; ?>"/>
	<meta http-equiv="language" content="DE">


	<!-- Verlinkung mit der CSS Datei -->
	<link rel="stylesheet" type="text/css" href="../css/JGB.css">
	<style type ="text/css"></style>
	<link rel="shortcut icon" type="image/x-icon" href="bilder/Standard/favicon.ico" />

	<?php
	if($header == "Junge Gesellschaft Barwedel"){
		if(preg_match("/(alcatel|amoi|android|avantgo|blackberry|benq|cell|cricket|docomo|elaine
		|htc|iemobile|iphone|ipad|ipaq|ipod|j2me|java|midp|mini|mmp|mobi|motorola|nec-|nokia|palm|
		panasonic|philips|phone|playbook|sagem|sharp|sie-|silk|smartphone|sony|symbian|t-mobile|telus
		|up\.browser|up\.link|vodafone|wap|webos|wireless|xda|xoom|zte)/i", $_SERVER['HTTP_USER_AGENT'])) {
			include 'content/mobil.html';
			exit();
		};
	}
	?>

	<title> <?php $title ?> </title>