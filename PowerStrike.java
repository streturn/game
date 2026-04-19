public class PowerStrike extends Skill {

    public PowerStrike() {
        super("Power Strike", 20);
    }

    @Override
    public void use(Character user, Character target) {
        if (!user.useMana(manaCost)) return;

        int dmg = user.attack * 2;
        target.takeDamage(dmg);
    }
}