public class Skill {
    private String name;
    private int damage;
    private int manaCost;

    public Skill(String name, int damage, int manaCost) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public String getName() { return name; }
    public int getDamage() { return damage; }
    public int getManaCost() { return manaCost; }

    public void use(Character user, Character target) {
        if (user.getMana() < manaCost) {
            System.out.println("Mana tidak cukup!");
            return;
        }

        user.setMana(user.getMana() - manaCost);

        System.out.println("\n" + user.getName() + " menggunakan skill " + name);
        System.out.println("Mana tersisa: " + user.getMana());
        System.out.println("Damage: " + damage);

        target.takeDamage(damage);
    }
}