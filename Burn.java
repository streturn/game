public class Burn extends StatusEffect {

    public Burn(int duration) {
        super(duration);
    }

    @Override
    public void apply(Character target) {
        int dmg = 7;
        System.out.println(target.name + " terkena burn");
        target.takeDamage(dmg);
    }
}