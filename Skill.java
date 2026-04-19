public abstract class Skill {
    protected String name;
    protected int manaCost;

    public Skill(String name, int manaCost) {
        this.name = name;
        this.manaCost = manaCost;
    }

    public abstract void use(Character user, Character target);

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }
}