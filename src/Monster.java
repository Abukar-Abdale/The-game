public class Monster {
    private String name;
    private int hp;
    private int exp;



    public Monster(String name, int hp, int exp) {
        this.name = name;
        this.hp = hp;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getExp() {
        return exp;
    }

    public void attack(Player player) {
        int damage = (int) (Math.random() * 10);
        player.setHp(player.getHp() - damage);
        System.out.println("The " + name + " hit you, dealing " + damage + " damage");
    }

public void defend(Player player) {
        int damage = (int) (Math.random() * 10);
        player.setHp(player.getHp() - damage);
        System.out.println("The " + name + " hit you, dealing " + damage + " damage");
    }

}
