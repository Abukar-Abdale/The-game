public class Shop {
    private int strengthAmuletPrice;
    private int defenseAmuletPrice;
    private int strengthAmuletEffect;
    private int defenseAmuletEffect;

    public Shop(int strengthAmuletPrice, int defenseAmuletPrice, int strengthAmuletEffect, int defenseAmuletEffect) {
        this.strengthAmuletPrice = strengthAmuletPrice;
        this.defenseAmuletPrice = defenseAmuletPrice;
        this.strengthAmuletEffect = strengthAmuletEffect;
        this.defenseAmuletEffect = defenseAmuletEffect;
    }

    public void buyStrengthAmulet(Player p) {
        if (p.getGold() >= strengthAmuletPrice) {
            p.spendGold(strengthAmuletPrice);
            p.increaseAttack(strengthAmuletEffect);
            System.out.println(p.getName() + " bought a strength amulet!");
        } else {
            System.out.println("Not enough gold to buy the strength amulet!");
        }
    }

    public void buyDefenseAmulet(Player p) {
        if (p.getGold() >= defenseAmuletPrice) {
            p.spendGold(defenseAmuletPrice);
            p.increaseDefense(defenseAmuletEffect);
            System.out.println(p.getName() + " bought a defense amulet!");
        } else {
            System.out.println("Not enough gold to buy the defense amulet!");
        }
    }

}