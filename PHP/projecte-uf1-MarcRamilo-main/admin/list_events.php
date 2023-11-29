<?php
if (!isset($_SESSION)) session_start();
if (!isset($_SESSION['user_logged'])) {
    header("Location: ./login_admin.php");
    die();
}

// Compromba si s'ha enviat el formulari de creació d'esdeveniment
if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['create_event'])) {
    // Procesa el formulari de creació d'esdeveniment
    $newEvent = [
        'titol' => $_POST['titol'],
        'tipo' => $_POST['tipo'],
        'preu' => $_POST['preu'],
        'data' => $_POST['data'],
        'imatge' => $_POST['imatge'],
    ];

    // Comprova si l'hora s'ha proporcionat
    if (!empty($_POST['hora'])) {
        $newEvent['hora'] = $_POST['hora'];
    }

    // Afageix l'esdeveniment a la sessió
    $_SESSION['events'][] = $newEvent;
}

// Comprova si s'ha enviat el formulari d'actualització d'esdeveniment
if (isset($_GET['delete_event'])) {
    $eventToDelete = $_GET['delete_event'];
    // Borra l'esdeveniment de la sessió
    unset($_SESSION['events'][$eventToDelete]);
}

?>

<!doctype html>
<html lang="en">

<head>
    <title>Llista de esdeveniments</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<body>
    <?php include_once('./templates/navbar.php') ?>
    <h2>Llistar Esdeveniments</h2>
    <h3>Esdeveniments del sistema</h3>
    <table class="table">
        <thead>
            <tr>
                <th>Numero Event</th>
                <th>Títol</th>
                <th>Tipo</th>
                <th>Preu</th>
                <th>Aforo</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Imatge</th>
                <th>Options</th>
            </tr>
        </thead>
        <tbody>
            <?php
            $eventContador = 0;
            if (isset($_SESSION['events'])) {
                foreach ($_SESSION['events'] as $eventContador => $event) {
                    echo "<tr>";
                    echo "<td>$eventContador</td>";
            
                    // Verifica si el camp titol existeix
                    if (isset($event['titol'])) {
                        echo "<td>{$event['titol']}</td>";
                    } else {
                        echo "<td>N/A</td>"; // O muestra un valor per defecte
                    }
            
                    if (isset($event['tipo'])) {
                        echo "<td>{$event['tipo']}</td>";
                    } else {
                        echo "<td>N/A</td>";
                    }
            
                    if (isset($event['preu'])) {
                        echo "<td>{$event['preu']}</td>";
                    } else {
                        echo "<td>N/A</td>";
                    }
                    if (isset($event['aforo'])) {
                        echo "<td>{$event['aforo']}</td>";
                    } else {
                        echo "<td>N/A</td>";
                    }
            
                    if (isset($event['data']) && $event['data'] instanceof DateTime) {
                        echo "<td>{$event['data']->format('j/n/Y')}</td>";
                    } else {
                        echo "<td>N/A</td>";
                    }
            
                    if (isset($event['hora'])) {
                        echo "<td>{$event['hora']}</td>";
                    } else {
                        echo "<td>N/A</td>";
                    }
            
                    if (isset($event['imatge'])) {
                        echo "<td>{$event['imatge']}</td>";
                    } else {
                        echo "<td>N/A</td>";
                    }
            
                    echo "<td><a href='edit_event.php?event_id=$eventContador'>Editar</a> | <a href='?delete_event=$eventContador'>Eliminar</a></td>";
                    echo "</tr>";
                    $eventContador++;
                }
            } else {
                echo "<tr><td colspan='7'>No hi ha esdeveniments</td></tr>";
            }
            
            ?>
        </tbody>
    </table>
    <br>
    <button><a href="create_event.php">Crear nou esdeveniment</a></button>
    <br><br>
    <p class="text-end me-2"><a class="text-end" href="./welcome_admin.php">Tornar a la Home</a></p>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
</body>

</html>
