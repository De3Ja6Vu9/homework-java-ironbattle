import java.util.Random;

// This Warrior class represents a warrior character in the game.
// It extends the Character class and implements the Attacker interface.
public class Warrior extends Character implements Attacker {
    // Stamina is used to perform attacks.
    private int stamina;
    // Strength determines the power of the warrior's attacks.
    private int strength;
    // Random number generator used for various random behaviors in methods.
    private static final Random rand = new Random();

    // Constructor for the Warrior class.
    // Initializes a new Warrior with the given name, hp, stamina, and strength.
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp); // Call to the superclass constructor (Character)
        this.stamina = stamina; // Initialize the warrior's stamina
        this.strength = strength; // Initialize the warrior's strength
    }

    // Getter for stamina.
    public int getStamina() {
        return stamina;
    }

    // Getter for strength.
    public int getStrength() {
        return strength;
    }

    // Setter for stamina.
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    // Setter for strength.
    public void setStrength(int strength) {
        this.strength = strength;
    }

    // The attack method, as required by the Attacker interface.
    // Determines whether to perform a heavy or weak attack based on the warrior's current stamina,
    // then adjusts the target's HP and the warrior's stamina accordingly.
    @Override
    public void attack(Character target) {
        boolean heavyAttack = rand.nextBoolean(); // Decide randomly whether to perform a heavy attack
        if (heavyAttack && stamina >= 5) { // If a heavy attack is chosen and the warrior has enough stamina...
            target.setHp(target.getHp() - strength); // ...reduce the target's HP by the warrior's strength...
            stamina -= 5; // ...and decrease the warrior's stamina by 5.
            System.out.println(getName() + " performs a Heavy attack on " + target.getName() + " for " + strength + " damage.");
        } else if (stamina > 0) { // If the warrior doesn't have enough stamina for a heavy attack but can perform a weak attack...
            int weakDamage = strength / 2; // ...calculate the damage for a weak attack...
            target.setHp(target.getHp() - weakDamage); // ...reduce the target's HP by the weak damage...
            stamina += 1; // ...and increase the warrior's stamina by 1.
            System.out.println(getName() + " performs a Weak attack on " + target.getName() + " for " + weakDamage + " damage.");
        } else { // If the warrior doesn't have enough stamina for any attack...
            stamina += 2; // ...recover 2 stamina.
            System.out.println(getName() + " is out of stamina and recovers 2 stamina.");
        }
    }
}

