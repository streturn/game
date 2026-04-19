
public abstract class Character {
    private String name;

    private int maxHp, hp;
    private int maxMana, mana;

    private int attack;
    private int defense;
    private int speed;

    private double critChance;
    private double critDamage;
    private double lifesteal;

    public Character(String name, int hp, int mana, int attack, int defense, int speed) {
        this.name = name;

        this.maxHp = hp;
        this.hp = hp;

        this.maxMana = mana;
        this.mana = mana;

        this.attack = attack;
        this.defense = defense;
        this.speed = speed;

        this.critChance = 0.2;
        this.critDamage = 1.5;
        this.lifesteal = 0.1;
    }

    // ================= GETTER =================
    public String getName() { return name; }

    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }

    public int getMana() { return mana; }
    public int getMaxMana() { return maxMana; }

    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }

    public double getCritChance() { return critChance; }
    public double getCritDamage() { return critDamage; }
    public double getLifesteal() { return lifesteal; }

    // ================= SETTER (AMAN) =================
    public void setHp(int hp) {
        this.hp = Math.max(0, Math.min(maxHp, hp));
    }

    public void setMana(int mana) {
        this.mana = Math.max(0, Math.min(maxMana, mana));
    }

    // ================= LOGIC =================
    public boolean isAlive() {
        return hp > 0;
    }

    public void showFullStats() {
        System.out.println("\n===== " + name.toUpperCase() + " =====");
        System.out.println("HP      : " + hp + "/" + maxHp);
        System.out.println("Mana    : " + mana + "/" + maxMana);
        System.out.println("Attack  : " + attack);
        System.out.println("Defense : " + defense);
        System.out.println("Speed   : " + speed);
        System.out.println("Crit    : " + (critChance * 100) + "%");
        System.out.println("CritDmg : " + critDamage + "x");
        System.out.println("Lifesteal: " + (lifesteal * 100) + "%");
    }

    public void attack(Character target) {
        System.out.println("\n" + name + " menyerang " + target.getName());

        int damage = Math.max(0, attack - target.getDefense());

        boolean crit = false;
        if (Math.random() < critChance) {
            damage *= critDamage;
            crit = true;
        }

        System.out.println("Base Damage : " + attack);
        System.out.println("After Defense: " + damage);

        if (crit) System.out.println("Critical Hit");

        target.takeDamage(damage);

        int heal = (int)(damage * lifesteal);
        setHp(hp + heal);

        if (heal > 0) System.out.println("Lifesteal +" + heal);
    }

    public void takeDamage(int dmg) {
        setHp(hp - dmg);
        System.out.println(name + " HP: " + hp + "/" + maxHp);
    }

    public boolean useMana(int cost) {
        if (mana < cost) {
            System.out.println("Mana tidak cukup");
            return false;
        }
        setMana(mana - cost);
        return true;
    }

    public void regenMana(int amount) {
        setMana(mana + amount);
    }

    public abstract void takeTurn(Character enemy);
}