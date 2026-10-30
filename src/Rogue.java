public class Rogue extends Combatant implements Specialist{
    private int stealth;
    private int stealthRegen;

    public Rogue(String name, int hp, int lvl, int maxHp, int stealth,
                 int stealthRegen, boolean buffed, boolean down, boolean stunned) {
        super(name, hp, lvl, maxHp, buffed, down, stunned);
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
        if (!getDown()) {
            if (getStunned()) {
                int attackDamage = getLvl() * 7;
                if (getBuffed()) {
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " stabs " + target.getName() + "! -" +
                            attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp();
                } else {
                    attackDamage *= 2;
                    target.setHp(-attackDamage);
                    setBuffed(false);
                    return getName() + " stabs " + target.getName() + " very hard! -" +
                            attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp();
                }
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
    @Override public String levelUp() {
        if (getLvl() < 30) {
            setLvl(1);
            setMaxHp(30);
            altSetHp(getMaxHp());
            setStealthRegen(5);
            if (getDown()) {
                setDown(false);
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+30 max health\n" +
                        "+5 stealth regen rate\n" +
                        "Healed to full\n" +
                        "Revived";
            } else {
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+30 max health\n" +
                        "+5 stealth regen rate\n" +
                        "Healed to full";
            }
        } else {
            return getName() + " has already reached the maximum level (Level 30)";
        }
    }
    @Override public String toString() {
        return "Name: " + getName() +
                "\nHP: " + getHp() +
                "\nlvl: " + getLvl() +
                "\nStealth: " + getStealth();
    }
    @Override public String useSpecialMove1(Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                if (getStealth() >= 30) {
                    int attackDamage = getLvl() * 30;
                    setStealth(-30);
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " sneaks behind " +
                            target.getName() + " and stabs them!\n-" + attackDamage + " health! " +
                            target.getName() + "'s current health: " + target.getHp();
                } else {
                    return getName() + " isn't stealthy enough to perform " +
                            "backstab\nCurrent stealth: " + getStealth() + "\n" +
                            "Required stealth: 30";
                }
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
    @Override public String useSpecialMove2(Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                if (getLvl() >= 10) {
                    if (getStealth() >= 50) {
                        int attackDamage = getLvl() * 50;
                        setStealth(-50);
                        target.setHp(-attackDamage);
                        target.setStunned(false);
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
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
    @Override public String useSpecialMove3(Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                if (getLvl() >= 20) {
                    if (getStealth() == getMaxStealth()) {
                        int attackDamage = target.getHp();
                        setStealth(-100);
                        target.setHp(-attackDamage);
                        target.setStunned(false);
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
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
    public void regenerateStealth() {
        setStealth(getStealthRegen());
    }
}
