<?php
if (!isLoggedIn()) redirect('login');
$risultato = null;
$n = null;
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['giorni'])) {
    $n = (int)$_POST['giorni'];
    $dataLimite = date('Y-m-d', strtotime("-$n days"));
    $stmt = $pdo->prepare("SELECT COUNT(*) FROM plichi WHERE data_ritiro >= ?");
    $stmt->execute([$dataLimite]);
    $risultato = $stmt->fetchColumn();
}
?>
<h2>Statistiche plichi ritirati</h2>
<form method="post">
    <input type="number" name="giorni" placeholder="Numero di giorni" required><br>
    <button type="submit">Calcola</button>
</form>
<?php if ($risultato !== null): ?>
    <p>Numero di plichi ritirati negli ultimi <?= $n ?> giorni: <strong><?= $risultato ?></strong></p>
<?php endif; ?>