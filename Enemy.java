import java.util.*;

public class Enemy extends Character {

    private List<Skill> skills;
    private Random rand = new Random();

    public Enemy(String name) {
        super(name, 120, 60, 25, 20, 15);

        skills = new ArrayList<>();
        skills.add(new Fireball());
    }

    @Override
    public void takeTurn(Character enemy) {
        System.out.println("\n===== GILIRAN ENEMY =====");

        // ❌ mana → private
        // ✅ pakai getter
        if (getMana() >= 15 && rand.nextBoolean()) {
            Skill skill = skills.get(rand.nextInt(skills.size()));
            System.out.println("Enemy menggunakan skill: " + skill.getName());
            skill.use(this, enemy);
        } else {
            System.out.println("Enemy melakukan attack");
            attack(enemy);
        }
    }
}