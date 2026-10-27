public class Rogue extends Combatant{
    private int bonusDamage;
    public Rogue(String name, int hp, int additionalDamage, int lvl) {
        super(name, hp, lvl);
        this.bonusDamage = additionalDamage;
    }
    public int getBonusDamage() {
        return bonusDamage;
    }
    public void setBonusDamage(int addBonusDamage) {
        bonusDamage+=addBonusDamage;
    }
    @Override public String attack(Combatant target){
        int attackDamage = getLvl() + getBonusDamage();
        target.setHp(-attackDamage);
        return getName() + " stabs " + target.getName() + "! -" +
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
                "\nMana: " + getBonusDamage();
    }
}
