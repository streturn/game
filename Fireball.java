public class Fireball extends Skill {

    public Fireball() {
        super("Fireball", 25);
    }

    @Override
    public void use(Character user, Character target) {
        if (!user.useMana(manaCost)) return;

        target.takeDamage(30);
        target.addEffect(new Burn(3));
    }
}