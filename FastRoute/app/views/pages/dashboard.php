<?php
if (!isLoggedIn()) redirect('login');

$stmt = $pdo->query("
    SELECT p.*, 
           m.nome AS m_nome, m.cognome AS m_cognome,
           d.nome AS d_nome, d.cognome AS d_cognome,
           s1.città AS partenza, s2.città AS arrivo
    FROM plichi p
    JOIN mittenti m ON p.id_mittente = m.id_mittente
    JOIN destinatari d ON p.id_destinatario = d.id_destinatario
    JOIN sedi s1 ON p.id_sede_partenza = s1.id_sede
    JOIN sedi s2 ON p.id_sede_arrivo = s2.id_sede
    ORDER BY p.data_accettazione DESC
");
$plichi = $stmt->fetchAll();
?>
<h2>Dashboard spedizioni</h2>
<table border="1" cellpadding="8" style="width:100%">
    <tr>
        <th>Codice</th><th>Mittente</th><th>Destinatario</th><th>Partenza</th><th>Arrivo</th>
        <th>Accettazione</th><th>Spedizione</th><th>Ritiro</th><th>Stato</th>
    </tr>
    <?php foreach ($plichi as $p): ?>
    <tr>
        <td><?= htmlspecialchars($p['codice']) ?></td>
        <td><?= htmlspecialchars($p['m_nome'] . ' ' . $p['m_cognome']) ?></td>
        <td><?= htmlspecialchars($p['d_nome'] . ' ' . $p['d_cognome']) ?></td>
        <td><?= htmlspecialchars($p['partenza']) ?></td>
        <td><?= htmlspecialchars($p['arrivo']) ?></td>
        <td><?= $p['data_accettazione'] . ' ' . $p['ora_accettazione'] ?></td>
        <td><?= $p['data_spedizione'] ? $p['data_spedizione'] . ' ' . $p['ora_spedizione'] : '-' ?></td>
        <td><?= $p['data_ritiro'] ? $p['data_ritiro'] . ' ' . $p['ora_ritiro'] : '-' ?></td>
        <td><?= $p['data_ritiro'] ? 'Ritirato' : ($p['data_spedizione'] ? 'In transito' : 'In partenza') ?></td>
    </tr>
    <?php endforeach; ?>
</table>