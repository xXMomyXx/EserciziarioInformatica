<?php
if (!isLoggedIn()) redirect('login');
?>
<h2>Cambia password</h2>
<form action="index.php?action=cambia_password" method="post">
    <input type="password" name="vecchia_password" placeholder="Password attuale" required><br>
    <input type="password" name="nuova_password" placeholder="Nuova password" required><br>
    <input type="password" name="conferma_password" placeholder="Conferma nuova password" required><br>
    <button type="submit">Cambia password</button>
</form>
