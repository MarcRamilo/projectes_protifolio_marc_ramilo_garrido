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
  <title>Welcome</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

</head>

<body>
  <?php include_once('./templates/navbar.php') ?>
  <h2>Benvingut/da <?php echo $_SESSION['user_logged']['username'] ?></h2>
  </div>
  <div class="col-4 mx-auto border p-2 bg-danger">
    <button class="mx-auto"><a href="list_users.php">Gestionar Usuaris</a></button>
    <button class="mx-auto"><a href="list_events.php">Gestionar Esdeveniments</a></button>
    <button class="mx-auto"><a href="view_estadistics.php">Veure estadistica</a></button>
  </div>
  <!-- Bootstrap JavaScript Libraries -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
  </script>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
  </script>
</body>

</html>