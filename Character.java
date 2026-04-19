import java.util.*;

public abstract class Character {
    protected String name;

    protected int maxHp, hp;
    protected int maxMana, mana;

    protected int attack;
    protected int defense;
    protected int speed;

    protected double critChance;
    protected double critDamage;
    protected double lifesteal;

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
        System.out.println("\n" + name + " menyerang " + target.name);

        int damage = Math.max(0, attack - target.defense);

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
        hp = Math.min(maxHp, hp + heal);

        if (heal > 0) System.out.println("Lifesteal +" + heal);
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        hp = Math.max(0, hp);
        System.out.println(name + " HP: " + hp + "/" + maxHp);
    }

    public boolean useMana(int cost) {
        if (mana < cost) {
            System.out.println("Mana tidak cukup");
            return false;
        }
        mana -= cost;
        return true;
    }

    public void regenMana(int amount) {
        mana = Math.min(maxMana, mana + amount);
    }
    public abstract void takeTurn(Character enemy);
}