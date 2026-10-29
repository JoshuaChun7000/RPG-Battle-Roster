public class Rogue extends Combatant implements Specialist{
    private int stealth;
    private int stealthRegen;

    public Rogue(String name, int hp, int lvl, int maxHp, int stealth,
                 int stealthRegen, boolean buffed, boolean down) {
        super(name, hp, lvl, maxHp, buffed, down);
        this.stealth = stealth;
        this.stealthRegen = stealthRegen;
    }
    public int getMaxStealth() {return 100;}
    public int getStealthRegen() {return stealthRegen;}
    public void setStealthRegen(int addStealthRegen) {stealthRegen += addStealthRegen;}
    public int getStealth() {return stealth;}
    public void setStealth(int addStealth) {
        stealth += addStealth;
        if (stealth < 0) {
            stealth = 0;
        }
        if (stealth > getMaxStealth()) {
            stealth = getMaxStealth();
        }
    }
    @Override public String attack(Combatant target){
        int attackDamage = getLvl() * 10;
        if (getBuffed()) {
            target.setHp(-attackDamage);
            return getName() + " stabs " + target.getName() + "! -" +
                    attackDamage + " health!\n"
                    + target.getName() + "'s current health: " + target.getHp();
        } else {
            attackDamage *= 2;
            target.setHp(-attackDamage);
            return getName() + " stabs " + target.getName() + " very hard! -" +
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
                "\nStealth: " + getStealth();
    }
    @Override public String useSpecialMove1(Combatant target) {
        if (getStealth() >= 30) {
            int attackDamage = getLvl() * 30;
            setStealth(-30);
            target.setHp(-attackDamage);
            return getName() + " sneaks behind " +
                    target.getName() + " and stabs them!\n-" + attackDamage + " health! " +
                    target.getName() + "'s current health: " + target.getHp();
        } else {
            return getName() + " isn't stealthy enough to perform " +
                    "backstab\nCurrent stealth: " + getStealth() + "\n" +
                    "Required stealth: 30";
        }
    }
    @Override public String useSpecialMove2(Combatant target) {
        if (getLvl() >= 10) {
            if (getStealth() >= 50) {
                int attackDamage = getLvl() * 50;
                setStealth(-50);
                target.setHp(-attackDamage);
                return getName() + " drops from the sky and slashes " +
                        target.getName() + "'s back!\n-" + attackDamage + " health!\n" +
                        target.getName() + "'s current health: " + target.getHp();
            } else {
                return getName() + " isn't stealthy enough to perform " +
                        "ambush\nCurrent stealth: " + getStealth() + "\n" +
                        "Required stealth: 50";
            }
        } else {
            return getName() + " is too inexperienced for that move!";
        }
    }
    @Override public String useSpecialMove3(Combatant target) {
        if (getLvl() >= 20) {
            if (getStealth() == getMaxStealth()) {
                int attackDamage = target.getHp();
                setStealth(-100);
                target.setHp(-attackDamage);
                return target.getName() + "'s shadow manifests as " + getName() +
                        ", slitting their throat before they can react\n-" +
                        attackDamage + " health!\n" + target.getName() +
                        "'s current health: " + target.getHp();
            } else {
                return getName() + " isn't stealthy enough to perform " +
                        "shadow slash\nCurrent stealth: " + getStealth() + "\n" +
                        "Required stealth: " + getMaxStealth();
            }
        } else {
            return getName() + " is too inexperienced for that move!";
        }
    }
}
