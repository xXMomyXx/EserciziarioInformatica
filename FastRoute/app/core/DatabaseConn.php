<?php
class DatabaseConn {
    private static $instance = null;
    private $pdo;
    private function __construct() {
        global $pdo;
        $this->pdo = $pdo;
    }
    public static function getInstance() {
        if (self::$instance === null) {
            self::$instance = new DatabaseConn();
        }
        return self::$instance;
    }
    public function getConnection() {
        return $this->pdo;
    }
}
?>
