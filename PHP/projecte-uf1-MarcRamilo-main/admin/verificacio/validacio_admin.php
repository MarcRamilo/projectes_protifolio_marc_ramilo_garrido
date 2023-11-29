<?php
function check_user($username, $pass) {
    // Comprobar las credenciales del administrador
    if ($username == "admin" && $pass == "admin1234") {
        return ['username' => $username, 'pass' => $pass, 'admin' => true];
    }

    // Comprobar si los usuarios de sesión están definidos para evitar errores de índice indefinido
    if (isset($_SESSION['users'])) {
        foreach ($_SESSION['users'] as $user) {
            // Verificar el nombre de usuario
            if ($username == $user['username']) {
                // Verificar la contraseña, asumiendo que es texto plano aquí
                if ($pass == $user['pass']) {
                    // Comprobar si el usuario es administrador
                    if (isset($user['admin']) && $user['admin']) {
                        // Devolver el array de usuario con el estado de administrador
                        return $user;
                    } else {
                        // Si el usuario no es admin, agregar un mensaje al arreglo y devolverlo
                        $user['message'] = "L'usuari no es admin";
                        return $user;
                    }
                }
            }
        }
    }
    
    // Devolver null si las credenciales son incorrectas o el usuario no se encuentra
    return null;
}

?>