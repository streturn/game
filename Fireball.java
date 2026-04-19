public class Fireball extends Skill {

    public Fireball() {
        super("Fireball", 25);
    }

    @Override
    public void use(Character user, Character target) {
        if (!user.useMana(getManaCost())) return;

        int dmg = 30;

        // ❌ user.name
        // ✅ pakai getter
        System.out.println(user.getName() + " menggunakan Fireball");

        target.takeDamage(dmg);
    }
}