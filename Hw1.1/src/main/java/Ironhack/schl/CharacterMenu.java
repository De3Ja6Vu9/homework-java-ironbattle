package Ironhack.schl;

import java.util.Scanner;

public class CharacterMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character character1 = null;
        Character character2 = null;

        while (true) {
            System.out.println("Character Menu:");
            System.out.println("1. Create Warrior");
            System.out.println("2. Create Wizard");
            System.out.println("3. Start Battle");
            System.out.println("3. Exit");
            System.out.print("Enter your choice between 1 and 4: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    character1 = createWarrior(scanner);
                    break;
                case 2:
                    character2 = createWizard(scanner);
                    break;
                case 3:
                    if (character1 != null && character2 != null) {
                        startBattle(character1, character2);
                    } else {
                        System.out.println("Please create both characters before starting the battle.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Character createWarrior(Scanner scanner) {
        System.out.print("Enter warrior's name: ");
        String name = scanner.next();
        System.out.print("Enter warrior's HP: ");
        int hp = scanner.nextInt();
        System.out.print("Enter warrior's strength: ");
        int strength = scanner.nextInt();
        System.out.print("Enter warrior's stamina: ");
        int stamina = scanner.nextInt();
        return new Warrior(name, hp, strength, stamina);
    }

    private static Character createWizard(Scanner scanner) {
        System.out.print("Enter wizard's name: ");
        String name = scanner.next();
        System.out.print("Enter wizard's HP: ");
        int hp = scanner.nextInt();
        System.out.print("Enter wizard's mana: ");
        int mana = scanner.nextInt();
        System.out.print("Enter wizard's intelligence: ");
        int intelligence = scanner.nextInt();
        return new Wizard(name, hp, mana, intelligence);
    }


    private static void startBattle(Character character1, Character character2) {
        while (character1.isAlive() && character2.isAlive()) {
            character1.attack(character2);
            if (!character2.isAlive()) {
                break;
            }
            character2.attack(character1);
        }

        if (character1.isAlive()) {
            System.out.println(character1.getName() + " wins the battle!");
        } else {
            System.out.println(character2.getName() + " wins the battle!");
        }
    }
}
