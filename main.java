import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Player player = new Player("Hero", 100, 10, 30);
        Enemy enemy = new Enemy("Goblin", 80, 8, 0);

        // Tambah skill
        player.addSkill(new Skill("Fireball", 25, 10));
        player.addSkill(new Skill("Lightning Strike", 35, 15));

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n==============================");
            System.out.println("PLAYER : " + player.getName());
            System.out.println("HP     : " + player.getHp());
            System.out.println("MANA   : " + player.getMana());
            System.out.println("------------------------------");
            System.out.println("ENEMY  : " + enemy.getName());
            System.out.println("HP     : " + enemy.getHp());
            System.out.println("==============================");

            System.out.println("\n1. Attack");
            System.out.println("2. Use Skill");
            System.out.print("Pilih aksi: ");
            int action = input.nextInt();

            if (action == 1) {
                player.attack(enemy);
            } else if (action == 2) {
                player.showSkills();
                System.out.print("Pilih skill: ");
                int skillChoice = input.nextInt();
                player.useSkill(enemy, skillChoice);
            } else {
                System.out.println("Pilihan tidak valid");
            }

            // Giliran enemy
            if (enemy.isAlive()) {
                System.out.println("\nGiliran Enemy");
                enemy.attack(player);
            }

            // Regen mana tiap turn
            player.regenMana(5);
        }

        System.out.println("\n===== GAME OVER =====");
        if (player.isAlive()) {
            System.out.println("Player menang");
        } else {
            System.out.println("Enemy menang");
        }

        input.close();
    }
}