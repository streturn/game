import java.util.*;

public class Player extends Character {

    private List<Skill> skills;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        super(name, 120, 60, 20, 10, 15);

        skills = new ArrayList<>();
        skills.add(new PowerStrike());
        skills.add(new Fireball());
        skills.add(new PoisonStrike());
        skills.add(new DrainLife());
    }

    @Override
    public void takeTurn(Character enemy) {
        System.out.println("\n===== GILIRAN PLAYER =====");

        showFullStats();
        enemy.showFullStats();

        System.out.println("\n1. Attack");
        System.out.println("2. Skill");

        int choice = input.nextInt();

        if (choice == 1) {
            attack(enemy);
        } else {
            for (int i = 0; i < skills.size(); i++) {
                Skill s = skills.get(i);
                System.out.println((i + 1) + ". " + s.getName() +
                        " | Mana: " + s.getManaCost());
            }

            int skillChoice = input.nextInt();
            skills.get(skillChoice - 1).use(this, enemy);
        }
    }
}