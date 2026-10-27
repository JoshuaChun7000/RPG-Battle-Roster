public class Knight extends Combatant implements Specialist{
    private int armor;
    private int maxArmor;
    private int stamina;
    private int maxStamina;
    public Knight(String name, int hp, int armor, int lvl, int stamina,
                  int maxStamina, int maxArmor) {
        super(name, hp, lvl);
        this.armor = armor;
        this.stamina = stamina;
        this.maxStamina = maxStamina;
        this.maxArmor = maxArmor;
    }
    public int getArmor() {
        return armor;
    }
    public void setArmor(int addArmor) {
        armor += addArmor;
    }
    public int getStamina() {return stamina;}
    public void setStamina(int addStamina) {stamina += addStamina;}
    public int getMaxArmor() {return maxArmor;}
    private void setMaxArmor(int newMax) {maxArmor = newMax;}
    private int getMaxStamina() {return maxStamina;}
    private void setMaxStamina(int newMax) {maxStamina = newMax;}
    @Override public String attack(Combatant target){
        int attackDamage = getLvl() * 5;
        target.setHp(-attackDamage);
        return getName() + " swings their sword at " + target.getName() + "! -" +
                attackDamage + " health!\n"
                + target.getName() + "'s current health: " + target.getHp();
    }
    @Override public String takeDamage(){
        return getName() + " tanks a hit!";
    }
    @Override public String levelUp() {
        return getName() + " levels up!";
    }
    @Override public String toString() {
        return "Name: " + getName() +
                "\nHP: " + getHp() +
                "\nlvl: " + getLvl() +
                "\nArmor: " + getArmor();
    }
    @Override public String useSpecialMove1(Combatant target) {
        if (getStamina() >= 2) {
            int attackDamage = getLvl() * 20;
            setStamina(-2);
            target.setHp(-attackDamage);
            setArmor(-1);
            return getName() + " charges into " +
                    target.getName() + "! However, it damages " + getName() +
                    "'s armor. \n-" + attackDamage + " health! " +
                    target.getName() + "'s current health: " + target.getHp() +
                    "\nCurrent armor: " + getArmor();
        } else {
            return getName() + " doesn't have enough stamina left to perform " +
                    "bulwark charge\nCurrent stamina: " + getStamina() + "\n" +
                    "Required stamina: 2";
        }
    }
    @Override public String useSpecialMove2(Combatant target) {
        if (getLvl() >= 10) {
            if (getStamina() >= 4) {
                int attackDamage = getLvl() * 30;
                setStamina(-4);
                target.setHp(-attackDamage);
                return getName() + " swiftly lunges at " +
                        target.getName() + ", piercing him! -" + attackDamage + " health!\n" +
                        target.getName() + "'s current health: " + target.getHp();
            } else {
                return getName() + " doesn't have enough stamina left to perform " +
                        "piercing lunge\nCurrent stamina: " + getStamina() + "\n" +
                        "Required stamina: 4";
            }
        } else {
            return getName() + " is too inexperienced for that move!";
        }
    }
    @Override public String useSpecialMove3(Combatant target) {
        if (getLvl() >= 20) {
            if (getStamina() >= 6) {
                int attackDamage = getLvl() * 50;
                setStamina(-6);
                target.setHp(-attackDamage);
                return getName() + " strikes " +
                        target.getName() + " with his holy sword!\n" +
                        "-" + attackDamage + " health!\n" +
                        target.getName() + "'s current health: " + target.getHp();
            } else {
                return getName() + " doesn't have enough stamina left to perform " +
                        "consecrated cleave\nCurrent stamina: " + getStamina() + "\n" +
                        "Required stamina: 6";
            }
        } else {
            return getName() + " is too inexperienced for that move!";
        }
    }
}
