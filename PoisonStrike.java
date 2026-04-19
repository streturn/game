public class PoisonStrike extends Skill {

    public PoisonStrike() {
        super("Poison Strike", 15);
    }

    @Override
    public void use(Character user, Character target) {
        if (!user.useMana(manaCost)) return;

        target.takeDamage(15);
        target.addEffect(new Poison(4));
    }
}