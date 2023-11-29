<?php
if (!isset($_SESSION)) session_start(); // Inicia la sesión si no está ya iniciada

// Verifica que el formulari ha set enviat
if (isset($_POST['sub_signup'])) {
    // Recoll les dades del formulari
    $username = $_POST['username'];
    $nom = $_POST['nom'];
    $cognoms = $_POST['cognoms'];
    $birthdate = $_POST['birthdate'];
    $pass1 = $_POST['pass1'];
    $pass2 = $_POST['pass2'];
    $admin = isset($_POST['admin']) && $_POST['admin'] == 'on'; // Comprobar si s'ha marcat com a admin

    // Validar que les contrasenyes coincideixen
    if ($pass1 !== $pass2) {
        $missatge_flash = "Les contrasenyes no coincideixen.";
    } else {
        // Crea array d'usuaris
        $user = array(
            "username" => $username,
            "nom" => $nom,
            "cognom" => $cognoms,
            "birthdate" => $birthdate, 
            "pass" => $pass1, 
            "admin" => $admin
        );
        $birthdate_object = DateTime::createFromFormat("Y-m-d", $birthdate);
        if ($birthdate_object === false) {
            $missatge_flash = "Format de data invàlid.";
        } else {
            $user['birthdate'] = $birthdate_object; // Asigna l'objete DateTime
        }
        // Verifica si l'usuario ja existeix
        $usuariExisteix = false;
        if (!isset($_SESSION['users'])) {
            $_SESSION['users'] = array();
        }
        foreach ($_SESSION['users'] as $user_id => $stored_user) {
            if ($stored_user['username'] == $username) {
                $usuariExisteix = true;
                break;
            }
        }

        // Si el usuario ja exitex, mostrar error
        if ($usuariExisteix) {
            $missatge_flash = "L'usuari ja existeix";
        } else {
            // Si no, afageix l'usuari a la sessió
            $_SESSION['users'][] = $user;
            $_SESSION['flash'] = "L'usuari s'ha creat correctament";
            header("Location: ./list_users.php"); //Redirigueix a llistat d'usuaris
            exit(); 
        }
    }
}
?>
<!doctype html>
<html lang="en">

<head>
    <title>Registre d'Usuari</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>

<body>
    <?php include_once('templates/navbar.php'); ?>

    <div class="container mt-5">
        <div class="row">
            <div class="col-12 col-md-8 col-lg-6 mx-auto">
                <div class="card shadow">
                    <div class="card-body">
                        <h2 class="card-title">Afegeix Usuari</h2>
                        <?php if (isset($missatge_flash)) {
                            echo "<div class='alert alert-danger'>$missatge_flash</div>";
                        } ?>
                        <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
                            <div class="mb-3">
                                <label for="nom" class="form-label">Nom</label>
                                <input type="text" value="<?php echo $_POST['nom'] ?? null; ?>" class="form-control" name="nom" id="nom" value="<?php echo $_POST['nom'] ?? ''; ?>" required>
                            </div>
                            <div class="mb-3">
                                <label for="cognoms" class="form-label">Cognoms</label>
                                <input type="text" value="<?php echo $_POST['cognoms'] ?? null; ?>" class="form-control" name="cognoms" id="cognoms" value="<?php echo $_POST['cognoms'] ?? ''; ?>" required>
                            </div>
                            <div class="mb-3">
                                <label for="username" class="form-label">Username</label>
                                <input type="text" value="<?php echo $_POST['username'] ?? null; ?>" class="form-control" name="username" id="username" value="<?php echo $_POST['username'] ?? ''; ?>" required>
                            </div>
                            <div class="mb-3">
                                <label for="birthdate" class="form-label">Data de naixement</label>
                                <input type="date" value="<?php echo $_POST['birthdate'] ?? null; ?>" class="form-control" name="birthdate" id="birthdate" value="<?php echo $_POST['birthdate'] ?? ''; ?>" required>
                            </div>
                            <div class="mb-3">
                                <label for="pass1" class="form-label">Contrasenya</label>
                                <input type="password"  class="form-control" name="pass1" id="pass1" required>
                            </div>
                            <div class="mb-3">
                                <label for="pass2" class="form-label">Repeteix Contrasenya</label>
                                <input type="password"  class="form-control" name="pass2" id="pass2" required>
                            </div>
                            <div class="mb-3 form-check">
                                <input type="checkbox" class="form-check-input" id="admin" name="admin">
                                <label class="form-check-label" for="admin">Es admin?</label>
                            </div>
                            <button type="submit" name="sub_signup" class="btn btn-primary">Desa</button>
                            <button type="reset" class="btn btn-secondary">Neteja</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
    </script>
</body>

</html>