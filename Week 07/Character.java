public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void takeDamage(int amount) {
        currentHealth = Math.max(currentHealth - amount, 0);
    }

    public void heal(int amount) {
        currentHealth = Math.min(currentHealth + amount, maxHealth);
    }

    public int getHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After takeDamage(30): " + c.getHealth());
        c.heal(50);
        System.out.println("After heal(50): " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After takeDamage(150): " + c.getHealth());
    }
}