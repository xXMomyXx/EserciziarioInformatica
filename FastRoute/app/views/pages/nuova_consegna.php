<?php
if (!isLoggedIn()) redirect('login');
$sedi = $pdo->query("SELECT * FROM sedi")->fetchAll();
?>
<h2>Nuova consegna (accettazione)</h2>
<form action="index.php?action=nuova_consegna" method="post">
    <h3>Plico</h3>
    <input type="text" name="codice" placeholder="Codice univoco" required><br>
    <select name="id_sede_partenza" required>
        <option value="">Sede partenza</option>
        <?php foreach($sedi as $s): ?>
            <option value="<?= $s['id_sede'] ?>"><?= htmlspecialchars($s['città']) ?></option>
        <?php endforeach; ?>
    </select><br>
    <select name="id_sede_arrivo" required>
        <option value="">Sede arrivo</option>
        <?php foreach($sedi as $s): ?>
            <option value="<?= $s['id_sede'] ?>"><?= htmlspecialchars($s['città']) ?></option>
        <?php endforeach; ?>
    </select><br>

    <h3>Mittente</h3>
    <input type="text" name="m_nome" placeholder="Nome" required><br>
    <input type="text" name="m_cognome" placeholder="Cognome" required><br>
    <input type="text" name="m_indirizzo" placeholder="Indirizzo" required><br>
    <input type="text" name="m_telefono" placeholder="Telefono" required><br>
    <input type="email" name="m_email" placeholder="Email" required><br>

    <h3>Destinatario</h3>
    <input type="text" name="d_nome" placeholder="Nome" required><br>
    <input type="text" name="d_cognome" placeholder="Cognome" required><br>

    <button type="submit">Registra consegna</button>
</form>