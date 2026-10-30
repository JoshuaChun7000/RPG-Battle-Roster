public class Knight extends Combatant implements Specialist{
    private int stamina;
    private int maxStamina;
    private int staminaRegen;
    public Knight(String name, int hp, int maxHp, int lvl, int stamina,
                  int maxStamina, int staminaRegen,
                  boolean buffed, boolean down, boolean stunned) {
        super(name, hp, lvl, maxHp, buffed, down, stunned);
        this.stamina = stamina;
        this.maxStamina = maxStamina;
        this.staminaRegen = staminaRegen;
    }
    public int getStamina() {return stamina;}
    public void setStamina(int addStamina) {
        stamina += addStamina;
        if (stamina < 0) {
            stamina = 0;
        }
        if (stamina > getMaxStamina()) {
            stamina = getMaxStamina();
        }
    }
    public int getMaxStamina() {return maxStamina;}
    public void setMaxStamina() {maxStamina += 1;}
    public int getStaminaRegen() {return staminaRegen;}
    public void setStaminaRegen() {staminaRegen += 1;}
    @Override public String attack(Combatant target){
        if (!getDown()) {
            if (getStunned()) {
                int attackDamage = getLvl() * 5;
                if (getBuffed()) {
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " swings their sword at " + target.getName() + "! -" +
                            attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp();
                } else {
                    attackDamage *= 2;
                    target.setHp(-attackDamage);
                    setBuffed(false);
                    return getName() + " swings their sword at " + target.getName() + " very hard! -" +
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
            setMaxHp(40);
            altSetHp(getMaxHp());
            setStaminaRegen();
            setMaxStamina();
            setStamina(getMaxStamina());
            if (getDown()) {
                setDown(false);
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+40 max health\n" +
                        "+1 stamina regen rate\n" +
                        "+1 max stamina\n" +
                        "Healed to full\n" +
                        "Revived";
            } else {
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+40 max health\n" +
                        "+1 stamina regen rate\n" +
                        "+1 max stamina\n" +
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
                "\nStamina: " + getStamina();
    }
    @Override public String useSpecialMove1(Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                if (getStamina() >= 2) {
                    int attackDamage = getLvl() * 20;
                    setStamina(-2);
                    target.setHp(-attackDamage);
                    target.setStunned(true);
                    return getName() + " rams into " +
                            target.getName() + ", stunning them!\n-" + attackDamage + " health! " +
                            target.getName() + "'s current health: " + target.getHp();
                } else {
                    return getName() + " doesn't have enough stamina left to perform " +
                            "bulwark charge\nCurrent stamina: " + getStamina() + "\n" +
                            "Required stamina: 2";
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
                    if (getStamina() >= 4) {
                        int attackDamage = getLvl() * 30;
                        setStamina(-4);
                        target.setHp(-attackDamage);
                        target.setStunned(false);
                        return getName() + " swiftly lunges at " +
                                target.getName() + ", piercing them! -" + attackDamage + " health!\n" +
                                target.getName() + "'s current health: " + target.getHp();
                    } else {
                        return getName() + " doesn't have enough stamina left to perform " +
                                "piercing lunge\nCurrent stamina: " + getStamina() + "\n" +
                                "Required stamina: 4";
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
                    if (getStamina() >= 6) {
                        int attackDamage = getLvl() * 50;
                        setStamina(-6);
                        target.setHp(-attackDamage);
                        target.setStunned(true);
                        return getName() + " strikes " +
                                target.getName() + " with their holy sword, blinding them!\n" +
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
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
    public void regenerateStamina() {
        setStamina(getStaminaRegen());
    }
}
