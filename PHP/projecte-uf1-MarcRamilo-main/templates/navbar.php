<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<nav class="py-3 px-2 bg-danger text-white h4 d-flex justify-content-between">
   <div class="left">
      <i class="bi bi-ticket-detailed"> Ticketing</i>
   </div>
   <div class="right">
      <?php if (!isset($_SESSION['user_logged'])) { ?>
         <a href="./signup.php" class="text-white text-decoration-none">SignUp</a>
         <a href="./login.php" class="text-white text-decoration-none">Login</a>
      <?php } else {  ?>
      <a href="./welcome.php" class="text-white text-decoration-none">Home</a>
      <a href="./logout.php" class="text-white text-decoration-none">LogOut</a>
      <a href="./profile.php" class="text-white text-decoration-none m-4"><?php echo $_SESSION['user_logged']['username'] ?></a>
      <?php } ?>
   </div>
</nav>