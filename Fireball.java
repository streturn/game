public class Fireball extends Skill {

    public Fireball() {
        super("Fireball", 25);
    }

    @Override
    public void use(Character user, Character target) {
        if (!user.useMana(manaCost)) return;

        int dmg = 30;
        System.out.println(user.name + " menggunakan Fireball");
        target.takeDamage(dmg);

    }
}