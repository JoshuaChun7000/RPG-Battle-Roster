public class Healer extends Combatant implements Specialist {
    private int healing;
    private int maxHealing;
    public Healer(String name, int hp, int maxHp, int healing, int lvl,
                  int maxHealing , boolean buffed, boolean down, boolean stunned) {
        super(name, hp, lvl, maxHp, buffed, down, stunned);
        this.healing = healing;
        this.maxHealing = maxHealing;
    }
    public int getHealing() {
        return healing;
    }
    public void setHealing(int addHealing) {
        healing+=addHealing;
        if (healing < 0) {
            healing = 0;
        }
        if (healing > getMaxHealing()) {
            healing = getMaxHealing();
        }
    }
    public int getMaxHealing() {return maxHealing;}
    public void setMaxHealing(int addMaxHealing) {maxHealing += addMaxHealing;}
    public int getHealingAmount() {return getLvl() * 50;}
    public int getHealingRegen() {return 1;}
    @Override public String attack(Combatant target){
        if (!getDown()) {
            if (getStunned()) {
                int attackDamage = getLvl() * 2;
                if (getBuffed()) {
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " smacks " + target.getName() + "! -" +
                            attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp();
                } else {
                    attackDamage *= 2;
                    target.setHp(-attackDamage);
                    setBuffed(false);
                    return getName() + " smacks " + target.getName() + " very hard! -" +
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
            setMaxHealing(1);
            setHealing(getMaxHealing());
            if (getDown()) {
                setDown(false);
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+30 max health\n" +
                        "+1 max healing\n" +
                        "Healed to full\n" +
                        "Revived";
            } else {
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+30 max health\n" +
                        "+1 max healing\n" +
                        "Healed to full";
            }
        } else {
            return getName() + " has already reached the maximum level (Level 30)";
        }    }
    @Override public String toString() {
        return "Name: " + getName() +
                "\nHP: " + getHp() +
                "\nlvl: " + getLvl() +
                "\nHealing: " + getHealing();
    }
    @Override public String useSpecialMove1(Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                if (getHealing() >= 1) {
                    setHealing(-1);
                    target.setHp(+getHealingAmount());
                    return getName() + " heals " + target.getName() + " for " + getHealingAmount()
                            + " hp!\n" + target.getName() + "'s current health: " + target.getHp();
                } else {
                    return getName() + " doesn't have enough healing left to perform basic heal\nCurrent healing: " +
                            getHealing() + "\nRequired healing: 1";
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
                    if (getHealing() >= 5) {
                        setHealing(-5);
                        target.setHp(+getHealingAmount());
                        target.setBuffed(true);
                        target.setStunned(false);
                        return getName() + " heals " + target.getName() + " for " + getHealingAmount()
                                + " hp and buffs their attack damage!" +
                                "\n" + target.getName() + "'s current health: " + target.getHp();
                    } else {
                        return getName() + " doesn't have enough healing left to perform basic buff\nCurrent healing: " +
                                getHealing() + "\nRequired healing: 5";
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
                    if (getHealing() >= 20) {
                        setHealing(-20);
                        if (!target.getDown()) {
                            target.altSetHp(target.getMaxHp());
                            target.setStunned(false);
                            return getName() + " heals " + target.getName() +
                                    " for full!" +
                                    "\n" + target.getName() + "'s current health: "
                                    + target.getHp();
                        } else {
                            target.setDown(false);
                            target.setStunned(false);
                            target.altSetHp(target.getMaxHp() / 2);
                            return target.getName() + " is resurrected from the grave!\n" +
                                    target.getName() + "'s current health: " + target.getHp();
                        }
                    } else {
                        return getName() + " doesn't have enough healing " +
                                "left to perform spirit revival\nCurrent healing: " +
                                getHealing() + "\nRequired healing: 20";
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
    public void regenerateHealing() {
        setHealing(getHealingRegen());
    }
}
