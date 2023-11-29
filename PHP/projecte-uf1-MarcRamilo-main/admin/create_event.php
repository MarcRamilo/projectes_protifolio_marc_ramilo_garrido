<?php
if (!isset($_SESSION)) session_start();
if (!isset($_SESSION['user_logged'])) { 
    header("Location: ./login_admin.php");
    die();
}

// Iniciar el missatge d'error
$error_message = "";

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['create_event'])) {
    //Procesa el formulari de creació d'esdeveniment
    $eventDate = new DateTime($_POST['data']);
    $currentDate = new DateTime(); // Fecha actual sin tiempo

    $aforo = intval($_POST['aforo']); // Asegúrese de que 'aforo' es un entero

    // Comprobar si la fecha del evento es anterior a la fecha actual
    if ($eventDate < $currentDate) {
        // Si es una fecha pasada, establecer un mensaje de error
        $error_message = "No es pot crear un esdeveniment amb data passada a la actual. Data actual: " . $currentDate->format('d/m/Y') . " Data esdeveniment: " . $eventDate->format('d/m/Y');
    } else if ($aforo <= 0) { // Añadir comprobación para 'aforo'
        // Si el 'aforo' no es válido, establecer un mensaje de error
        $error_message = "L'aforo ha de ser més gran que 0.";
    } else {
        // Si la fecha y el 'aforo' son válidos, procesar la creación del evento
        $newEvent = [
            'titol' => $_POST['titol'],
            'tipo' => $_POST['tipo'],
            'preu' => $_POST['preu'],
            'aforo' => $aforo, // Use la variable ya validada
            'data' => new DateTime($_POST['data']), // Asegúrese de almacenar la fecha en formato 'Y-m-d'
            'hora' => $_POST['hora'], 
            'imatge' => $_POST['imatge'],
        ];

        // Afegim l'esdeveniment a la sessió
        $_SESSION['events'][] = $newEvent;

        // Redirigim a la llista d'esdeveniments
        header("Location: ./list_events.php");
        die();
    }
}
?>




<!doctype html>
<html lang="en">

<head>
    <title>Create Event</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>

<body>
    
    <?php include_once('./templates/navbar.php') ?>
    <?php if (!empty($error_message)): ?>
<div class="alert alert-danger" role="alert">
    <?php echo $error_message; ?>
</div>
<?php endif; ?>
    <h2>Crear Esdeveniment</h2>
    <form method="POST" action="create_event.php">
        <div class="mb-3">
            <label for="titol" class="form-label">Títol</label>
            <input type="text" value="<?php echo $_POST['titol'] ?? null; ?>" class="form-control" id="titol" name="titol" required>
            <small id="imatgeHelp" class="form-text text-muted">Exemple: Concert a Ribes de Freser</small>
        </div>
        <div class="mb-3">
            <label for="tipo" class="form-label">Tipo</label>
            <input list="tipus_esdeveniment" value="<?php echo $_POST['tipo'] ?? null; ?>" class="form-control" id="tipo" name="tipo" required>
            <datalist id="tipus_esdeveniment">
                <option value="Concert">
                <option value="Obra de teatre">
                <option value="Cinema">
                <option value="Exposició">
                <option value="Festival">
                <option value="Fira">
            </datalist>
            <small id="imatgeHelp" class="form-text text-muted">Exemple: Concert</small>    
        </div>
        <div class="mb-3">
            <label for="preu" class="form-label">Preu</label>
            <input value="<?php echo $_POST['preu'] ?? null; ?>" type="number"  class="form-control" id="preu" name="preu" required>
            <small id="imatgeHelp" class="form-text text-muted">Exemple: 7</small>
        </div>
        <div class="mb-3">
            <label for="aforo" class="form-label">Aforo</label>
            <input type="number" value="<?php echo $_POST['aforo'] ?? null; ?>" class="form-control" id="aforo" name="aforo" required>
            <small id="imatgeHelp" class="form-text text-muted">Exemple: 100</small>
        </div>
        <div class="mb-3">
            <label for="data" class="form-label">Data</label>
            <input type="date" value="<?php echo $_POST['data'] ?? null; ?>" class="form-control" id="data" name="data" required>
            <small id="imatgeHelp" class="form-text text-muted">Exemple: 24/12/2023</small>
        </div>
        <div class="mb-3">
            <label for="hora" class="form-label">Hora</label>
            <input type="time" value="<?php echo $_POST['hora'] ?? null; ?>" class="form-control" id="hora" name="hora" required>
            <small id="imatgeHelp" class="form-text text-muted">Exemple: 00:00-24:00</small>

        </div>
        <div class="mb-3">
            <label for="imatge" class="form-label">Imatge</label>
            <input type="text" value="<?php echo $_POST['imatge'] ?? null; ?>" class="form-control" id="imatge" name="imatge" required>
            <small id="imatgeHelp" class="form-text text-muted">Exemple:https://images.unsplash.com/photo-1595769816263-9b910be24d5f?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8Y2luZW1hfGVufDB8fDB8fHww&w=1000 </small>
        </div>
        <button type="submit" name="create_event" class="btn btn-primary">Crear Esedeveniment</button>
    </form>
    <br>
    <p class="text-end me-2"><a class="text-end" href="./list_events.php">Toranar a la llista</a></p>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
</body>

</html>