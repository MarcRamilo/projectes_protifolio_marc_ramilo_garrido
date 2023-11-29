<?php
if (!isset($_SESSION)) session_start();
include_once("./verificacio/validacio.php");


if (isset($_POST['sub_signin'])) {
    // Comprova les credencials de l'usuari
    $resposta = check_user($_POST['username'], $_POST['pass']);

    if ($resposta === false) {
        // Login incorrecte o usuari no existeix
        $missatge_error = "Credencials incorrectes o no existeix el usuari";

        // Eliminar les cookies del'usuari anterior
        unset($_SESSION['user_logged']);
    } elseif (is_array($resposta)) {
        // Login exitos
        // Netejar qualsevol cookie anterior de l'usuari anterior
        unset($_SESSION['user_logged']);
        $_SESSION['user_logged'] = $resposta;
        header("Location: ./welcome.php");
        die();
    }
}
?>

<!doctype html>
<html lang="en">

<head>
    <title>Login client</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

</head>

<body>
    <?php include_once('templates/navbar.php') ?>
    <?php
    // Mostra missatge flash si existeix (i el borra)
    if (isset($_SESSION['flash'])) {
        $missatge = $_SESSION['flash'];
        echo "<div class='alert alert-success'>$missatge</div>";
        unset($_SESSION['flash']);
    }
    if (isset($missatge_error)) {
        echo "<div class='alert alert-danger'>$missatge_error</div>";
        unset($missatge_error);
    }
    ?>
    <div class="mb-3 text-white mt-5">
        <form class="col-4 mx-auto border p-2 bg-danger" action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
        <div class="mb-3">
            <label for="username" class="form-label ">Username</label>
            <input type="text" value="<?php echo $_POST['username'] ?? null; ?>" class="form-control" name="username" id="username" aria-describedby="helpId" placeholder="">
        </div>

        <div class="mb-3">
            <label for="pass" class="form-label">Contrasenya</label>
            <input type="password" class="form-control" name="pass" id="pass" aria-describedby="helpId" placeholder="">
        </div>
        <button type="submit" name="sub_signin" class="btn btn-primary mt-2">LogiIn</button>
        <button type="reset" class="btn btn-secondary mt-2">Reset</button>

        <p class="mt-2">No estàs registrat? <a href="signup.php" class="link-primary ">Registre't</a></p>
        </form>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
    </script>
</body>

</html>