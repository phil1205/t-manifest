<?php

echo '<div id="slider1" class="csslider infinity">';

  for($counter = 1; $counter <= $numberofpictures; $counter++){
    if($counter == 1){
      echo '<input type="radio" name="slides" checked="checked" id="slides_1"/>';
    }
    else{
      echo '<input type="radio" name="slides" id="slides_'.$counter.'"/>';
    }
  }
  
  echo '<ul>';

  for($counter = 1; $counter <= $numberofpictures; $counter++){
    echo '<li>';
      echo '<img src="../bilder/slider/'.$folder.'/bild_'.$counter.'.jpg"/>';
    echo '</li>';
  }

  echo '</ul>';

  echo '<div class="arrows">';

    for($counter = 1; $counter <= $numberofpictures; $counter++){
      echo '<label for="slides_'.$counter.'"></label>';
    }

    $lastSlide = $counter - 1;

    echo '<label for="slides_0" class="goto-first"></label>';
    echo '<label for="slides_'.$lastSlide.'" class="goto-first"></label>';

  echo '</div>';

  echo '<div class="navigation">';
    echo'<div>';

      for($counter = 1; $counter <= $numberofpictures; $counter++){
          echo '<label for="slides_'.$counter.'"></label>';
      }

    echo '</div>';
  echo '</div>';

?>