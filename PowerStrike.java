public class PowerStrike extends Skill {

    public PowerStrike() {
        super("Power Strike", 20);
    }

    @Override
    public void use(Character user, Character target) {
        if (!user.useMana(getManaCost())) return;

        // ❌ user.attack
        // ✅ pakai getter
        int dmg = user.getAttack() * 2;

        target.takeDamage(dmg);
    }
}