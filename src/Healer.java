public class Healer extends Combatant {
    private int healing;
    public Healer(String name, int hp, int healing, int lvl) {
        super(name, hp, lvl);
        this.healing = healing;
    }
    public int getHealing() {
        return healing;
    }
    public void setHealing(int addHealing) {
        healing+=addHealing;
    }
    @Override public String attack(Combatant target){
        int attackDamage = getLvl() * 5;
        target.setHp(-attackDamage);
        return getName() + " smacks " + target.getName() + "! -" +
                attackDamage + " health!\n"
                + target.getName() + "'s current health: " + target.getHp();
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
                "\nMana: " + getHealing();
    }
}
