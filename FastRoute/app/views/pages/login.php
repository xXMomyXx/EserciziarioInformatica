<?php if (!isLoggedIn()): ?>
    <p><a href="index.php?page=home">← Torna alla home pubblica</a></p>
    <h2>Login Operatore</h2>
    <form action="index.php?action=login" method="post">
        <input type="email" name="email" placeholder="Email" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <button type="submit">Accedi</button>
    </form>
<?php else: ?>
    <p>Sei già loggato. <a href="index.php?page=dashboard">Vai alla dashboard</a></p>
<?php endif; ?>