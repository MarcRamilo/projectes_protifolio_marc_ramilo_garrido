<?php
if (!isset($_SESSION)) session_start();

if (!isset($_SESSION['user_logged'])) {
    header("Location: ./login_admin.php");
    die();
}

if (isset($_GET['user_id'])) {
    $user_id = $_GET['user_id'];

    // Comprombar si l'usuari existeix
    if (isset($_SESSION['users'][$user_id])) {
        // Borra l'usuari de la sessió
        unset($_SESSION['users'][$user_id]);
    }
}

// Redirecciona a la llista d'usuaris
header("Location: list_users.php");
exit();
?>
