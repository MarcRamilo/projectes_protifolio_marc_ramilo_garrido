<?php
if (!isset($_SESSION)) session_start();
if (!isset($_SESSION['user_logged'])) {
    header("Location: ./login.php");
    die();
}


// Comprova si s'ha enviat el formulari d'actualització de l'esdeveniment 
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Processa el formulari d'actualització de l'esdeveniment
    $user['username'] = $_POST['username'];
    $user['nom'] = $_POST['name'];
    $user['cognom'] = $_POST['cognom'];
    $user['birthdate'] = DateTime::createFromFormat("j/n/Y", $_POST['data']);
    $user['pass'] = $_POST['password'];
    $user['admin'] = $_POST['admin'];
    $_SESSION['user_logged'] = $user;
    header("Location: welcome.php");
    exit();
}

?>

<!doctype html>
<html lang="en">

<head>
    <title>Edit User</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS (You can include your Bootstrap library) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>

<body>
    <?php include_once('./templates/navbar.php') ?>
    <div class="mb-3 mt-5">
        <h2>Modificar perfil</h2>
        <form class="col-5 mx-auto border p-2" method="POST">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username" value="<?php echo $_SESSION['user_logged']['username']; ?>">
            </div>
            <div class="form-group">
                <label for="name">Nom:</label>
                <input type="text" class="form-control" id="name" name="name" value="<?php echo $_SESSION['user_logged']['nom']; ?>">
            </div>
            <div class="form-group">
                <label for="cognom">Cognom:</label>
                <input type="text" class="form-control" id="cognom" name="cognom" value="<?php echo $_SESSION['user_logged']['cognom']; ?>">
            </div>
            <div class="form-group">
                <label for="data">Data Naixement:</label>
                <input type="text" class="form-control" id="data" name="data" value="<?php echo $_SESSION['user_logged']['birthdate']->format("j/n/Y"); ?>">
            </div>
            <div class="form-group">
                <label for="password">Contrassenya:</label>
                <input type="text" class="form-control" id="password" name="password" value="<?php echo $_SESSION['user_logged']['pass']; ?>">
            </div>
            <div class="form-group">
                <label for="admin">admin:</label>
                <input type="text" class="form-control" id="admin" name="admin" value="<?php echo $_SESSION['user_logged']['admin'] == 1 ? 'Sí' : 'No'; ?>" disabled>
                <input type="hidden" id="admin" name="admin" value="<?php echo $_SESSION['user_logged']['admin']; ?>">
            </div>
            <br>
            <!-- Add more fields for editing other user information -->
            <button type="submit" class="btn btn-primary">Guardar canvis</button>
        </form>
    </div>
</body>

</html>