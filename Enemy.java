public class Enemy extends Character {

    public Enemy(String name, int hp, int attackDamage, int mana) {
        super(name, hp, attackDamage, mana);
    }

    @Override
    public void useSkill(Character target, int choice) {
        System.out.println("Enemy tidak memiliki skill");
    }
}