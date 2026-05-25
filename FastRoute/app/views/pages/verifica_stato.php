<?php
if (!isLoggedIn()) redirect('login');
$info = null;
$stato = null;
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['codice'])) {
    $codice = $_POST['codice'];
    $stmt = $pdo->prepare("SELECT * FROM plichi WHERE codice = ?");
    $stmt->execute([$codice]);
    $info = $stmt->fetch();
    if ($info) {
        if ($info['data_ritiro']) $stato = 'Ritirato';
        elseif ($info['data_spedizione']) $stato = 'In transito';
        else $stato = 'In partenza';
    } else {
        $stato = 'Plico non trovato';
    }
}
?>
<h2>Verifica stato plico</h2>
<form method="post">
    <input type="text" name="codice" placeholder="Codice plico" required><br>
    <button type="submit">Verifica</button>
</form>
<?php if ($stato): ?>
    <h3>Risultato</h3>
    <p><strong>Codice:</strong> <?= htmlspecialchars($_POST['codice']) ?></p>
    <p><strong>Stato:</strong> <?= $stato ?></p>
    <?php if ($info): ?>
        <p>Accettato: <?= $info['data_accettazione'] . ' ' . $info['ora_accettazione'] ?></p>
        <?php if($info['data_spedizione']): ?>
            <p>Spedito: <?= $info['data_spedizione'] . ' ' . $info['ora_spedizione'] ?></p>
        <?php endif; ?>
        <?php if($info['data_ritiro']): ?>
            <p>Ritirato: <?= $info['data_ritiro'] . ' ' . $info['ora_ritiro'] ?></p>
        <?php endif; ?>
    <?php endif; ?>
<?php endif; ?>