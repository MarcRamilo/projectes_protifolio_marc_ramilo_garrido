<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<nav class="py-3 px-2 bg-danger text-white h4 d-flex justify-content-between">
   <div class="left">
      <i class="bi bi-ticket-detailed"><a style="text-decoration: none; " href="../admin/welcome_admin.php">Admin</a></i>
   </div>
   <div class="right">
      <?php if (!isset($_SESSION['user_logged'])) { ?>
         <a href="./login_admin.php" class="text-white text-decoration-none">Login</a>
      <?php } else {  ?>
      <a href="./welcome_admin.php" class="text-white text-decoration-none">Home</a>
      <a href="./logout_admin.php" class="text-white text-decoration-none">LogOut</a>
      <?php } ?>
   </div>
</nav>