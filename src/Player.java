
public class Player {
    private String name;
    private int level;
    private int exp;
    private int hp;
    private int maxHp;
    private int gold;
    private int strength;
    private int toughness;
    private static final int NEXT_LEVEL_EXP = 100;
    private static final int MAX_LEVEL = 10;

    public Player(String name, int level, int exp, int hp, int gold, int strength, int toughness) {
        this.name = name;
        this.level = 1;
        this.exp = exp;
        this.hp = hp;
        this.maxHp = 200;
        this.gold = gold;
        this.strength = 10;
        this.toughness = 10;
    }


    public int getStrength() {
        return strength;
    }

    public int getToughness() {
        return toughness;
    }


    public int getGold() {
        return gold;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public int getMaxHp() {
        return maxHp;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void attack(SpecificMonster monster) {
        int damage = (int) (Math.random() * 10) + 1 + strength;
        monster.takeDamage(damage);
        System.out.println("You attacked the " + monster.getName() + " for " + damage + " damage!");
    }

    public void defend(SpecificMonster monster) {
        int damageTaken = monster.getDamage() - toughness;
        if (damageTaken > 0) {
            hp -= damageTaken;
            System.out.println("You defended against the " + monster.getName() + " and took " + damageTaken + " damage!");
        } else {
            System.out.println("You successfully defended against the " + monster.getName() + "!");
        }
    }

    public void addExp(int exp) {
        this.exp += exp;
        System.out.println("You gained " + exp + " experience points");
        if (this.exp >= NEXT_LEVEL_EXP) {
            int levelUp = this.exp / NEXT_LEVEL_EXP;
            setLevel(getLevel() + levelUp);
            this.exp -= levelUp * NEXT_LEVEL_EXP;
            System.out.println("You leveled up to level " + getLevel() + "!");
            if (getLevel() >= MAX_LEVEL) {
                System.out.println("You have reached the maximum level!");
            }
        }
    }

    public void addGold(int gold) {
        this.gold += gold;
        System.out.println("You gained " + gold + " gold");
    }


    public void showDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Level: " + getLevel());
        System.out.println("Experience: " + getExp());
        System.out.println("Health: " + getHp());
        System.out.println("Gold: " + getGold());
        System.out.println("Strength: " + getStrength());
        System.out.println("Toughness: " + getToughness());
    }

    public void reset() {
        setHp(getMaxHp());
    }

    public void deductGold(int i) {
        this.gold -= i;
    }

    public void increaseStrength(int i) {
        this.strength += i;
    }

    public void increaseDefense(int i) {
        this.toughness += i;
    }


    public void takeGold(int i) {
        this.gold -= i;
    }

    public void increaseAttack(int i) {
        this.strength += i;
    }

    public void spendGold(int strengthAmuletPrice) {
        this.gold -= strengthAmuletPrice;
    }

}
