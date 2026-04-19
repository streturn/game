public abstract class Character {
    private String name;
    private int hp;
    private int attackDamage;
    private int mana;

    public Character(String name, int hp, int attackDamage, int mana) {
        this.name = name;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.mana = mana;
    }

    // Getter
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAttackDamage() { return attackDamage; }
    public int getMana() { return mana; }

    // Setter
    public void setHp(int hp) { this.hp = hp; }
    public void setMana(int mana) { this.mana = mana; }

    // Attack biasa
    public void attack(Character target) {
        System.out.println("\n" + name + " menyerang " + target.getName());
        System.out.println("Damage: " + attackDamage);
        target.takeDamage(attackDamage);
    }

    // Terima damage
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;

        System.out.println(name + " menerima " + damage + " damage");
        System.out.println("Sisa HP " + name + ": " + hp);
    }

    // Regen mana
    public void regenMana(int amount) {
        mana += amount;
        System.out.println(name + " mendapatkan mana +" + amount +
                           " (Total mana: " + mana + ")");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    // Abstract method
    public abstract void useSkill(Character target, int choice);
}