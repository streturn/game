import java.util.*;

public class Player extends Character {

    private List<Skill> skills;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        super(name, 120, 60, 25, 20, 15);

        skills = new ArrayList<>();
        skills.add(new PowerStrike());
        skills.add(new Fireball());
        skills.add(new DrainLife());
    }

    @Override
    public void takeTurn(Character enemy) {
        System.out.println("\n===== GILIRAN PLAYER =====");

        showFullStats();
        enemy.showFullStats();

        System.out.println("\n1. Attack");
        System.out.println("2. Skill");
        System.out.print("Pilih aksi: ");

        // ✅ Cegah input bukan angka
        if (!input.hasNextInt()) {
            System.out.println("Input harus angka. Keluar dari game...");
            System.exit(0);
        }

        int choice = input.nextInt();

        // ✅ Kalau bukan 1 atau 2 → keluar
        if (choice != 1 && choice != 2) {
            System.out.println("Pilihan tidak valid. Keluar dari game...");
            System.exit(0);
        }

        if (choice == 1) {
            attack(enemy);
        } else {
            System.out.println("\n=== PILIH SKILL ===");

            for (int i = 0; i < skills.size(); i++) {
                Skill s = skills.get(i);
                System.out.println((i + 1) + ". " + s.getName() +
                        " | Mana: " + s.getManaCost());
            }

            System.out.print("Pilih skill: ");

            // ✅ Cegah input bukan angka
            if (!input.hasNextInt()) {
                System.out.println("Input harus angka. Keluar dari game...");
                System.exit(0);
            }

            int skillChoice = input.nextInt();

            // ✅ Validasi range skill
            if (skillChoice < 1 || skillChoice > skills.size()) {
                System.out.println("Skill tidak valid. Keluar dari game...");
                System.exit(0);
            }

            skills.get(skillChoice - 1).use(this, enemy);
        }
    }
}