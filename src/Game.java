import java.util.Random;
import java.util.Scanner;
public class Game {
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static final int LEVEL_CAP = 10;
    private static final int MONSTER_CHANCE = 10; // 10% chance of encountering a monster

    private Player player;
    private Shop shop;

    public Game() {
        player = new Player(getName(), 1, 0, 100, 0, 10, 10);
        shop = new Shop(10,10, 10,10);
    }

    public void play() {
        System.out.println("* Welcome to The Game! *\n");
        while (player.getLevel() < LEVEL_CAP) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the remaining new line character
            switch (choice) {
                case 1:
                    goAdventuring();
                    break;
                case 2:
                    player.showDetails();
                    break;
                case 3:
                    System.out.println("Exiting game...");
                    return; // end the game
                case 4:
                    shop();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        System.out.println("Congratulations! You won The Game!");
    }

    private void shop() {
        System.out.println("Welcome to the shop!");
        System.out.println("You have " + player.getGold() + " gold.");
        System.out.println("1. Buy a strength amulet (-50 gold, +10 attack)");
        System.out.println("2. Buy a defense amulet (-50 gold, -5 taken damage)");
        System.out.println("3. Leave the shop");
        System.out.print("> ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                shop.buyStrengthAmulet(player);
                break;
            case 2:
                shop.buyDefenseAmulet(player);
                break;
            case 3:
                System.out.println("Thank you for visiting the shop!");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    private String getName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    private void displayMainMenu() {
        System.out.println("1. Go adventuring");
        System.out.println("2. Show details about your character");
        System.out.println("3. Exit game");
        System.out.println("4. Visit the shop");
        System.out.print("> ");
    }

    private void goAdventuring() {
        System.out.println("You set out on an adventure...");
        if (rand.nextInt(100) < MONSTER_CHANCE) {
            SpecificMonster monster = SpecificMonster.createRandomMonster(player.getLevel());
            System.out.println("You encountered a " + monster.getName() + "!");
            while (player.getHp() > 0 && monster.getHp() > 0) {
                System.out.println("Player HP: " + player.getHp() + "/" + player.getMaxHp());
                System.out.println(monster.getName() + " HP: " + monster.getHp() + "/" + monster.getHp());
                System.out.println("1. Attack");
                System.out.println("2. Defend");
                System.out.print("> ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the remaining new line character
                switch (choice) {
                    case 1:
                        player.attack(monster);
                        break;
                    case 2:
                        player.defend(monster);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        continue;
                }
                if (monster.getHp() <= 0) {
                    break;
                }
                monster.attack(player);
            }
            if (player.getHp() > 0) {
                System.out.println("You defeated the " + monster.getName() + "!");
                int exp = monster.getExp();
                player.addExp(exp);
                int gold = monster.getGold();
                player.addGold(gold);
                System.out.println("You gained " + exp + " experience and " + gold + " gold!");
            } else {
                System.out.println("You were defeated by the " + monster.getName() + "...");
                gameOver();
                return;
            }
        } else {
            System.out.println("You didn't encounter any monsters.");
            System.out.println("You see nothing but a vast expanse of grassland.");
        }
        int hpGained = rand.nextInt(10) + 1;
        int newHp = Math.min(player.getHp() + hpGained, player.getMaxHp());
        player.setHp(newHp);
        System.out.println("You found a healing fountain and gained " + hpGained + " HP! Your HP is now " + player.getHp() + "/" + player.getMaxHp() + ".");
    }

    private void gameOver() {
        System.out.println("GAME OVER");

        // Check if the player has enough gold to restart the game
        if (player.getGold() >= 5) {
            System.out.println("Would you like to restart the game for 5 gold? (Y/N)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                // Deduct 5 gold from the player's total and restart the game
                player.deductGold(5);
                System.out.println("You have restarted the game for 5 gold.");
                player.reset();
                return;
            }
        }

        // Exit the game if the player chooses not to restart or doesn't have enough gold
        System.exit(0);
    }
}



