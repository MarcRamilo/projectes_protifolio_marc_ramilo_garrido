<?php
if (!isset($_SESSION)) session_start();

// Inicialitzar un array per mantenir el recompte de les entrades venudes per esdeveniment.
$entrades_venudes = [];

// Inicialitza el recompte per a cada esdeveniment en 0.
if (isset($_SESSION['events'])) {
    foreach ($_SESSION['events'] as $event_id => $event) {
        if (!isset($entrades_venudes[$event_id])) {
            $entrades_venudes[$event_id] = 0;
        }
    }
}

// Comprova que 'user_tickets' existeix i és un array abans de continuar.
if (isset($_SESSION['user_tickets']) && is_array($_SESSION['user_tickets'])) {
    // Calcula el total d'entrades venudes per a cada esdeveniment.
    foreach ($_SESSION['user_tickets'] as $ticket) {
        $event_id = $ticket['event_id'];
        $quantity = $ticket['quantity'];
        if (isset($entrades_venudes[$event_id])) {
            $entrades_venudes[$event_id] += $quantity;
        }
    }
}
?>

<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <title>Estadístiques d'entrades comprades</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

</head>
<body>
<?php include_once('./templates/navbar.php') ?>

<div class="container mt-5">
  <h1>Estadístiques de Vendes d'Entrades</h1>
  <table class="table">
    <thead>
      <tr>
        <th>Esdeveniment</th>
        <th>Entrades Venudes</th>
        <th>Diners Guanyats</th> 
      </tr>
    </thead>
    <tbody>
  <?php foreach ($entrades_venudes as $event_id => $ventas): ?>
    <tr>
      <td><?php echo ($_SESSION['events'][$event_id]['titol'] ?? 'Títol no disponible'); ?></td>
      <td>
        <?php
        echo $ventas;
        if (isset($_SESSION['events'][$event_id]['aforo'])) {
          echo ' / ' . ($_SESSION['events'][$event_id]['aforo']);
        } else {
          echo ' / No disponible'; 
        }
        ?>
      </td>
      <td>
        <?php
        // Comprova si el camp 'preu' existeix abans de mostrar-lo.
        if (isset($_SESSION['events'][$event_id]['preu'])) {
          // Calcula el total de diners guanyats per l'esdeveniment.
          $dinero_ganado = $ventas * $_SESSION['events'][$event_id]['preu'];
          echo number_format($dinero_ganado, 2) . ' €'; //Format de moneda
        } else {
          echo 'Preu no disponible';
        }
        ?>
      </td>
    </tr>
  <?php endforeach; ?>
</tbody>
  </table>
</div>

</body>

</html>