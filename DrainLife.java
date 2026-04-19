public class DrainLife extends Skill {

    public DrainLife() {
        super("Drain Life", 20);
    }

    @Override
    public void use(Character user, Character target) {
        if (!user.useMana(manaCost)) return;

        int dmg = 20;
        target.takeDamage(dmg);
        user.hp = Math.min(user.maxHp, user.hp + dmg);
    }
}