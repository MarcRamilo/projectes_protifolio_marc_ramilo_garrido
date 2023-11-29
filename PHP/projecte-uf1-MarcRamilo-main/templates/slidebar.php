<?php
if (!isset($_SESSION)) session_start();
if (!isset($_SESSION['user_logged'])) {
  header("Location: ./login.php");
  die();
}
?>
<nav class="py-3 px-2 bg-danger text-white h4 d-flex justify-content-between">
    <div class="left">
        <i class="bi bi-ticket-detailed"> <a style="text-decoration: none;" href="../welcome.php"> Ticketing</a></i>
    </div>
    <div class="right">
        <?php if (!isset($_SESSION['user_logged'])) { ?>
            <a href="./signup.php" class="text-white text-decoration-none">Registra't</a>
            <a href="./login.php" class="text-white text-decoration-none">Inicia sessió</a>
        <?php } else {  ?>
            <a href="./welcome.php" class="text-white text-decoration-none">Inici</a>
            <a href="./logout.php" class="text-white text-decoration-none">Logout</a>
            <a href="./profile.php" class="text-white text-decoration-none m-4"><?php echo $_SESSION['user_logged']['nom'] ?></a>
        <?php } ?>
    </div>
</nav>
<!-- CSS de Bootstrap -->
<style>
    #sidebar {
        background: #343a40;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
</style>
