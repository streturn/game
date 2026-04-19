import java.util.ArrayList;

public class Player extends Character {
    private ArrayList<Skill> skills;

    public Player(String name, int hp, int attackDamage, int mana) {
        super(name, hp, attackDamage, mana);
        skills = new ArrayList<>();
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void showSkills() {
        System.out.println("\nDaftar Skill:");
        for (int i = 0; i < skills.size(); i++) {
            Skill s = skills.get(i);
            System.out.println((i + 1) + ". " + s.getName() +
                " (Damage: " + s.getDamage() +
                ", Mana: " + s.getManaCost() + ")");
        }
    }

    @Override
    public void useSkill(Character target, int choice) {
        if (choice < 1 || choice > skills.size()) {
            System.out.println("Skill tidak valid");
            return;
        }

        Skill selectedSkill = skills.get(choice - 1);
        selectedSkill.use(this, target);
    }
}