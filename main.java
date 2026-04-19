public class main {
    public static void main(String[] args) {

        Player player = new Player("Hero");
        Enemy enemy = new Enemy("Goblin");

        while (player.isAlive() && enemy.isAlive()) {

            System.out.println("\n====================================");
            System.out.println("              TURN START            ");
            System.out.println("====================================");

            player.applyEffects();
            enemy.applyEffects();

            System.out.println("\n[PLAYER STATUS]");
            player.showFullStats();

            System.out.println("\n[ENEMY STATUS]");
            enemy.showFullStats();

            System.out.println("\n------------------------------------");

            if (player.speed >= enemy.speed) {
                player.takeTurn(enemy);
                if (enemy.isAlive()) enemy.takeTurn(player);
            } else {
                enemy.takeTurn(player);
                if (player.isAlive()) player.takeTurn(enemy);
            }

            System.out.println("\n[END TURN]");
            player.regenMana(5);
        }

        System.out.println("\n===== GAME SELESAI =====");
        if (player.isAlive()) {
            System.out.println("PLAYER MENANG");
        } else {
            System.out.println("ENEMY MENANG");
        }
    }
}