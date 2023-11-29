<?php
if (!isset($_SESSION)) session_start();
if (!isset($_SESSION['user_logged'])) {
    header("Location: ./login_admin.php");
    die();
}
// Comprobar si s'ha enviat el formulari i si s'ha proporcionat un ID d'usuari 
if (isset($_GET['user_id'])) {
    $user_id = $_GET['user_id'];
    if (isset($_SESSION['users'][$user_id])) {
        $user = $_SESSION['users'][$user_id];
    } else {
        header("Location: list_users.php");
        die();
    }
} else {
    header("Location: list_users.php");
    die();
}
// Processar el formulari d'actualització de l'usuari
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $user_id = $_GET['user_id'];
    $user = $_SESSION['users'][$user_id];
    $user['username'] = $_POST['username'];
    $user['nom'] = $_POST['name'];
    $user['cognom'] = $_POST['cognom'];
    $user['birthdate'] = DateTime::createFromFormat("j/n/Y", $_POST['data']);
    $user['pass'] = $_POST['password'];
    $user['admin'] = isset($_POST['admin']) ? 1 : 0; // 1 for checked, 0 for unchecked
    $_SESSION['users'][$user_id] = $user;
    header("Location: list_users.php");
    exit();
}
?>

<!doctype html>
<html lang="en">

<head>
    <title>Editar Usuaris</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS (You can include your Bootstrap library) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>

<body>
    <?php include_once('./templates/navbar.php') ?>
    <div class="mb-3 mt-5">
        <h2>Editar Usuaris</h2>
        <form class="col-5 mx-auto border p-2" method="POST">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username" value="<?php echo $user['username']; ?>">
            </div>
            <div class="form-group">
                <label for="name">Nom:</label>
                <input type="text" class="form-control" id="name" name="name" value="<?php echo $user['nom']; ?>">
            </div>
            <div class="form-group">
                <label for="cognom">Cognom:</label>
                <input type="text" class="form-control" id="cognom" name="cognom" value="<?php echo $user['cognom']; ?>">
            </div>
            <div class="form-group">
                <label for="data">Data Naixement:</label>
                <input type="text" class="form-control" id="data" name="data" value="<?php echo $user['birthdate']->format("j/n/Y"); ?>">
            </div>
            <div class="form-group">
                <label for="password">Contrassenya:</label>
                <input type="text" class="form-control" id="password" name="password" value="<?php echo $user['pass']; ?>">
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="admin" name="admin" <?php echo $user['admin'] ? 'checked' : ''; ?>>
                <label class="form-check-label" for="admin">Admin</label>
            </div>
            <br>
            <!-- Add more fields for editing other user information -->
            <button type="submit" class="btn btn-primary">Guardar canvis</button>
        </form>
    </div>
</body>

</html>