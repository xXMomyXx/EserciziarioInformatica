<?php
if (!isLoggedIn()) redirect('login');
?>
<h2>Registra spedizione</h2>
<form action="index.php?action=registra_spedizione" method="post">
    <input type="text" name="codice" placeholder="Codice plico" required><br>
    <button type="submit">Registra spedizione</button>
</form>