<?php
if (!isset($_SESSION)) session_start();
if (!isset($_SESSION['user_logged'])) {
    header("Location: ./login_admin.php");
    die();
}
?>

<!doctype html>
<html lang="en">

<head>
    <title>Llistat d'Usuaris</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<body>
    <?php include_once('./templates/navbar.php') ?>
    <h2>Llista d'Usuaris</h2>
    <h3>Usaris del sistema:</h3>
    <table class="table">
        <thead>
            <tr>
                <th>Numero Usuari</th>
                <th>Username</th>
                <th>Nom</th>
                <th>Cognom</th>
                <th>Data Naixement</th>
                <th>Contrassenya</th>
                <th>isAdmin</th>
                <th>Accions</th>
            </tr>
        </thead>
        <tbody>
            <?php
            $usuarisContador = 0;
            // Comprova si hi ha usuaris a la sessió i els mostra en una taula HTML
            if (isset($_SESSION['users'])) {
                foreach ($_SESSION['users'] as $user_id => $user) {
                    $isAdmin = $user['admin'] ? "Es admin" : "Es client"; 
                    echo "<tr>";
                    echo "<td>$usuarisContador</td>";
                    echo "<td>{$user['username']}</td>";
                    echo "<td>{$user['nom']}</td>";
                    echo "<td>{$user['cognom']}</td>";
                    echo "<td>{$user['birthdate']->format("j/n/Y")}</td>";
                    echo "<td>{$user['pass']}</td>";
                    echo "<td>$isAdmin</td>"; 
                    echo "<td><a href='edit_user.php?user_id=$user_id'>Editar</a> | <a href='delete_user.php?user_id=$user_id'>Eliminar</a></td>";
                    echo "</tr>";
                    $usuarisContador++;
                }
            }  else {
                echo "<tr><td colspan='7'>No hi ha usuaris</td></tr>";
            }
            ?>
        </tbody>
    </table>
    <br>
    <button><a href="./add_user.php">Afegir nou usuari</a></button>
    <br><br>
    <p class="text-end me-2"><a class="text-end" href="./welcome_admin.php">Tornar a la Home</a></p>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
</body>

</html>
