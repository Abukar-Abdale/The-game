public class SpecificMonster extends Monster {
    private int gold;
    private static final String[] MONSTER_NAMES = {"Goblin", "Orc", "Troll", "Dragon"};
    private static final int[] MONSTER_HEALTH = {20, 30, 40, 50};
    private static final int[] MONSTER_ATTACK = {10, 15, 20, 25};
    private static final int[] MONSTER_GOLD = {60, 50, 80, 100};

    public SpecificMonster(String name, int hp, int exp, int gold) {
        super(name, hp, exp);
        this.gold = gold;
    }

    public static SpecificMonster createRandomMonster(int level) {
        int monsterIndex = (int) (Math.random() * MONSTER_NAMES.length);
        int monsterHealth = MONSTER_HEALTH[monsterIndex] * level;
        int monsterAttack = MONSTER_ATTACK[monsterIndex] * level;
        int monsterGold = MONSTER_GOLD[monsterIndex] * level;
        String monsterName = MONSTER_NAMES[monsterIndex];
        return new SpecificMonster(monsterName, monsterHealth, monsterAttack, monsterGold);
    }

    public int getGold() {
        return gold;
    }

    @Override
    public int getExp() {
        return super.getExp() + gold;
    }

    public void takeDamage(int damage) {
        super.setHp(super.getHp() - damage);
    }

    public int getDamage() {
        return super.getHp();
    }
}