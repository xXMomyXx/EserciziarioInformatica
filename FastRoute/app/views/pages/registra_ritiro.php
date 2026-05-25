<?php
if (!isLoggedIn()) redirect('login');
?>
<h2>Registra ritiro</h2>
<form action="index.php?action=registra_ritiro" method="post">
    <input type="text" name="codice" placeholder="Codice plico" required><br>
    <button type="submit">Registra ritiro</button>
</form>