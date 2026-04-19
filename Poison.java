public class Poison extends StatusEffect {

    public Poison(int duration) {
        super(duration);
    }

    @Override
    public void apply(Character target) {
        int dmg = 5;
        System.out.println(target.name + " terkena poison");
        target.takeDamage(dmg);
    }
}