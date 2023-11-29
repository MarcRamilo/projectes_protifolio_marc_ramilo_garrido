<?php 
   // validacio.php
function check_user($username, $pass) {
    if (isset($_SESSION['users']) && is_array($_SESSION['users'])) {
        foreach ($_SESSION['users'] as $key => $user) {
            if ($username == $user['username']) {
                if ($pass == $user['pass']) {
                    // Credencials ok
                    return $_SESSION['users'][$key]; // Retorna la informació d'usuari
                } else {
                    return false; // Contrasenya incorrecta
                }
            }
        }
    }
    return false; // No existeix l'usuari o no hi ha usuaris
}
?>