<?php
if (!isset($_SESSION)) session_start();
if (!isset($_SESSION['user_logged'])) {
  header("Location: ./login.php");
  die();
}
// Inicialitza la variable de sessió per a guardar els esdeveniments si no està inicialitzada
if (!isset($_SESSION['events'])) {
  $_SESSION['events'] = array();
}
// No necessitem comprovar si el formulari s'ha enviat perquè el botó de comprar ticket no té valor
$events = &$_SESSION['events']; // Referència a la variable de sessió

// Initializa la variable de sessió per a guardar els tickets de l'usuari si no està inicialitzada
if (!isset($_SESSION['user_tickets'])) {
  $_SESSION['user_tickets'] = array();
}



if (isset($_POST['afegir_carro']) && isset($_POST['event_id'])) {
  $event_id = filter_input(INPUT_POST, 'event_id', FILTER_VALIDATE_INT);
  $quantity = filter_input(INPUT_POST, 'quantity', FILTER_VALIDATE_INT);

  if (array_key_exists($event_id, $events)) {
    // Check if there's enough quota
    if ($events[$event_id]['aforo'] >= $quantity) {
      $events[$event_id]['aforo'] -= $quantity;

      // Assuming you want to have a unique ticket ID for each entry
      $ticket_id = uniqid('ticket_');

      // Add the ticket to the session with the username and purchase datetime
      $_SESSION['user_tickets'][$ticket_id] = array(
        'username' => $_SESSION['user_logged']['username'], // Get the username from the session
        'event_id' => $event_id,
        'quantity' => $quantity,
        'purchase_datetime' => date('Y-m-d H:i:s') // Store the purchase datetime
      );

      echo '<div class="alert alert-success" role="alert">';
      echo "Entrada afegida al carretó amb èxit!";
      echo "</div>";
    } else {
      // Not enough quota, handle this case properly
      echo '<div class="alert alert-danger" role="alert">';
      echo "No hi ha suficients entrades disponibles.";
      echo "</div>";
    }
  } else {
    // Event does not exist, handle this case properly
    echo '<div class="alert alert-danger" role="alert">';
    echo "L'esdeveniment no existeix.";
    echo "</div>";
  }
}

//-----------------Filtratge per data-----------------//
$esdeveniments_filtrats = []; // Array per a guardar els esdeveniments filtrats
if (isset($_POST['submit_date_filter'])) { //
  $desde_date = $_POST['desde_date']; // Recull la data desde
  $fins_date = $_POST['fins_date']; // Recull la data fins a

  // Converteix les dates a objectes DateTime
  $desde_date = DateTime::createFromFormat('Y-m-d', $desde_date);
  $fins_date = DateTime::createFromFormat('Y-m-d', $fins_date);

  foreach ($events as $event_id => $esdevniment) {
    $eventDate = $esdevniment['data']; // Obte la data de l'esdeveniment

    // Comprova si la data de l'esdeveniment està entre les dates seleccionades
    if ($eventDate >= $desde_date && $eventDate <= $fins_date) {
      $esdeveniments_filtrats[$event_id] = $esdevniment; // Afageix l'esdeveniment a l'array de filtrats

     
    }
  }
}
?>

<!doctype html>
<html lang="en">

<head>
  <title>Ticketings</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>

<body>
  <?php include_once('templates/slidebar.php') ?>


  <!-- Formulario de filtro por data -->
  <div class="container mt-3">
    <h3>Filtrar per data</h3>
    <form action="" method="post">
      <div class="mb-3">
        <label for="desde_date" class="form-label">Desde</label>
        <div class="mb-3">
          <input type="date" value="<?php echo $_POST['desde_date'] ?? ''; ?>" class="form-control" name="desde_date" id="desde_date" aria-describedby="helpId">
        </div>
      </div>
      <div class="mb-3">
        <label for="fins_date" class="form-label">Fins a</label>
        <div class="mb-3">
          <input type="date" value="<?php echo $_POST['fins_date'] ?? ''; ?>" class="form-control" name="fins_date" id="fins_date" aria-describedby="helpId">
        </div>
      </div>
      <button type="submit" name="submit_date_filter" class="btn btn-primary">Filtrar</button>
    </form>
  </div>

  <div class="container mt-5">
    <h2>Esdeveniments</h2>
    <?php
    if (isset($esdeveniments_filtrats) && count($esdeveniments_filtrats) > 0) {
      echo "<h3>Esdeveniments filtrats</h3>";
      foreach ($esdeveniments_filtrats as $event_id => $esdeveniment) {
        echo "<div class='container mb-3 text-black mt-5 bg-danger'>";
        echo "<img src='' alt=''>";
        echo "<br><br><br>";
        echo "<img src='{$esdeveniment['imatge']}' alt='' width='200px'>";
        echo "<br><br><br>";
        echo "<h5>{$esdeveniment['titol']}</h5>";
        echo "<i>{$esdeveniment['tipo']}</i>";
        echo "<p>{$esdeveniment['preu']}€</p>";
        echo "<p>Aforo disponible: {$esdeveniment['aforo']}</p>";
        echo "<p>{$esdeveniment['data']->format("j/n/Y")}</p>";
        echo "<i>{$esdeveniment['hora']}</i>";
        echo "<form method='post' action='welcome.php'>";
        echo "<input type='hidden' name='event_id' value='{$event_id}'>"; // Afageix el ID de l'esdeveniment al formulari
        echo "<input type='number' name='quantity' min='1' max='{$esdeveniment['aforo']}' value='1'>"; // Afageix un input per a seleccionar la quantitat de tickets
        echo "<button type='submit' name='afegir_carro' class='btn btn-success' value='$event_id'>Comprar ticket</button>"; // Afageix el ID de l'esdeveniment al botó
        echo "</form>";
        echo "</div>";

        // Muostra un missatge d'alerta si l'aforament és 0
        if ($esdeveniment['aforo'] <= 0) {
          echo '<div class="alert alert-danger" role="alert">';
          echo "Aforament esgotat de '{$esdeveniment['titol']}'";
          echo "</div>";
        }
      }
    } else {
      echo "<h2>Total Esdeveniments</h2>";
      echo "<div  style='color:white; text-align:center; background-color:gray;'>";
      echo "Selecciona una data per a filtrar els esdeveniments";
      echo "</div>";
      if (isset($events) && count($events) > 0) {
        foreach ($events as $event_id => $esdeveniments) { // Cambiado $esdevniments a $esdeveniments
          echo "<div class='container mb-3 text-black mt-5 bg-danger'>";
          echo "<img src='' alt=''>";
          echo "<br><br><br>";
          echo "<img src='{$esdeveniments['imatge']}' alt='' width='200px'>";
          echo "<br><br><br>";
          echo "<h5>{$esdeveniments['titol']}</h5>";
          echo "<i>{$esdeveniments['tipo']}</i>";
          echo "<p>{$esdeveniments['preu']}€</p>";
          echo "<p>Aforo disponible: {$esdeveniments['aforo']}</p>";
          echo "<p>{$esdeveniments['data']->format("j/n/Y")}</p>";
          echo "<i>{$esdeveniments['hora']}</i>";
          echo "<form method='post' action='welcome.php'>";
          echo "<input type='hidden' name='event_id' value='{$event_id}'>"; // Afageix el ID de l'esdeveniment al formulari
          echo "<input type='number' name='quantity' min='1' max='{$esdeveniments['aforo']}' value='1'>"; // Afageix un input per a seleccionar la quantitat de tickets
          echo "<button type='submit' name='afegir_carro' class='btn btn-success' value='$event_id'>Comprar ticket</button>"; // Afageix el ID de l'esdeveniment al botó
          echo "</form>";
          echo "</div>";
        }
      } elseif (isset($esdeveniments_filtrats) && count($esdeveniments_filtrats) == 0) {
        echo "<div class='bg-danger' style='color:white; text-align:center;'>";
        echo "No hi ha esdeveniments disponibles";
        echo "</div>";
      }
    }

    ?>
  </div>

  <!-- Bootstrap JavaScript Libraries -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
</body>

</html>