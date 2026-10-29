public class Jester extends Combatant implements Specialist {
    private int luck;
    public Jester(String name, int hp, int maxHp, int luck, int lvl, boolean buffed, boolean down) {
        super(name, hp, lvl, maxHp, buffed, down);
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
    public void setLuck(int newLuck) {luck = newLuck;}
    @Override public String attack(Combatant target){
        int attackDamage = getLvl() * 5;
        if (getBuffed()) {
            target.setHp(-attackDamage);
            return getName() + " weakly tackles " + target.getName() + "! -" +
                    attackDamage + " health!\n"
                    + target.getName() + "'s current health: " + target.getHp();
        } else {
            attackDamage *= 2;
            return getName() + " tackles " + target.getName() + " very hard! -" +
                    attackDamage + " health!\n"
                    + target.getName() + "'s current health: " + target.getHp();
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
    @Override public String useSpecialMove1(Combatant target) {
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
    @Override public String useSpecialMove2 (Combatant target) {
        rollLuck();
        if (getLuck() <= 50) {
            target.setStunned(true);
            return getName() + " dances like an idiot and makes " + target.getName()
        }
    }
}
