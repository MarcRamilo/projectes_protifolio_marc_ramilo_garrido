<?php
if (!isset($_SESSION)) session_start();
if (!isset($_SESSION['user_logged'])) {
    header("Location: ./login_admin.php");
    die();
}

// Comprobar si s'ha enviat el formulari i si s'ha proporcionat un ID d'esdeveniment
if (isset($_GET['event_id'])) {
    $event_id = $_GET['event_id'];

    // Comprova si el ID de l'esdeveniment existeix
    if (isset($_SESSION['events'][$event_id])) {
        $event = $_SESSION['events'][$event_id];
    } else {
        // Rediriex a la llista d'esdeveniments si no existeix l'ID de l'esdeveniment
        header("Location: ./list_events.php");
        die();
    }
} else {
    // Rediriex a la llista d'esdeveniments si no s'ha proporcionat un ID d'esdeveniment
    header("Location: ./list_events.php");
    die();
}

// Comprova si s'ha enviat el formulari d'actualització de l'esdeveniment
if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['update_event'])) {
    // Processa el formulari d'actualització de l'esdeveniment
    $event['titol'] = $_POST['titol'];
    $event['tipo'] = $_POST['tipo'];
    $event['preu'] = $_POST['preu'];
    $event['aforo'] = $_POST['aforo'];
    $event['imatge'] = $_POST['imatge'];

    // Processa la data i l'hora
    $date = $_POST['data'];
    $time = $_POST['hora'];
    
    // Creem un objecte DateTime amb la data
    $event['data'] = new DateTime($date);
    
    // Setejem l'hora
    $event['data']->setTime(
        (int) substr($time, 0, 2), // Hours
        (int) substr($time, 3, 2)  // Minutes
    );

    // Actualitzem l'esdeveniment a la sessió
    $_SESSION['events'][$event_id] = $event;

    // Rediriex a la llista d'esdeveniments
    header("Location: ./list_events.php");
    die();
}
?>

<!doctype html>
<html lang="en">

<head>
    <title>Edit Event</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>

<body>
    <?php include_once('./templates/navbar.php') ?>
    <h2>Editar Esdeveniment</h2>
    <form method="POST" action="edit_event.php?event_id=<?php echo $event_id; ?>">
        <div class="mb-3">
            <label for="titol" class="form-label">Títol</label>
            <input type="text" class="form-control" id="titol" name="titol" value="<?php echo $event['titol']; ?>" required>
        </div>
        <div class="mb-3">
            <label for="tipo" class="form-label">Tipo</label>
            <input type="text" class="form-control" id="tipo" name="tipo" value="<?php echo $event['tipo']; ?>" required>
        </div>
        <div class="mb-3">
            <label for="preu" class="form-label">Preu</label>
            <input type="number" class="form-control" id="preu" name="preu" value="<?php echo $event['preu']; ?>" required>
        </div>
        <div class="mb-3">
            <label for="aforo" class="form-label">Aforo</label>
            <input type="number" class="form-control" id="aforo" name="aforo" value="<?php echo $event['aforo']; ?>" required>
        </div>
        <div class="mb-3">
            <label for="data" class="form-label">Data</label>
            <input type="date" class="form-control" id="data" name="data" value="<?php echo $event['data']->format('Y-m-d'); ?>" required>
        </div>
        <div class="mb-3">
            <label for="hora" class="form-label">Hora</label>
            <input type="time" class="form-control" id="hora" name="hora" value="<?php echo $event['data']->format('H:i'); ?>" required>
        </div>
        <div class="mb-3">
            <label for="imatge" class="form-label">Imatge</label>
            <input type="text" class="form-control" id="imatge" name="imatge" value="<?php echo $event['imatge']; ?>" required>
        </div>
        <button type="submit" name="update_event" class="btn btn-primary">Actualitzar esdeveniment</button>
    </form>
    <br>
    <p class="text-end me-2"><a class="text-end" href="./list_events.php">Tornar a la llista</a></p>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
</body>

</html>