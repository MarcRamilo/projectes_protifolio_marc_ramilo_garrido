<?php
if (!isset($_SESSION)) session_start();
if (!isset($_SESSION['user_logged'])) {
  header("Location: ./login.php");
  die();
}



// Procesa el tema d'eliminar un ticket si s'ha enviat un formulari
if (isset($_POST['eliminar_ticket']) && isset($_POST['ticket_id'])) {
  $ticket_id_to_delete = $_POST['ticket_id'];
  eliminarTicket($ticket_id_to_delete);
}
//Retornar la quantiat de tickets comprats al esdeveniment quan s'elimina un ticket que ha comprat l'usuari
function getTicketQuantity($event_id)
{
  $ticket_quantity = 0;
  foreach ($_SESSION['user_tickets'] as $ticket_id => $ticket) {
    if ($ticket['event_id'] == $event_id) {
      $ticket_quantity += $ticket['quantity'];
    }
  }
  return $ticket_quantity;
}
// Funció per eliminar un ticket de la sessió
function eliminarTicket($ticket_id)
{
  if (isset($_SESSION['user_tickets'][$ticket_id])) {
    $ticket = $_SESSION['user_tickets'][$ticket_id];
    $event_id = $ticket['event_id'];
    $ticket_quantity = $ticket['quantity'];

    // Retorna la quantitat de tickets comprats al esdeveniment
    if (isset($_SESSION['events'][$event_id])) {
      $_SESSION['events'][$event_id]['aforo'] += $ticket_quantity;
    }

    // Eliminar el ticket de la sesión
    unset($_SESSION['user_tickets'][$ticket_id]);
  }
}
$ticket_count = 0;
?>

<!doctype html>
<html lang="en">

<head>
  <title>Perfil Client</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

</head>

<body>
  <?php include_once('templates/navbar.php') ?>

  <div class="mx-auto">

    <h1>Benvingut/da <?php echo $_SESSION['user_logged']['nom'] . ' ' . $_SESSION['user_logged']['cognom'] ?></h1>
    <h2>Les teves dades són les següents:</h2>
    <h4>Nom: <?php echo $_SESSION['user_logged']['nom']  ?></h4>
    <h4>Cognom: <?php echo $_SESSION['user_logged']['cognom'] ?></h4>
    <h4>Data neixement: <?php echo $_SESSION['user_logged']['birthdate']->format("j/n/Y")  ?></h4>
    <h4>Contrassenya: <?php echo $_SESSION['user_logged']['pass']  ?></h4>
    <h4>Admin?: <?php echo $_SESSION['user_logged']['admin'] ? "Sí" : "No"; ?></h4>
  </div>
  <button><a href="./modify_profile.php">Canviar dades</a></button>

  <!-- Mostrar los tickets comprados por el usuario -->
  <div class="container mt-5">
    <h2>Tickets Comprats</h2>
    <?php
    // Mostra missatge si no hi ha tickets
    if (!empty($_SESSION['user_tickets'])) {
      echo '<table class="table">';
      echo '<thead>';
      echo '<tr>';
      echo '<th>Esdeveniment</th>';
      echo '<th>Data Esdeveniment</th>';
      echo '<th>Cantitat</th>';
      echo '<th>Accions</th>';
      echo '</tr>';
      echo '</thead>';
      echo '<tbody>';
      // Mostra els tickets comprats per l'usuari
      foreach ($_SESSION['user_tickets'] as $ticket_id => $ticket) {
        // Només procedir si el ticket pertany a l'usuari connectat
        if (isset($ticket['username']) && isset($_SESSION['user_logged']['username']) && $ticket['username'] == $_SESSION['user_logged']['username']) {
          $event_id = $ticket['event_id'];
          $quantity = $ticket['quantity'];
          // Comprova si l'esdeveniment existeix
          if (isset($_SESSION['events'][$event_id])) {
            $event = $_SESSION['events'][$event_id];
            $eventTitle = $event['titol'];
            echo '<tr>';
            echo "<td>" . htmlspecialchars($eventTitle) . "</td>";
            echo "<td>" . htmlspecialchars($event['data']->format("j/n/Y")) . "</td>";
            echo "<td>" . htmlspecialchars($quantity) . "</td>";
            echo '<td>';
            // Afageix un formulari per eliminar el ticket
            echo '<form method="post" action="profile.php">';
            echo '<input type="hidden" name="ticket_id" value="' . htmlspecialchars($ticket_id) . '">';
            echo '<button type="submit" name="eliminar_ticket" class="btn btn-danger">Eliminar</button>';
            echo '</form>';
            echo '</td>';
            echo '</tr>';
            $ticket_count++;
          }
        }
      }
      echo '</tbody>';
      echo '</table>';
    } else {
      echo "No has comprat cap ticket.";
    }
    ?>
  </div>

  <!-- Bootstrap JavaScript Libraries -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
  </script>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
  </script>
</body>

</html>