public class Jester extends Combatant {
    private double luck;
    public Jester(String name, int hp, double luck, int lvl) {
        super(name, hp, lvl);
        this.luck = luck;
    }
    public double getLuck() {
        return luck;
    }
    public void rollLuck() {
        int min = 0;
        int max = 100;
        luck = (int) (Math.random() * (max - min + 1)) + min;
    }
    @Override public String attack(Combatant target){
        rollLuck();
        if (getLuck() <= 5) {
            int attackDamage = getLvl()*50;
            target.setHp(-attackDamage);
            return getName() + " shoots " + target.getName() +
                    " with their Deagle! -" +
                    attackDamage + " health!\n"
                    + target.getName() + "'s current health: " + target.getHp();
        } else if (getLuck() <= 20 && getLuck() > 5) {
            int attackDamage = getLvl()*15;
            target.setHp(-attackDamage);
            return getName() + " swings a massive katana at " + target.getName() +
                    "! -" + attackDamage + " health!\n"
                    + target.getName() + "'s current health: " + target.getHp();
        } else if (getLuck() <= 50 && getLuck() > 20) {
            int attackDamage = getLvl()*10;
            target.setHp(-attackDamage);
            return getName() + " throws playing cards at " + target.getName() +
                    "! -" + attackDamage + " health!\n"
                    + target.getName() + "'s current health: " + target.getHp();
        } else {
            return getName() + " picks their nose!";
        }
    }
    @Override public String takeDamage(){
        return getName() + " takes a hit!";
    }
    @Override public String levelUp() {
        return getName() + " levels up!";
    }
    @Override public String toString() {
        return "Name: " + getName() +
                "\nHP: " + getHp() +
                "\nlvl: " + getLvl() +
                "\nMana: " + getLuck();
    }
}
